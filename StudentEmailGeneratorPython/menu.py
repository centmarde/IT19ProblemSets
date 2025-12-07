def display_main_menu():
    print("\n" + "="*60)
    print("STUDENT EMAIL GENERATOR SYSTEM")
    print("="*60)
    print("1. Generate New Student Email")
    print("2. Search Student Email by ID")
    print("3. Display All Students")
    print("4. Save Data to File")
    print("5. Exit")
    print("="*60)


def get_menu_choice():
    choice = input("Enter your choice (1-5): ").strip()
    return choice


def get_student_info():
    print("\n" + "-"*60)
    firstname = input("Enter student's first name: ").strip()
    lastname = input("Enter student's last name: ").strip()
    student_id = input("Enter student ID: ").strip()
    return firstname, lastname, student_id


def get_search_id():
    print("\n" + "-"*60)
    student_id = input("Enter Student ID to search: ").strip()
    return student_id


def display_success(message):
    print("\n" + "✓ " + message)


def display_error(message):
    print("\n" + "✗ " + message)


def display_result(label, value):
    print(f"\n{label}: {value}")


def confirm_exit():
    choice = input("\nAre you sure you want to exit? (y/n): ").strip().lower()
    return choice == 'y'