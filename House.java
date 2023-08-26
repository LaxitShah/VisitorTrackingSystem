package j2ee.lab02;

public class House {
    private String houseNo;
    private String contactName;
    private String contactNumber;

    public House(String houseNo, String contactName, String contactNumber) {
        this.houseNo = houseNo;
        this.contactName = contactName;
        this.contactNumber = contactNumber;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }
}

