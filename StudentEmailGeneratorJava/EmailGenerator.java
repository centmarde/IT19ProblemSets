import java.util.Map;

public class EmailGenerator {
    
    public String generateEmail(String firstname, String lastname, String studentId, 
                               Map<String, String> existingEmails) {
        String firstnameLower = firstname.toLowerCase().trim();
        String lastnameLower = lastname.toLowerCase().trim();
        
        String emailPrefix = firstnameLower + "." + lastnameLower;
        String lastTwoDigits = studentId.substring(studentId.length() - 2);
        
        String baseEmail = emailPrefix + lastTwoDigits + "@university.edu";
        String email = baseEmail;
        
        int counter = 1;
        while (existingEmails.containsValue(email)) {
            email = emailPrefix + lastTwoDigits + "_" + counter + "@university.edu";
            counter++;
        }
        
        return email;
    }
    
    public boolean validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        
        for (char c : name.toCharArray()) {
            if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean validateStudentId(String studentId) {
        if (studentId == null || studentId.trim().isEmpty()) {
            return false;
        }
        
        return studentId.trim().matches("\\d+");
    }
    
    public ValidationResult validateInput(String name, String studentId) {
        if (!validateName(name)) {
            return new ValidationResult(false, "Error: Invalid name. Name must contain only letters and spaces.");
        }
        
        if (!validateStudentId(studentId)) {
            return new ValidationResult(false, "Error: Invalid ID. Student ID must be numeric.");
        }
        
        return new ValidationResult(true, "");
    }
}

class ValidationResult {
    private boolean valid;
    private String errorMessage;
    
    public ValidationResult(boolean valid, String errorMessage) {
        this.valid = valid;
        this.errorMessage = errorMessage;
    }
    
    public boolean isValid() {
        return valid;
    }
    
    public String getErrorMessage() {
        return errorMessage;
    }
}
