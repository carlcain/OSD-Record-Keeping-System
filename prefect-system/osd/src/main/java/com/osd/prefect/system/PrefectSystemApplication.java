package com.osd.prefect.system;

import com.osd.prefect.system.app.facade.student.StudentFacade;
import com.osd.prefect.system.app.facade.student.impl.StudentFacadeImpl;
import com.osd.prefect.system.app.facade.users.UserFacade;
import com.osd.prefect.system.app.facade.users.impl.UserFacadeImpl;
import com.osd.prefect.system.app.facade.violation.ViolationFacade;
import com.osd.prefect.system.app.facade.violation.impl.ViolationFacadeImpl;
import com.osd.prefect.system.model.student.Student;
import com.osd.prefect.system.model.users.User;
import com.osd.prefect.system.model.violation.Violation;

import java.util.List;
import java.util.Scanner;

public class PrefectSystemApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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

            if (username.equals(currentUser.getUsername()) && password.equals(currentUser.getUserPassword())) {
                System.out.println("Login successful");
                continuous = false;
            } else {
                System.out.println("Login failed.");
            }
        } while (continuous);

        String role = currentUser.getUserRole();

        switch (role){
            case "STUDENT":
                studentLogic(currentUser);
                break;
            case "PREFECT":
//                prefectLogic(currentUser);
                break;
            case "DEPARTMENT-HEAD":
//                departmentHeadLogic(currentUser);
                break;
        }
    }
    public static void studentLogic(User user) {
        StudentFacade sf = new StudentFacadeImpl();
        Student s = sf.getStudentbyID(user.getUserID());

        System.out.println("Hello " + s.getFirstName() +" !\n");

        System.out.println("First Name: " + s.getFirstName());
        System.out.println("Middle Name: " + s.getMiddleName());
        System.out.println("Surname: " + s.getSurname() + "\n");
        System.out.println("Section: " + s.getSection() + "\n");

        System.out.println("Violations: \n");
        ViolationFacade vf = new ViolationFacadeImpl();
        List<Violation> vl = vf.getAllViolations();

        for (Violation violation : vl) {
            System.out.println("Violation ID: " + violation.getViolationID());
            System.out.println("Offense ID: " + violation.getOffenseID());
            System.out.println("Date of Violation: " + violation.getDateofViolation());
            System.out.println("Date of Resolution: " + violation.getDateofResolution());
            System.out.println("Remarks: " + violation.getRemarks());
            System.out.println("Status: " + violation.getStatus());
        }
    }
}




