import java.util.Scanner;

public class MenuHandler {
    
    public void displayMainMenu() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("STUDENT EMAIL GENERATOR SYSTEM");
        System.out.println("=".repeat(60));
        System.out.println("1. Generate New Student Email");
        System.out.println("2. Search Student Email by ID");
        System.out.println("3. Display All Students");
        System.out.println("4. Save Data to File");
        System.out.println("5. Exit");
        System.out.println("=".repeat(60));
    }
    
    public String getMenuChoice(Scanner scanner) {
        System.out.print("Enter your choice (1-5): ");
        return scanner.nextLine().trim();
    }
    
    public String[] getStudentInfo(Scanner scanner) {
        System.out.println("\n" + "-".repeat(60));
        System.out.print("Enter student's first name: ");
        String firstname = scanner.nextLine().trim();
        
        System.out.print("Enter student's last name: ");
        String lastname = scanner.nextLine().trim();
        
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine().trim();
        
        return new String[]{firstname, lastname, studentId};
    }
    
    public String getSearchId(Scanner scanner) {
        System.out.println("\n" + "-".repeat(60));
        System.out.print("Enter Student ID to search: ");
        return scanner.nextLine().trim();
    }
    
    public void displaySuccess(String message) {
        System.out.println("\n✓ " + message);
    }
    
    public void displayError(String message) {
        System.out.println("\n✗ " + message);
    }
    
    public void displayResult(String label, String value) {
        System.out.println("\n" + label + ": " + value);
    }
    
    public boolean confirmExit(Scanner scanner) {
        System.out.print("\nAre you sure you want to exit? (y/n): ");
        String choice = scanner.nextLine().trim().toLowerCase();
        return choice.equals("y");
    }
}
