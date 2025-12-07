import java.util.*;

public class Display {
    
    public static void displayResults(List<Map.Entry<String, Integer>> sortedCounts) {
        System.out.println("\nWord Frequency Count (excluding stopwords):");
        for (Map.Entry<String, Integer> entry : sortedCounts) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
