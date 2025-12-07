public class IpValidator {
    
    public static boolean isValidDecimal(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        
        String[] octets = input.split("\\.");
        if (octets.length != 4) {
            return false;
        }
        
        for (String octet : octets) {
            try {
                int value = Integer.parseInt(octet);
                if (value < 0 || value > 255) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isValidBinary(String input) {
        if (input == null || input.length() != 32) {
            return false;
        }
        
        for (char c : input.toCharArray()) {
            if (c != '0' && c != '1') {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isValidHexadecimal(String input) {
        if (input == null || input.length() != 8) {
            return false;
        }
        
        for (char c : input.toCharArray()) {
            if (!((c >= '0' && c <= '9') || 
                  (c >= 'A' && c <= 'F') || 
                  (c >= 'a' && c <= 'f'))) {
                return false;
            }
        }
        return true;
    }
}
