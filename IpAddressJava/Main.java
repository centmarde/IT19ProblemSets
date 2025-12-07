import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter IP Address (Decimal/Binary/Hex): ");
        String input = scanner.nextLine().trim();
        
        int[] octets = null;
        
        if (IpValidator.isValidDecimal(input)) {
            octets = IpConverter.decimalToOctets(input);
        } else if (IpValidator.isValidBinary(input)) {
            octets = IpConverter.binaryToOctets(input);
        } else if (IpValidator.isValidHexadecimal(input)) {
            octets = IpConverter.hexToOctets(input);
        } else {
            IpDisplay.displayError("Invalid input format. Please enter a valid decimal IP, 32-bit binary, or 8-character hex.");
            scanner.close();
            return;
        }
        
        IpDisplay.displayResults(octets);
        scanner.close();
    }
}