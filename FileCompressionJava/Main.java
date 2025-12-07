import java.io.IOException;

public class Main {
    private static final String INPUT_FILE = "input.txt";
    private static final String COMPRESSED_FILE = "compressed.txt";
    private static final String DECOMPRESSED_FILE = "decompressed.txt";
    
    private MenuHandler menuHandler;
    
    public Main() {
        this.menuHandler = new MenuHandler();
    }
    
    public static void main(String[] args) {
        Main app = new Main();
        app.run();
    }
    
    public void run() {
        boolean running = true;
        
        while (running) {
            menuHandler.displayMenu();
            int choice = menuHandler.getUserChoice();
            
            switch (choice) {
                case 1:
                    compressFile();
                    break;
                case 2:
                    decompressFile();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1, 2, or 3.");
            }
        }
        
        menuHandler.closeScanner();
    }
    
    private void compressFile() {
        try {
            if (!FileHandler.fileExists(INPUT_FILE)) {
                System.out.println("Error: " + INPUT_FILE + " not found.");
                return;
            }
            
            String content = FileHandler.readFile(INPUT_FILE);
            String compressed = RLECompressor.compress(content);
            FileHandler.writeFile(COMPRESSED_FILE, compressed);
            
            System.out.println("File compressed successfully!");
            System.out.println("Original size: " + content.length() + " characters");
            System.out.println("Compressed size: " + compressed.length() + " characters");
            System.out.println("Compression ratio: " + String.format("%.2f%%", 
                (1.0 - (double) compressed.length() / content.length()) * 100));
            
        } catch (IOException e) {
            System.out.println("Error during compression: " + e.getMessage());
        }
    }
    
    private void decompressFile() {
        try {
            if (!FileHandler.fileExists(COMPRESSED_FILE)) {
                System.out.println("Error: " + COMPRESSED_FILE + " not found.");
                return;
            }
            
            String compressed = FileHandler.readFile(COMPRESSED_FILE);
            String decompressed = RLEDecompressor.decompress(compressed);
            FileHandler.writeFile(DECOMPRESSED_FILE, decompressed);
            
            System.out.println("File decompressed successfully!");
            System.out.println("Compressed size: " + compressed.length() + " characters");
            System.out.println("Decompressed size: " + decompressed.length() + " characters");
            
        } catch (IOException e) {
            System.out.println("Error during decompression: " + e.getMessage());
        } catch (RLEDecompressor.InvalidRLEFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}