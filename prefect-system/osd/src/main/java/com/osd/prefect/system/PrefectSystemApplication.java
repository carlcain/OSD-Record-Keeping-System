package com.osd.prefect.system;

import com.osd.prefect.system.app.facade.appeal.AppealFacade;
import com.osd.prefect.system.app.facade.appeal.impl.AppealFacadeImpl;
import com.osd.prefect.system.app.facade.person.PersonFacade;
import com.osd.prefect.system.app.facade.person.impl.PersonFacadeImpl;
import com.osd.prefect.system.app.facade.prefect.PrefectFacade;
import com.osd.prefect.system.app.facade.prefect.impl.PrefectFacadeImpl;
import com.osd.prefect.system.app.facade.request.RequestFacade;
import com.osd.prefect.system.app.facade.request.impl.RequestFacadeImpl;
import com.osd.prefect.system.app.facade.student.StudentFacade;
import com.osd.prefect.system.app.facade.student.impl.StudentFacadeImpl;
import com.osd.prefect.system.app.facade.users.UserFacade;
import com.osd.prefect.system.app.facade.users.impl.UserFacadeImpl;
import com.osd.prefect.system.app.facade.violation.ViolationFacade;
import com.osd.prefect.system.app.facade.violation.impl.ViolationFacadeImpl;
import com.osd.prefect.system.data.dao.department_head.impl.DepartmentHeadDaoImpl;
import com.osd.prefect.system.model.appeal.Appeal;
import com.osd.prefect.system.model.department_head.DepartmentHead;
import com.osd.prefect.system.model.person.Person;
import com.osd.prefect.system.model.prefect.Prefect;
import com.osd.prefect.system.model.request.Request;
import com.osd.prefect.system.model.student.Student;
import com.osd.prefect.system.model.users.User;
import com.osd.prefect.system.model.violation.Violation;

import java.util.List;
import java.util.Scanner;

public class PrefectSystemApplication {
    private static Scanner sc = new Scanner(System.in);;

    public static void main(String[] args) {
        Login();
    }

    public static void Login() {
        System.out.println("Welcome to RC OSD Record Keeping System!");
        boolean continuous = true;
        User currentUser;
        do {
            System.out.println("Enter username: ");
            String username = sc.next();
            System.out.println("Enter password: ");
            String password = sc.next();

            UserFacade userFacade = new UserFacadeImpl();
            currentUser = userFacade.getUserbyUsername(username);

            // to make debug tool access it easier
            String currentusername = currentUser.getUsername();
            String currentpassword = currentUser.getUserPassword();
            if (username.equals(currentusername) && password.equals(currentpassword) ) {
                System.out.println("Login successful");
                continuous = false;
            } else {
                System.out.println("Login failed.");
            }
        } while (continuous);

        String role = currentUser.getUserRole();
        role = role.toUpperCase();
        switch (role){
            case "STUDENT":
                studentLogic(currentUser);
                break;
            case "PREFECT":
                prefectLogic(currentUser);
                break;
            case "DEPARTMENT-HEAD":
                departmentHeadLogic(currentUser);
                break;
        }
    }

