def generate_email(firstname, lastname, student_id, existing_emails):
    firstname_lower = firstname.lower().strip()
    lastname_lower = lastname.lower().strip()
    
    email_prefix = f"{firstname_lower}.{lastname_lower}"
    
    last_two_digits = student_id[-2:]
    
    base_email = f"{email_prefix}{last_two_digits}@university.edu"
    
    email = base_email
    counter = 1
    while email in existing_emails.values():
        email = f"{email_prefix}{last_two_digits}_{counter}@university.edu"
        counter += 1
    
    return email


def validate_name(name):
    if not name or not name.strip():
        return False
    
    for char in name:
        if not (char.isalpha() or char.isspace()):
            return False
    
    return True


def validate_student_id(student_id):
    if not student_id or not student_id.strip():
        return False
    
    return student_id.strip().isdigit()


def validate_input(name, student_id):
    if not validate_name(name):
        return False, "Error: Invalid name. Name must contain only letters and spaces."
    
    if not validate_student_id(student_id):
        return False, "Error: Invalid ID. Student ID must be numeric."
    
    return True, ""