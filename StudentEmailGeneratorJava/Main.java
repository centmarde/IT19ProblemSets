import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("INITIALIZING STUDENT EMAIL GENERATOR SYSTEM");
        System.out.println("=".repeat(60));
        
        StudentManager manager = new StudentManager();
        FileHandler fileHandler = new FileHandler();
        MenuHandler menuHandler = new MenuHandler();
        EmailGenerator emailGenerator = new EmailGenerator();
        
        // Load existing data
        manager.setStudents(fileHandler.loadFromFile());
        
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            menuHandler.displayMainMenu();
            String choice = menuHandler.getMenuChoice(scanner);
            
            switch (choice) {
                case "1":
                    processNewStudent(manager, emailGenerator, menuHandler, scanner);
                    break;
                case "2":
                    processSearchStudent(manager, menuHandler, scanner);
                    break;
                case "3":
                    processDisplayAll(manager);
                    break;
                case "4":
                    processSaveData(manager, fileHandler, menuHandler);
                    break;
                case "5":
                    if (menuHandler.confirmExit(scanner)) {
                        fileHandler.saveToFile(manager.getStudents());
                        System.out.println("\nThank you for using Student Email Generator System!");
                        System.out.println("Goodbye!\n");
                        scanner.close();
                        return;
                    }
                    break;
                default:
                    menuHandler.displayError("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
    
    private static void processNewStudent(StudentManager manager, EmailGenerator emailGenerator, 
                                        MenuHandler menuHandler, Scanner scanner) {
        String[] studentInfo = menuHandler.getStudentInfo(scanner);
        String firstname = studentInfo[0];
        String lastname = studentInfo[1];
        String studentId = studentInfo[2];
        
        ValidationResult firstnameValidation = emailGenerator.validateInput(firstname, studentId);
        ValidationResult lastnameValidation = null;
        if (firstnameValidation.isValid()) {
            lastnameValidation = emailGenerator.validateInput(lastname, studentId);
        }
        
        if (!firstnameValidation.isValid()) {
            menuHandler.displayError(firstnameValidation.getErrorMessage());
            return;
        }
        
        if (!lastnameValidation.isValid()) {
            menuHandler.displayError(lastnameValidation.getErrorMessage());
            return;
        }
        
        if (manager.studentExists(studentId)) {
            menuHandler.displayError("Student with ID " + studentId + " already exists in the system.");
            String existingEmail = manager.getStudentEmail(studentId);
            menuHandler.displayResult("Existing Email", existingEmail);
            return;
        }
        
        String email = emailGenerator.generateEmail(firstname, lastname, studentId, 
                                                   manager.getAllEmails());
        String fullName = firstname + " " + lastname;
        
        manager.addStudent(fullName, studentId, email);
        
        menuHandler.displaySuccess("Email generated successfully!");
        menuHandler.displayResult("Generated Email", email);
    }
    
    private static void processSearchStudent(StudentManager manager, MenuHandler menuHandler, 
                                           Scanner scanner) {
        String studentId = menuHandler.getSearchId(scanner);
        String email = manager.getStudentEmail(studentId);
        
        if (email != null) {
            menuHandler.displayResult("Result", email);
        } else {
            menuHandler.displayError("No student found with ID: " + studentId);
        }
    }
    
    private static void processDisplayAll(StudentManager manager) {
        manager.displayAllStudents();
    }
    
    private static void processSaveData(StudentManager manager, FileHandler fileHandler, 
                                      MenuHandler menuHandler) {
        fileHandler.saveToFile(manager.getStudents());
        menuHandler.displaySuccess("Data saved successfully!");
    }
}