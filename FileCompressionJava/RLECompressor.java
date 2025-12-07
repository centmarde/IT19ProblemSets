public class RLECompressor {
    
    public static String compress(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        
        StringBuilder compressed = new StringBuilder();
        int i = 0;
        
        while (i < input.length()) {
            char currentChar = input.charAt(i);
            int count = 1;
            
            while (i + count < input.length() && input.charAt(i + count) == currentChar) {
                count++;
            }
            
            compressed.append(currentChar).append(count);
            i += count;
        }
        
        return compressed.toString();
    }
}
