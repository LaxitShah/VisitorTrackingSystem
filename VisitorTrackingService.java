package j2ee.lab02;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VisitorTrackingService {
    private Map<String, House> houseMap = new HashMap<String, House>();
    private VisitorList visitorList = new VisitorList();

    public void addHouse(House house) {
        houseMap.put(house.getHouseNo(), house);
    }

    public void addVisitor(Visitor visitor) {
        visitorList.addVisitor(visitor);
        // Logic to send approval request to house contact and handle responses
    }

    public void approveVisitor(String visitorId) {
        Visitor visitor = getVisitor(visitorId);
        if (visitor != null) {
            visitor.setApprovalStatus(ApprovalStatus.APPROVED);
        }
    }

    public Visitor getVisitor(String visitorId) {
        for (Visitor visitor : visitorList.getVisitors()) {
            if (visitor.getVisitorId().equals(visitorId)) {
                return visitor;
            }
        }
        return null;
    }

    public House getHouse(String houseNo) {
        return houseMap.get(houseNo);
    }

    public List<Visitor> getVisitorsDay(LocalDate date) {
        List<Visitor> result = new ArrayList<Visitor>();
        for (Visitor visitor : visitorList.getVisitors()) {
            if (visitor.getEntryTime().toLocalDate().equals(date)) {
                result.add(visitor);
            }
        }
        return result;
    }

    public List<Visitor> getVisitorsPendingApproval(LocalDate fromDate, LocalDate toDate) {
        List<Visitor> result = new ArrayList<Visitor>();
        for (Visitor visitor : visitorList.getVisitors()) {
            if (visitor.getApprovalStatus() == ApprovalStatus.PENDING &&
                visitor.getEntryTime().toLocalDate().isAfter(fromDate.minusDays(1)) &&
                visitor.getEntryTime().toLocalDate().isBefore(toDate.plusDays(1))) {
                result.add(visitor);
            }
        }
        return result;
    }

    public List<Visitor> getVisitorsUnApprovedLeft(LocalDate fromDate, LocalDate toDate) {
        List<Visitor> result = new ArrayList<Visitor>();
        for (Visitor visitor : visitorList.getVisitors()) {
            if (visitor.getApprovalStatus() == ApprovalStatus.DECLINED &&
                visitor.getExitTime() != null &&
                visitor.getExitTime().toLocalDate().isAfter(fromDate.minusDays(1)) &&
                visitor.getExitTime().toLocalDate().isBefore(toDate.plusDays(1))) {
                result.add(visitor);
            }
        }
        return result;
    }
    
    public List<Visitor> getVisitorsByHouse(String houseNo) {
        return visitorList.getVisitorsByHouse(houseNo);
    }

    public List<Visitor> getPendingVisitors() {
        return visitorList.getPendingVisitors();
    }

}
