public class IpDisplay {
    
    public static void displayResults(int[] octets) {
        String decimal = IpConverter.octetsToDecimal(octets);
        String binary = IpConverter.octetsToBinary(octets);
        String hex = IpConverter.octetsToHex(octets);
        
        System.out.println("Output:");
        System.out.println("Decimal: " + decimal);
        System.out.println("Binary : " + binary);
        System.out.println("Hex : " + hex);
    }
    
    public static void displayError(String message) {
        System.out.println("Error: " + message);
    }
}
