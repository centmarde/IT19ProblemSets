public class IpConverter {
    
    public static int[] decimalToOctets(String decimal) {
        String[] parts = decimal.split("\\.");
        int[] octets = new int[4];
        for (int i = 0; i < 4; i++) {
            octets[i] = Integer.parseInt(parts[i]);
        }
        return octets;
    }
    
    public static int[] binaryToOctets(String binary) {
        int[] octets = new int[4];
        for (int i = 0; i < 4; i++) {
            String octetBinary = binary.substring(i * 8, (i + 1) * 8);
            octets[i] = binaryToDecimal(octetBinary);
        }
        return octets;
    }
    
    public static int[] hexToOctets(String hex) {
        hex = hex.toUpperCase();
        int[] octets = new int[4];
        for (int i = 0; i < 4; i++) {
            String octetHex = hex.substring(i * 2, (i + 1) * 2);
            octets[i] = hexToDecimal(octetHex);
        }
        return octets;
    }
    
    public static String octetsToDecimal(int[] octets) {
        return octets[0] + "." + octets[1] + "." + octets[2] + "." + octets[3];
    }
    
    public static String octetsToBinary(int[] octets) {
        StringBuilder binary = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            if (i > 0) binary.append(".");
            binary.append(decimalToBinary(octets[i], 8));
        }
        return binary.toString();
    }
    
    public static String octetsToHex(int[] octets) {
        StringBuilder hex = new StringBuilder();
        for (int octet : octets) {
            hex.append(decimalToHex(octet, 2));
        }
        return hex.toString();
    }
    
    private static int binaryToDecimal(String binary) {
        int result = 0;
        int power = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                result += (1 << power);
            }
            power++;
        }
        return result;
    }
    
    private static int hexToDecimal(String hex) {
        int result = 0;
        int power = 0;
        for (int i = hex.length() - 1; i >= 0; i--) {
            char c = hex.charAt(i);
            int digit;
            if (c >= '0' && c <= '9') {
                digit = c - '0';
            } else {
                digit = c - 'A' + 10;
            }
            result += digit * Math.pow(16, power);
            power++;
        }
        return result;
    }
    
    private static String decimalToBinary(int decimal, int length) {
        StringBuilder binary = new StringBuilder();
        for (int i = length - 1; i >= 0; i--) {
            if ((decimal & (1 << i)) != 0) {
                binary.append("1");
            } else {
                binary.append("0");
            }
        }
        return binary.toString();
    }
    
    private static String decimalToHex(int decimal, int length) {
        String hexChars = "0123456789ABCDEF";
        StringBuilder hex = new StringBuilder();
        for (int i = length - 1; i >= 0; i--) {
            int nibble = (decimal >> (i * 4)) & 0xF;
            hex.append(hexChars.charAt(nibble));
        }
        return hex.toString();
    }
}
