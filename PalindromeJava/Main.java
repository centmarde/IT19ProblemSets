import java.util.Scanner;

class Main {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void displayMenu() {
        System.out.println("===== Palindrome & Anagram Tool =====");
        System.out.println("1. Palindrome Checker");
        System.out.println("2. Anagram Checker");
        System.out.println("3. Exit");
    }
    
    public static String getUserChoice() {
        System.out.print("Choose an option: ");
        return scanner.nextLine();
    }
    
    public static void palindromeChecker() {
        System.out.print("Enter word/phrase: ");
        String text = scanner.nextLine();
        String result = StringUtils.isPalindrome(text) ? "Palindrome" : "Not Palindrome";
        System.out.println("Output: " + result);
    }
    
    public static void anagramChecker() {
        System.out.print("Enter first word/phrase: ");
        String text1 = scanner.nextLine();
        System.out.print("Enter second word/phrase: ");
        String text2 = scanner.nextLine();
        String result = StringUtils.areAnagrams(text1, text2) ? "Anagrams" : "Not Anagrams";
        System.out.println("Output: " + result);
    }
    
    public static void runApplication() {
        while (true) {
            displayMenu();
            String choice = getUserChoice();
            
            switch (choice) {
                case "1":
                    palindromeChecker();
                    break;
                case "2":
                    anagramChecker();
                    break;
                case "3":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        runApplication();
        scanner.close();
    }
}