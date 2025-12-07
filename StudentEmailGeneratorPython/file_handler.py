import os

STORAGE_FILE = "student_emails.txt"


def save_to_file(students):
    try:
        with open(STORAGE_FILE, 'w') as file:
            for student_id, data in students.items():
                file.write(f"{student_id}|{data['name']}|{data['email']}\n")
        print(f"Data saved to {STORAGE_FILE}")
    except Exception as e:
        print(f"Error saving to file: {e}")


def load_from_file():
    students = {}
    
    if not os.path.exists(STORAGE_FILE):
        return students
    
    try:
        with open(STORAGE_FILE, 'r') as file:
            for line in file:
                line = line.strip()
                if line:
                    parts = line.split('|')
                    if len(parts) == 3:
                        student_id, name, email = parts
                        students[student_id] = {
                            'name': name,
                            'email': email
                        }
        print(f"Loaded {len(students)} student(s) from {STORAGE_FILE}")
    except Exception as e:
        print(f"Error loading from file: {e}")
    
    return students