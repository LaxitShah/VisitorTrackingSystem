package j2ee.lab02;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class VisitorTrackingClient {
    public static void main(String[] args) {
        VisitorTrackingService service = new VisitorTrackingService();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("1. Add House");
            System.out.println("2. Add Visitor");
            System.out.println("3. Approve Visitor");
            System.out.println("4. Print Reports");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("Add House:");
                    System.out.print("Enter House No: ");
                    String houseNo = scanner.nextLine();
                    System.out.print("Enter Contact Name: ");
                    String contactName = scanner.nextLine();
                    System.out.print("Enter Contact Number: ");
                    String contactNumber = scanner.nextLine();
                    House house = new House(houseNo, contactName, contactNumber);
                    service.addHouse(house);
                    System.out.println("House added successfully.");
                    break;

                case 2:
                    System.out.println("Add Visitor:");
                    System.out.print("Enter Visitor Name: ");
                    String visitorName = scanner.nextLine();
                    System.out.print("Enter Contact Number: ");
                    String visitorContact = scanner.nextLine();
                    System.out.print("Enter House No to Visit: ");
                    String houseToVisit = scanner.nextLine();
                    Visitor visitor = new Visitor("V001", visitorName, visitorContact, houseToVisit, LocalDateTime.now(), null, ApprovalStatus.PENDING);
                    service.addVisitor(visitor);
                    System.out.println("Visitor added successfully.");
                    break;

                case 3:
                    System.out.println("Approve Visitor:");
                    System.out.print("Enter Visitor ID to approve: ");
                    String visitorId = scanner.nextLine();
                    service.approveVisitor(visitorId);
                    System.out.println("Visitor approved successfully.");
                    break;

                case 4:
                	 System.out.println("Reports:");
                     System.out.println("1. Visitors on a Specific Day");
                     System.out.println("2. Pending Approval Visitors");
                     System.out.println("3. Unapproved Left Visitors");
                     System.out.println("4. Visitors by House");
                     System.out.print("Enter your choice: ");
                     int reportChoice = scanner.nextInt();
                     scanner.nextLine();

                     switch (reportChoice) {
                         case 1:
                             System.out.print("Enter date (yyyy-mm-dd): ");
                             String dateStr = scanner.nextLine();
                             LocalDate date = LocalDate.parse(dateStr);
                             List<Visitor> dayVisitors = service.getVisitorsDay(date);
                             System.out.println("Visitors on " + date + ":");
                             for (Visitor visitor1 : dayVisitors) {
                                 System.out.println("Name: " + visitor1.getName() + ", Contact Number: " + visitor1.getContactNumber() +
                                         ", House No: " + visitor1.getHouseNo() + ", Entry Time: " + visitor1.getEntryTime());
                             }
                             break;

                         case 2:
                             List<Visitor> pendingApprovalVisitors = service.getPendingVisitors();
                             System.out.println("Pending Approval Visitors:");
                             for (Visitor visitor1 : pendingApprovalVisitors) {
                                 System.out.println("Name: " + visitor1.getName() + ", Contact Number: " + visitor1.getContactNumber() +
                                         ", House No: " + visitor1.getHouseNo() + ", Entry Time: " + visitor1.getEntryTime());
                             }
                             break;

                         case 3:
                             List<Visitor> unApprovedLeftVisitors = service.getVisitorsUnApprovedLeft(LocalDate.of(2023, 8, 1), LocalDate.of(2023, 8, 10));
                             System.out.println("Unapproved Left Visitors:");
                             for (Visitor visitor1 : unApprovedLeftVisitors) {
                                 System.out.println("Name: " + visitor1.getName() + ", Contact Number: " + visitor1.getContactNumber() +
                                         ", House No: " + visitor1.getHouseNo() + ", Entry Time: " + visitor1.getEntryTime() +
                                         ", Exit Time: " + visitor1.getExitTime());
                             }
                             break;

                         case 4:
                             System.out.print("Enter House No: ");
                             String houseNo1 = scanner.nextLine();
                             List<Visitor> houseVisitors = service.getVisitorsByHouse(houseNo1);
                             System.out.println("Visitors for House " + houseNo1 + ":");
                             for (Visitor visitor1 : houseVisitors) {
                                 System.out.println("Name: " + visitor1.getName() + ", Contact Number: " + visitor1.getContactNumber() +
                                         ", House No: " + visitor1.getHouseNo() + ", Entry Time: " + visitor1.getEntryTime());
                             }
                             break;

                         default:
                             System.out.println("Invalid report choice.");
                     }
                     break;


                case 5:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

       
        scanner.close();
    }
}
