import java.util.Arrays;

class StringUtils {
    
    public static String cleanString(String text) {
        // Remove all non-alphanumeric characters and convert to lowercase
        return text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }
    
    public static boolean isPalindrome(String text) {
        String cleaned = cleanString(text);
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }
    
    public static boolean areAnagrams(String text1, String text2) {
        String cleaned1 = cleanString(text1);
        String cleaned2 = cleanString(text2);
        
        // Convert to char arrays and sort them
        char[] chars1 = cleaned1.toCharArray();
        char[] chars2 = cleaned2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        
        // Compare sorted arrays
        return Arrays.equals(chars1, chars2);
    }
}