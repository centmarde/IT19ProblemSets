import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileHandler {
    private static final String STORAGE_FILE = "student_emails.txt";
    
    public void saveToFile(Map<String, Student> students) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(STORAGE_FILE))) {
            for (Map.Entry<String, Student> entry : students.entrySet()) {
                String studentId = entry.getKey();
                Student student = entry.getValue();
                writer.println(studentId + "|" + student.getName() + "|" + student.getEmail());
            }
            System.out.println("Data saved to " + STORAGE_FILE);
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }
    
    public Map<String, Student> loadFromFile() {
        Map<String, Student> students = new HashMap<>();
        
        File file = new File(STORAGE_FILE);
        if (!file.exists()) {
            return students;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(STORAGE_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    String[] parts = line.split("\\|");
                    if (parts.length == 3) {
                        String studentId = parts[0];
                        String name = parts[1];
                        String email = parts[2];
                        students.put(studentId, new Student(name, email));
                    }
                }
            }
            System.out.println("Loaded " + students.size() + " student(s) from " + STORAGE_FILE);
        } catch (IOException e) {
            System.out.println("Error loading from file: " + e.getMessage());
        }
        
        return students;
    }
}
