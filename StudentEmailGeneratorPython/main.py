from email_generator import generate_email, validate_input
from student_manager import StudentManager
from file_handler import save_to_file, load_from_file
from menu import (
    display_main_menu, 
    get_menu_choice, 
    get_student_info,
    get_search_id,
    display_success,
    display_error,
    display_result,
    confirm_exit
)


def process_new_student(manager):
    firstname, lastname, student_id = get_student_info()
    
    is_valid, error_message = validate_input(firstname, student_id)
    if is_valid:
        is_valid, error_message = validate_input(lastname, student_id)
    
    if not is_valid:
        display_error(error_message)
        return
    
    if manager.student_exists(student_id):
        display_error(f"Student with ID {student_id} already exists in the system.")
        existing_email = manager.get_student_email(student_id)
        display_result("Existing Email", existing_email)
        return
    
    existing_emails = manager.get_all_emails()
    email = generate_email(firstname, lastname, student_id, existing_emails)
    
    full_name = f"{firstname} {lastname}"
    
    manager.add_student(full_name, student_id, email)
    
    display_success("Email generated successfully!")
    display_result("Generated Email", email)


def process_search_student(manager):
    student_id = get_search_id()
    
    email = manager.get_student_email(student_id)
    
    if email:
        display_result("Result", email)
    else:
        display_error(f"No student found with ID: {student_id}")


def process_display_all(manager):
    manager.display_all_students()


def process_save_data(manager):
    save_to_file(manager.students)
    display_success("Data saved successfully!")


def main():
    print("\n" + "="*60)
    print("INITIALIZING STUDENT EMAIL GENERATOR SYSTEM")
    print("="*60)
    
    manager = StudentManager()
    
    loaded_data = load_from_file()
    manager.students = loaded_data
    
    while True:
        display_main_menu()
        choice = get_menu_choice()
        
        if choice == '1':
            process_new_student(manager)
        
        elif choice == '2':
            process_search_student(manager)
        
        elif choice == '3':
            process_display_all(manager)
        
        elif choice == '4':
            process_save_data(manager)
        
        elif choice == '5':
            if confirm_exit():
                save_to_file(manager.students)
                print("\nThank you for using Student Email Generator System!")
                print("Goodbye!\n")
                break
        
        else:
            display_error("Invalid choice. Please enter a number between 1 and 5.")


if __name__ == "__main__":
    main()