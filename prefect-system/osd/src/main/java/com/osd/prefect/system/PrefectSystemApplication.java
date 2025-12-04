package com.osd.prefect.system;

import com.osd.prefect.system.app.facade.person.PersonFacade;
import com.osd.prefect.system.app.facade.person.impl.PersonFacadeImpl;
import com.osd.prefect.system.app.facade.request.impl.RequestFacadeImpl;
import com.osd.prefect.system.app.facade.student.StudentFacade;
import com.osd.prefect.system.app.facade.student.impl.StudentFacadeImpl;
import com.osd.prefect.system.app.facade.users.UserFacade;
import com.osd.prefect.system.app.facade.users.impl.UserFacadeImpl;
import com.osd.prefect.system.app.facade.violation.ViolationFacade;
import com.osd.prefect.system.app.facade.violation.impl.ViolationFacadeImpl;
import com.osd.prefect.system.data.dao.department_head.impl.DepartmentHeadDaoImpl;
import com.osd.prefect.system.model.department_head.DepartmentHead;
import com.osd.prefect.system.model.person.Person;
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
        role.toUpperCase();
        switch (role){
            case "STUDENT":
                studentLogic(currentUser);
                break;
            case "PREFECT":
//                prefectLogic(currentUser);
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

        System.out.println("Hello " + p.getFirstName() +" !\n");

        System.out.println("Student info: ");
        System.out.println("First Name: " + p.getFirstName());
        System.out.println("Middle Name: " + p.getMiddleName());
        System.out.println("Surname: " + p.getLastName() + "\n");

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
            System.out.println("=========================================");
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
}




