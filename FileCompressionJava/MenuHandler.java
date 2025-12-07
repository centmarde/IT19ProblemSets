import java.util.Scanner;

public class MenuHandler {
    private Scanner scanner;
    
    public MenuHandler() {
        this.scanner = new Scanner(System.in);
    }
    
    public void displayMenu() {
        System.out.println("\n=== File Compression Simulator ===");
        System.out.println("1. Compress File");
        System.out.println("2. Decompress File");
        System.out.println("3. Exit");
        System.out.print("Choose an option (1-3): ");
    }
    
    public int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    public void closeScanner() {
        scanner.close();
    }
}
