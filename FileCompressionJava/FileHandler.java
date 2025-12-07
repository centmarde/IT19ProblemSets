import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHandler {
    
    public static String readFile(String filename) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filename)));
    }
    
    public static void writeFile(String filename, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
        }
    }
    
    public static boolean fileExists(String filename) {
        return Files.exists(Paths.get(filename));
    }
}