    public static void studentLogic(User user) {
        StudentFacade sf = new StudentFacadeImpl();
        Student s = sf.getStudentByID(user.getUserID());

        PersonFacade pf = new PersonFacadeImpl();
        Person p = pf.getByPersonId(s.getPersonID());

        System.out.println("=========================================");
        System.out.println("Hello " + p.getFirstName() +" !\n");
        System.out.println("=========================================");
        System.out.println("Student info: ");
        System.out.println("First Name: " + p.getFirstName());
        System.out.println("Middle Name: " + p.getMiddleName());
        System.out.println("Surname: " + p.getLastName() + "\n");
        System.out.println("Section: " + s.getSection() + "\n");
        System.out.println("Violations: \n");
        ViolationFacade vf = new ViolationFacadeImpl();
        List<Violation> vl = vf.getAllViolationsPerStudent(s.getStudentID());

        for (Violation violation : vl) {
            System.out.println("Violation ID: " + violation.getViolationID());
            System.out.println("Offense ID: " + violation.getOffenseID());
            System.out.println("Date of Violation: " + violation.getDateofViolation());
            System.out.println("Date of Resolution: " + violation.getDateofResolution());
            System.out.println("Remarks: " + violation.getRemarks());
            System.out.println("Status: " + violation.getStatus());
            System.out.println("=========================================");
        }

        System.out.println("What would you like to do? \n[1] Appeal [2] Logout ");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                AppealFacade af = new AppealFacadeImpl();
                System.out.println("Enter the violation ID of the Violation you want to Appeal: ");
                String violationID = sc.next();
                System.out.println("Enter Appeal message: ");
                String message = sc.next();
                af.addAppeal(violationID,s.getStudentID(),message);
                break;
            case 2:
                System.out.println("Are you sure you would like to logout?\n[1] Yes\n[2] No");
                int logoutChoice = sc.nextInt();
                switch (logoutChoice) {
                    case 1:
                        System.out.println("Successfully Logged Out");
                        Login();
                        break;
                    case 2:
                        studentLogic(user);
                        break;
                }
                break;
        }
    }

    public static void departmentHeadLogic(User user) {
        //Department head semi login
        DepartmentHeadDaoImpl departmentHeadDao = new DepartmentHeadDaoImpl();
        DepartmentHead departmentHead = departmentHeadDao.getDepartmentHeadById(user.getUserID());

        System.out.println("=================================");
        System.out.println("Welcome DeptHead " + user.getUsername() + "! ");
        System.out.println("would you like to make a request?");
        System.out.println("request = r");
        System.out.println("exit = e");
        System.out.print("-->");
        String input = sc.next().toLowerCase();

        if (input.equals("r")) {
            System.out.println("Details:");
            sc.nextLine();
            String details = sc.nextLine();

            System.out.println("Message:");
            String message = sc.nextLine();

            System.out.println("Loading.....");
            RequestFacadeImpl requestFacade = new RequestFacadeImpl();
            requestFacade.setRequest(departmentHead.getDepartmentHeadID(), details, message);
            System.out.println("Done");

        } else if (input.equals("e")) {
            Login();
        } else {
            System.out.println("Unknown input");
        }
    }
    public static void prefectLogic(User user) {
        StudentFacade sf = new StudentFacadeImpl();
        ViolationFacade vf = new ViolationFacadeImpl();
        AppealFacade af = new AppealFacadeImpl();
        RequestFacade rf = new RequestFacadeImpl();
        PrefectFacade pf = new PrefectFacadeImpl();

        Prefect currentPrefect = pf.getPrefectByID(user.getUserID());

        boolean running = true;

        while (running) {

            System.out.println("\n=====================================");
            System.out.println("Welcome Prefect " + user.getUsername());
            System.out.println("[1] View All Violations");
            System.out.println("[2] Add Violation");
            System.out.println("[3] Process Appeals");
            System.out.println("[4] View Violations per Student");
            System.out.println("[5] View Requests");
            System.out.println("[6] Logout");

            int choice = sc.nextInt(); sc.nextLine();

            switch(choice) {

                case 1:
                    List<Violation> all = vf.getAllViolations();
                    if (all.isEmpty()) {
                        System.out.println("\nNo violations found.");
                    } else {
                        System.out.println("\n===== ALL VIOLATIONS =====");
                        for (Violation v : all) {
                            System.out.println("Violation ID: " + v.getViolationID());
                            System.out.println("Student ID: " + v.getStudentID());
                            System.out.println("Offense ID: " + v.getOffenseID());
                            System.out.println("Status: " + v.getStatus());
                            System.out.println("Remarks: " + v.getRemarks());
                            System.out.println("------------------------------------");
                        }
                    }
                    break;

                case 2:
                    System.out.println("\nEnter Student ID:");
                    String sid = sc.nextLine();
                    System.out.println("Enter Offense ID:");
                    String offense = sc.nextLine();
                    System.out.println("Enter Action ID: ");
                    String action = sc.nextLine();
                    System.out.println("Remarks:");
                    String remark = sc.nextLine();

                    boolean addStatus = vf.addViolation(sid , currentPrefect.getPrefectID(), offense, action, remark);
                    System.out.println("Violation Recorded Successfully.");
                    break;

                case 3:
                    List<Appeal> appeals = af.getAllAppeals();
                    if (appeals.isEmpty()) {
                        System.out.println("\nNo appeals submitted.");
                        break;
                    }

                    System.out.println("\n===== STUDENT APPEALS =====");
                    for (Appeal a : appeals) {
                        System.out.println("Appeal ID: " + a.getAppealID());
                        System.out.println("Violation ID: " + a.getViolationID());
                        System.out.println("Student ID: " + a.getStudentID());
                        System.out.println("Message: " + a.getMessage());
                        System.out.println("Status: " + a.getStatus());
                        System.out.println("------------------------------------");
                    }

                    System.out.println("\nEnter Appeal ID to process:");
                    String apid = sc.nextLine();

                    System.out.println("[1] Approve Appeal\n[2] Reject Appeal");
                    int decision = sc.nextInt(); sc.nextLine();

                    if (decision == 1) {
                        af.updateAppealStatus(apid, "APPROVED");
                        System.out.println("Appeal Approved.");
                    } else {
                        af.updateAppealStatus(apid, "REJECTED");
                        System.out.println("Appeal Denied.");
                    }
                    break;

                case 4:
                    System.out.println("\nEnter Student ID:");
                    String studID = sc.nextLine();

                    List<Violation> vList = vf.getAllViolationsPerStudent(studID);
                    if (vList.isEmpty()) {
                        System.out.println("No violations found for this student.");
                        break;
                    }

                    System.out.println("\n===== VIOLATIONS FOR STUDENT " + studID + " =====");
                    for (Violation v : vList) {
                        System.out.println("Violation ID: " + v.getViolationID());
                        System.out.println("Offense ID: " + v.getOffenseID());
                        System.out.println("Remarks: " + v.getRemarks());
                        System.out.println("Status: " + v.getStatus());
                        System.out.println("Date: " + v.getDateofViolation());
                        System.out.println("------------------------------------");
                    }
                    break;

                case 5:
                    List<Request> requests = rf.getAllRequests();

                    if (requests.isEmpty()) {
                        System.out.println("\nNo pending requests.");
                        break;
                    }

                    System.out.println("\n========== DEPARTMENT HEAD REQUESTS ==========");

                    for (Request r : requests) {
                        System.out.println("Request ID: " + r.getRequestID());
                        System.out.println("Dept Head ID: " + r.getDepartmentHeadID());
                        System.out.println("Type: " + r.getType());
                        System.out.println("Details: " + r.getDetails());
                        System.out.println("Message: " + r.getMessage());
                        System.out.println("Status: " + r.getStatus());
                        System.out.println("---------------------------------------------");
                    }

                    System.out.println("\nEnter Request ID to process:");
                    String rid = sc.nextLine();

                    System.out.println("[1] Approve Request\n[2] Reject Request");
                    int deci = sc.nextInt(); sc.nextLine();

                    if (deci == 1) {
                        rf.updateRequestStatus(rid, "APPROVED");
                        System.out.println("Request Approved.");
                    } else {
                        rf.updateRequestStatus(rid, "REJECTED");
                        System.out.println("Request Rejected.");
                    }
                    break;


                case 6:
                    System.out.println("Logging out...");
                    running = false;
                    Login();
                    break;
            }
        }
    }

}




