import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileHandler {
    
    public static String readFile(String filename) throws IOException {
        Path filePath = Paths.get(filename);
        
        if (!Files.exists(filePath)) {
            throw new FileNotFoundException("File '" + filename + "' not found.");
        }
        
        long fileSize = Files.size(filePath);
        long maxSize = 5 * 1024 * 1024;
        
        if (fileSize > maxSize) {
            double fileSizeMB = fileSize / (1024.0 * 1024.0);
            throw new IOException(String.format("File size (%.2f MB) exceeds 5 MB limit.", fileSizeMB));
        }
        
        return new String(Files.readAllBytes(filePath), "UTF-8");
    }
    
    public static Set<String> loadStopwords(String stopwordsFile) {
        try {
            String content = readFile(stopwordsFile);
            Set<String> stopwords = new HashSet<>();
            
            String[] lines = content.split("\n");
            for (String line : lines) {
                String word = line.trim().toLowerCase();
                if (!word.isEmpty()) {
                    stopwords.add(word);
                }
            }
            
            return stopwords;
        } catch (IOException e) {
            System.out.println("Warning: Stopwords file '" + stopwordsFile + "' not found. Proceeding without stopwords.");
            return new HashSet<>();
        }
    }
    
    public static void exportResults(List<Map.Entry<String, Integer>> sortedCounts, String outputFile) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile, false))) {
            for (Map.Entry<String, Integer> entry : sortedCounts) {
                writer.println(entry.getKey() + ": " + entry.getValue());
            }
            System.out.println("\nResults exported to '" + outputFile + "'");
        } catch (IOException e) {
            System.out.println("Error writing to file '" + outputFile + "': " + e.getMessage());
        }
    }
}
