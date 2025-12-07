import java.util.*;
import java.util.regex.Pattern;

public class TextProcessor {
    
    private static final Pattern PUNCTUATION = Pattern.compile("\\p{Punct}+");
    
    public static String normalizeWord(String word) {
        word = PUNCTUATION.matcher(word).replaceAll("");
        word = word.toLowerCase();
        return word;
    }
    
    public static Map<String, Integer> countWords(String text, Set<String> stopwords) {
        String[] words = text.split("\\s+");
        
        Map<String, Integer> wordCounts = new HashMap<>();
        
        for (String word : words) {
            String normalized = normalizeWord(word);
            if (!normalized.isEmpty() && !stopwords.contains(normalized)) {
                wordCounts.put(normalized, wordCounts.getOrDefault(normalized, 0) + 1);
            }
        }
        
        return wordCounts;
    }
    
    public static List<Map.Entry<String, Integer>> sortWordCounts(Map<String, Integer> wordCounts) {
        List<Map.Entry<String, Integer>> sortedCounts = new ArrayList<>(wordCounts.entrySet());
        
        sortedCounts.sort((entry1, entry2) -> {
            int countComparison = Integer.compare(entry2.getValue(), entry1.getValue());
            if (countComparison == 0) {
                return entry1.getKey().compareTo(entry2.getKey());
            }
            return countComparison;
        });
        
        return sortedCounts;
    }
}
