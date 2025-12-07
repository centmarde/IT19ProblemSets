import java.util.HashMap;
import java.util.Map;

public class StudentManager {
    private Map<String, Student> students;
    
    public StudentManager() {
        this.students = new HashMap<>();
    }
    
    public void addStudent(String name, String studentId, String email) {
        students.put(studentId, new Student(name, email));
    }
    
    public String getStudentEmail(String studentId) {
        Student student = students.get(studentId);
        return student != null ? student.getEmail() : null;
    }
    
    public Map<String, String> getAllEmails() {
        Map<String, String> emails = new HashMap<>();
        for (Map.Entry<String, Student> entry : students.entrySet()) {
            emails.put(entry.getKey(), entry.getValue().getEmail());
        }
        return emails;
    }
    
    public boolean studentExists(String studentId) {
        return students.containsKey(studentId);
    }
    
    public int getStudentCount() {
        return students.size();
    }
    
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the system yet.");
            return;
        }
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("ALL REGISTERED STUDENTS");
        System.out.println("=".repeat(60));
        
        for (Map.Entry<String, Student> entry : students.entrySet()) {
            String studentId = entry.getKey();
            Student student = entry.getValue();
            
            System.out.println("ID: " + studentId);
            System.out.println("Name: " + student.getName());
            System.out.println("Email: " + student.getEmail());
            System.out.println("-".repeat(60));
        }
    }
    
    public Map<String, Student> getStudents() {
        return students;
    }
    
    public void setStudents(Map<String, Student> students) {
        this.students = students;
    }
}

class Student {
    private String name;
    private String email;
    
    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
}
