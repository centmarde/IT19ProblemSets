from string_utils import is_palindrome, are_anagrams

def display_menu():
    print("===== Palindrome & Anagram Tool =====")
    print("1. Palindrome Checker")
    print("2. Anagram Checker")
    print("3. Exit")

def get_user_choice():
    return input("Choose an option: ")

def palindrome_checker():
    text = input("Enter word/phrase: ")
    result = "Palindrome" if is_palindrome(text) else "Not Palindrome"
    print(f"Output: {result}")

def anagram_checker():
    text1 = input("Enter first word/phrase: ")
    text2 = input("Enter second word/phrase: ")
    result = "Anagrams" if are_anagrams(text1, text2) else "Not Anagrams"
    print(f"Output: {result}")

def run_application():
    while True:
        display_menu()
        choice = get_user_choice()
        
        if choice == "1":
            palindrome_checker()
        elif choice == "2":
            anagram_checker()
        elif choice == "3":
            print("Goodbye!")
            break
        else:
            print("Invalid option. Please try again.")
        print()

if __name__ == "__main__":
    run_application()