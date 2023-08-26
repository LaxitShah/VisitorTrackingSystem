package j2ee.lab02;

import java.time.LocalDateTime;

enum ApprovalStatus {
    PENDING,
    APPROVED,
    DECLINED
}

public class Visitor {
    private String visitorId;
    private String name;
    private String contactNumber;
    private String houseNo;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private ApprovalStatus approvalStatus;

    public Visitor(String visitorId, String name, String contactNumber, String houseNo,
                   LocalDateTime entryTime, LocalDateTime exitTime, ApprovalStatus approvalStatus) {
        this.visitorId = visitorId;
        this.name = name;
        this.contactNumber = contactNumber;
        this.houseNo = houseNo;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.approvalStatus = approvalStatus;
    }

    public String getVisitorId() {
        return visitorId;
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public ApprovalStatus getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(ApprovalStatus approvalStatus) {
        this.approvalStatus = approvalStatus;
    }
}
