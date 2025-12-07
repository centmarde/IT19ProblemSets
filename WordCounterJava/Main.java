public class Main {
    
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String stopwordsFile = "stopwords.txt";
        String outputFile = "output.txt";
        
        TextAnalyzer analyzer = new TextAnalyzer(inputFile, stopwordsFile, outputFile);
        analyzer.run();
    }
}