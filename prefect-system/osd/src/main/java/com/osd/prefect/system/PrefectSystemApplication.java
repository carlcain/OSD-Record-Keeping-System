//    package com.rocs.medical.records.application;
//
//import com.rocs.medical.records.application.app.facade.commonAilmentsReport.CommonAilmentsReportFacade;
//import com.rocs.medical.records.application.app.facade.commonAilmentsReport.impl.CommonAilmentsReportFacadeImpl;
//import com.rocs.medical.records.application.app.facade.lowStockMedicine.LowStockMedicineFacade;
//import com.rocs.medical.records.application.app.facade.lowStockMedicine.impl.LowStockMedicineFacadeImpl;
//import com.rocs.medical.records.application.app.facade.medicalRecord.impl.StudentMedicalRecordFacadeImpl;
//import com.rocs.medical.records.application.model.inventory.LowStockItem;
//import com.rocs.medical.records.application.model.reports.CommonAilmentsReport;
//import com.rocs.medical.records.application.model.person.Person;
//
//import com.rocs.medical.records.application.app.facade.reportMedicationTrend.ReportMedicationTrendFacade;
//import com.rocs.medical.records.application.app.facade.reportMedicationTrend.impl.ReportMedicationTrendFacadeImpl;
//import com.rocs.medical.records.application.model.reports.MedicationTrendReport;
//
//import com.rocs.medical.records.application.app.facade.frequentVisitReport.FrequentVisitReportFacade;
//import com.rocs.medical.records.application.app.facade.frequentVisitReport.impl.FrequentVisitReportFacadeImpl;
//import com.rocs.medical.records.application.model.reports.FrequentVisitReport;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;


package com.osd.prefect.system;

import java.util.Scanner;
public class PrefectSystemApplication {
    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private static String currentUser;
    private static String currentRole;

    public static void main(String[] args) {
        if (!login()) return;
        if (currentRole.equals("Prefect")) prefectMenu();
        if (currentRole.equals("Student")) studentMenu();
    }

    private static boolean login() {
        int attempts = 0;
        while (attempts < 3) {
            try {
                System.out.println("Prefect System Login");
                System.out.print("Username/ID: ");
                String username = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();

                currentRole = UserFacade.validateUser(username, password);
                if (currentRole != null) {
                    currentUser = username;
                    System.out.println("\nLogin successful as " + currentRole + "!\n");
                    return true;
                } else {
                    System.out.println("Incorrect username or password.\n");
                    attempts++;
                }
            } catch (Exception e) {
                System.err.println("Login error: " + e.getMessage());
            }
        }
        System.out.println("Too many failed attempts. Exiting system...");
        return false;
    }

