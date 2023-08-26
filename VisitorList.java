package j2ee.lab02;

import java.util.ArrayList;
import java.util.List;

public class VisitorList {
    private List<Visitor> visitors = new ArrayList<Visitor>();

    public void addVisitor(Visitor visitor) {
        visitors.add(visitor);
    }

    public List<Visitor> getVisitors() {
        return visitors;
    }

    public List<Visitor> getVisitorsByHouse(String houseNo) {
        List<Visitor> houseVisitors = new ArrayList<Visitor>();
        for (Visitor visitor : visitors) {
            if (visitor.getHouseNo().equals(houseNo)) {
                houseVisitors.add(visitor);
            }
        }
        return houseVisitors;
    }

    public List<Visitor> getPendingVisitors() {
        List<Visitor> pendingVisitors = new ArrayList<Visitor>();
        for (Visitor visitor : visitors) {
            if (visitor.getApprovalStatus() == ApprovalStatus.PENDING) {
                pendingVisitors.add(visitor);
            }
        }
        return pendingVisitors;
    }
}

