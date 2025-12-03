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
    public static void main(String[] args) {

        System.out.println("Welcome to Prefect System Application");
        Scanner scanner = new Scanner(System.in);

        int attempts = 0;

        while (attempts < 3) {

            System.out.println("\nPrefect System Login");

            System.out.print("Username: ");
            String username = scanner.nextLine();

            if (!loginFacade.getUserByUsername(username)) {
                System.out.println("Username not found.\n");
                attempts++;
                continue;
            }

            System.out.print("Password: ");
            String password = scanner.nextLine();


            if (loginFacade.validatePassword(username, password)) {
                System.out.println("\nLogin successful!\n");
                break;
            } else {
                System.out.println("Incorrect password.\n");
                attempts++;
            }
        }

        if (attempts == 3) {
            System.out.println("Too many failed attempts. Exiting system...");
            return;
        }

        while (true) {

            System.out.println("\n HOMEPAGE");
            System.out.println("List of Students");
            System.out.println("-----------------------------");

            List<StudentDTO> students = homePageFacade.getAllStudents();

            System.out.printf("%-12s %-20s %-10s %-10s\n",
                    "StudentID", "Student Name", "Grade", "Section");

            for (StudentDTO s : students) {
                System.out.printf("%-12s %-20s %-10s %-10s\n",
                        s.getId(), s.getName(), s.getGrade(), s.getSection());
            }

            System.out.println("\nFilter Options:");
            System.out.println("1. Filter by Grade");
            System.out.println("2. Filter by Section");
            System.out.println("3. Back to Navigation");

            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    System.out.print("Enter grade (e.g., Grade 11): ");
                    String grade = scanner.nextLine();
                    List<StudentDTO> filteredByGrade = homePageFacade.getStudentsByGrade(grade);

                    System.out.println("\nFiltered by Grade: " + grade);
                    System.out.printf("%-12s %-20s %-10s %-10s\n",
                            "StudentID", "Student Name", "Grade", "Section");
                    for (StudentDTO s : filteredByGrade) {
                        System.out.printf("%-12s %-20s %-10s %-10s\n",
                                s.getId(), s.getName(), s.getGrade(), s.getSection());
                    }
                    break;

                case "2":
                    System.out.print("Enter section (e.g., A): ");
                    String section = scanner.nextLine();
                    List<StudentDTO> filteredBySection = homePageFacade.getStudentsBySection(section);

                    System.out.println("\nFiltered by Section: " + section);
                    System.out.printf("%-12s %-20s %-10s %-10s\n",
                            "StudentID", "Student Name", "Grade", "Section");
                    for (StudentDTO s : filteredBySection) {
                        System.out.printf("%-12s %-20s %-10s %-10s\n",
                                s.getId(), s.getName(), s.getGrade(), s.getSection());
                    }
                    break;

                case "3":
                    System.out.println("Returning to main navigation...");
                    return;

                default:
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