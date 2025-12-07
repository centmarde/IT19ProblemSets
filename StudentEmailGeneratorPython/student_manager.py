class StudentManager:
    
    def __init__(self):
        self.students = {}
    
    def add_student(self, name, student_id, email):
        self.students[student_id] = {
            'name': name,
            'email': email
        }
    
    def get_student_email(self, student_id):
        if student_id in self.students:
            return self.students[student_id]['email']
        return None
    
    def get_all_emails(self):
        return {sid: data['email'] for sid, data in self.students.items()}
    
    def student_exists(self, student_id):
        return student_id in self.students
    
    def get_student_count(self):
        return len(self.students)
    
    def display_all_students(self):
        if not self.students:
            print("No students in the system yet.")
            return
        
        print("\n" + "="*60)
        print("ALL REGISTERED STUDENTS")
        print("="*60)
        for student_id, data in self.students.items():
            print(f"ID: {student_id}")
            print(f"Name: {data['name']}")
            print(f"Email: {data['email']}")
            print("-"*60)