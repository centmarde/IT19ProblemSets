import java.io.IOException;
import java.util.*;

public class TextAnalyzer {
    
    private String inputFile;
    private String stopwordsFile;
    private String outputFile;
    private String text;
    private Set<String> stopwords;
    private Map<String, Integer> wordCounts;
    private List<Map.Entry<String, Integer>> sortedCounts;
    
    public TextAnalyzer(String inputFile, String stopwordsFile, String outputFile) {
        this.inputFile = inputFile;
        this.stopwordsFile = stopwordsFile;
        this.outputFile = outputFile;
    }
    
    public void loadData() throws IOException {
        System.out.println("Reading input file: " + inputFile);
        this.text = FileHandler.readFile(inputFile);
        
        if (text.trim().isEmpty()) {
            throw new IllegalArgumentException("Input file is empty. Please provide a text file with content.");
        }
        
        System.out.println("Loading stopwords from: " + stopwordsFile);
        this.stopwords = FileHandler.loadStopwords(stopwordsFile);
    }
    
    public void analyze() {
        System.out.println("Analyzing text...");
        this.wordCounts = TextProcessor.countWords(text, stopwords);
        
        if (wordCounts.isEmpty()) {
            throw new IllegalArgumentException("No words found after filtering stopwords.");
        }
        
        this.sortedCounts = TextProcessor.sortWordCounts(wordCounts);
    }
    
    public void showResults() {
        Display.displayResults(sortedCounts);
    }
    
    public void saveResults() {
        FileHandler.exportResults(sortedCounts, outputFile);
    }
    
    public void run() {
        try {
            loadData();
            analyze();
            showResults();
            saveResults();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