    private static void prefectMenu() {
        while (true) {
            System.out.println("PREFECT MAIN MENU");
            System.out.println("[1] Homepage");
            System.out.println("[2] Record Violation");
            System.out.println("[3] Violation Page");
            System.out.println("[4] Student Appeals");
            System.out.println("[5] Settings");
            System.out.println("[6] Logout");
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1": showHomepage(); break;
                case "2": recordViolation(); break;
                case "3": showViolationPage(); break;
                case "4": showStudentAppeals(); break;
                case "5": settingsPage(); break;
                case "6": if (logout()) return; break;
                default: System.out.println("Invalid choice."); break;
            }
        }
    }

    private static void studentMenu() {
        while (true) {
            System.out.println("STUDENT MAIN MENU");
            System.out.println("[1] Violations");
            System.out.println("[2] Notifications");
            System.out.println("[3] Messages");
            System.out.println("[4] Logout");
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1": studentViolationsPage(); break;
                case "2": studentNotificationsPage(); break;
                case "3": studentMessagesPage(); break;
                case "4": if (logout()) return; break;
                default: System.out.println("Invalid choice."); break;
            }
        }
    }

    private static void showHomepage() {
        try {
            List<StudentFacade> students = HomePageFacade.getAllStudents();
            if (students.isEmpty()) System.out.println("No students available.");
            else {
                System.out.println("\nHOMEPAGE - STUDENTS LIST");
                System.out.printf("%-12s %-20s %-10s %-10s\n",
                        "StudentID", "Student Name", "Grade", "Section");
                int no = 1;
                for (StudentFacade s : students)
                    System.out.printf("[%d] %-12s %-20s %-10s %-10s\n",
                            no++, s.getId(), s.getName(), s.getGrade(), s.getSection());
            }
            System.out.println("[1] Filter by Grade  [2] Filter by Section  [3] Back to Main Menu");
            String subChoice = scanner.nextLine();
            if (subChoice.equals("1")) filterByGrade();
            if (subChoice.equals("2")) filterBySection();
        } catch (Exception e) { System.err.println("Homepage error: " + e.getMessage()); }
    }

    private static void filterByGrade() {
        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();
        try {
            List<StudentFacade> filtered = HomePageFacade.getStudentsByGrade(grade);
            if (filtered.isEmpty()) System.out.println("No students found.");
            else {
                System.out.printf("%-12s %-20s %-10s %-10s\n",
                        "StudentID", "Student Name", "Grade", "Section");
                for (StudentFacade s : filtered)
                    System.out.printf("%-12s %-20s %-10s %-10s\n",
                            s.getId(), s.getName(), s.getGrade(), s.getSection());
            }
        } catch (Exception e) { System.err.println("Filter error: " + e.getMessage()); }
    }

    private static void filterBySection() {
        System.out.print("Enter section: ");
        String section = scanner.nextLine();
        try {
            List<StudentFacade> filtered = HomePageFacade.getStudentsBySection(section);
            if (filtered.isEmpty()) System.out.println("No students found.");
            else {
                System.out.printf("%-12s %-20s %-10s %-10s\n",
                        "StudentID", "Student Name", "Grade", "Section");
                for (StudentFacade s : filtered)
                    System.out.printf("%-12s %-20s %-10s %-10s\n",
                            s.getId(), s.getName(), s.getGrade(), s.getSection());
            }
        } catch (Exception e) { System.err.println("Filter error: " + e.getMessage()); }
    }

    private static void recordViolation() {
        try {
            System.out.println("\nRECORD VIOLATION");
            System.out.print("Enter StudentID: ");
            String sid = scanner.nextLine();
            System.out.print("Enter Offense Type: ");
            String otype = scanner.nextLine();
            System.out.print("Enter Student Name: ");
            String sname = scanner.nextLine();
            System.out.print("Enter Level of Offense: ");
            String level = scanner.nextLine();
            String date = sdf.format(new Date());
            System.out.print("Enter Remarks: ");
            String remarks = scanner.nextLine();
            ViolationFacade.recordViolation(sid, otype, sname, level, date, remarks);
            System.out.println("Violation recorded successfully on " + date + "!");
        } catch (Exception e) { System.err.println("Record violation error: " + e.getMessage()); }
    }

    private static void showViolationPage() { }
    private static void showStudentAppeals() { }
    private static void settingsPage() { }
    private static void studentViolationsPage() { }
    private static void studentNotificationsPage() { }
    private static void studentMessagesPage() { }

    private static boolean logout() {
        while (true) {
            System.out.println("Are you sure you want to logout?");
            System.out.println("[1] Yes  [2] No");
            String choice = scanner.nextLine();
            if (choice.equals("1")) { System.out.println("Logging out..."); return true; }
            if (choice.equals("2")) return false;
            System.out.println("Invalid choice.");
        }
    }
}
//
//
//            System.out.println("Welcome " + user + " !");
//            System.out.println("Please select which report:");
//            System.out.println("1 - Common Ailments Report");
//            System.out.println("2 - Medication Trend Report");
//            System.out.println("3 - Retrieve Student Medical Record");
//            System.out.println("4 - Frequent Visit Report");
//            System.out.println("5 - Check Low Stock Medicine");
//
//            System.out.println("Enter your choice: ");
//            int choice = scanner.nextInt();
//
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            dateFormat.setLenient(false);
//
//            switch (choice){
//                case 1: {
//                    CommonAilmentsReportFacade ailmentsReportFacade = new CommonAilmentsReportFacadeImpl();
//
//                    try{
//                        scanner.nextLine();
//                        System.out.println("Common Ailments Report");
//
//                        Date startDate = getValidInputDate(scanner, dateFormat, "Enter start date (yyyy-MM-dd): ");
//                        Date endDate = getValidInputDate(scanner, dateFormat, "Enter end date (yyyy-MM-dd): ");
//
//                        System.out.print("Enter grade level (enter to skip): ");
//                        String gradeLevel = scanner.nextLine().trim();
//                        gradeLevel = gradeLevel.isEmpty() ? null : gradeLevel;
//
//                        System.out.print("Enter section (enter to skip): ");
//                        String section = scanner.nextLine().trim();
//                        section = section.isEmpty() ? null : section;
//
//                        List<CommonAilmentsReport> reports = ailmentsReportFacade.generateReport(startDate, endDate, gradeLevel, section);
//                        displayCommonAilmentsReport(reports, startDate, endDate, gradeLevel, section);
//                    } catch (RuntimeException e) {
//                        System.err.println("Report generation failed: " + e.getMessage());
//                    }
//                    break;
//                }
//
//                case 2: {
//                    scanner.nextLine();
//                    ReportMedicationTrendFacade medicationTrendFacade = new ReportMedicationTrendFacadeImpl();
//
//                    try{
//                        System.out.println("\nWelcome to Medication Trend Report");
//
//                        Date startDate = getValidInputDate(scanner, dateFormat, "Please enter start date (yyyy-MM-dd): ");
//                        Date endDate = getValidInputDate(scanner, dateFormat, "Please enter end date (yyyy-MM-dd): ");
//
//                        List<MedicationTrendReport> reports = medicationTrendFacade.generateReport(startDate, endDate);
//                        medicationTrendFacade.displayMedTrendReport(reports, startDate, endDate);
//
//
//                    } catch (RuntimeException e) {
//                        System.err.println("Error generating: " + e.getMessage());
//                    }
//                    break;
//                }
//
//
//                case 3: {
//                    try{
//                        scanner.nextLine();
//
//                        StudentMedicalRecordFacadeImpl studentMedical = new StudentMedicalRecordFacadeImpl();
//
//                        System.out.println("Search Student Medical Records using LRN: ");
//                        long LRN = scanner.nextLong();
//
//                        studentMedical.findMedicalInformationByLRN(LRN);
//
//
//
//
//                    } catch (RuntimeException e) {
//                        System.err.println("Error generating: " + e.getMessage());
//                    }
//                    break;
//                }
//
//                case 4: {
//                    scanner.nextLine();
//                    FrequentVisitReportFacade frequentVisitReportFacade = new FrequentVisitReportFacadeImpl();
//
//                    try {
//                        System.out.println("Frequent Visit Report");
//
//                        Date frequentVisitStartDate = getValidInputDate(scanner, dateFormat, "Enter start date (yyyy-MM-dd): ");
//                        Date frequentVisitEndDate = getValidInputDate(scanner, dateFormat, "Enter end date (yyyy-MM-dd): ");
//                        System.out.print("Enter grade level for Frequent Visit: ");
//                        String frequentVisitGradeLevel = scanner.nextLine().trim();
//
//                        List<FrequentVisitReport> reports = frequentVisitReportFacade.generateReport(frequentVisitStartDate, frequentVisitEndDate, frequentVisitGradeLevel);
//                        frequentVisitReportFacade.handleFrequentVisit(reports, frequentVisitStartDate, frequentVisitEndDate, frequentVisitGradeLevel);
//
//                    } catch (RuntimeException e) {
//                        System.err.println("Report generation failed: " + e.getMessage());
//                    }
//                    break;
//
//                }
//                case 5:{
//                    LowStockMedicineFacade lowStockMedicineFacade = new LowStockMedicineFacadeImpl();
//                    try {
//                        List<LowStockItem> lowStockItems = lowStockMedicineFacade.checkLowStockAndNotify();
//                    } catch (RuntimeException e) {
//                        System.err.println("Error checking low stock items: " + e.getMessage());
//                    }
//                    break;
//                }
//                default:
//                    System.out.println("Invalid choice. Please select a valid option.");
//                    break;
//
//
//            }
//
//
//        }
//
//        private static void displayCommonAilmentsReport(List<CommonAilmentsReport> reports, Date startDate, Date endDate, String gradeLevel, String section) {
//            if (reports == null || reports.isEmpty()) {
//                System.out.println("No data available for the selected criteria.");
//                return;
//            }
//
//            SimpleDateFormat displayFormat = new SimpleDateFormat("MMMM dd, yyyy");
//            System.out.println("Common Ailments Report");
//            System.out.println("Period: " + displayFormat.format(startDate) + " to " + displayFormat.format(endDate));
//            System.out.println("Grade level: " + (gradeLevel != null ? gradeLevel : "ALL"));
//            System.out.println("Section: " + (section != null ? section : "ALL"));
//
//            for (CommonAilmentsReport report : reports) {
//                printAilmentSection(report);
//            }
//
//            System.out.println("\nReport Summary");
//            System.out.println("Total no. of different ailments: " + reports.size());
//
//            int totalOccurrences = reports.stream().mapToInt(CommonAilmentsReport::getOccurrences).sum();
//            System.out.println("Total no. of occurrences: " + totalOccurrences);
//        }
//
//        private static void printAilmentSection(CommonAilmentsReport report) {
//            System.out.println("\nAffected students:");
//            for (Person student : report.getAffectedPeople()) {
//                System.out.println(student.getFirstName() + " " + student.getLastName());
//            }
//
//            System.out.println("Ailment: " + report.getAilment());
//            System.out.println("No. of occurrences per ailment: " + report.getOccurrences());
//            System.out.println("Grade Level: " + report.getGradeLevel());
//            System.out.println("Strand: " + report.getStrand());
//
//        }
//
//        private static Date getValidInputDate(Scanner scanner, SimpleDateFormat dateFormat, String prompt) {
//            while (true) {
//                try {
//                    System.out.print(prompt);
//                    String input = scanner.nextLine().trim();
//                    Date date = dateFormat.parse(input);
//
//                    if (date.after(new Date())) {
//                        System.err.println("Please enter a present or past date.");
//                        continue;
//                    }
//                    return date;
//                } catch (ParseException e) {
//                    System.err.println("Invalid date format, use yyyy-MM-dd.");
//                }
//            }
//        }
//    }
}