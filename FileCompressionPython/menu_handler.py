class MenuHandler:
    
    def __init__(self):
        pass
    
    def display_menu(self):
        print("\n=== File Compression Simulator ===")
        print("1. Compress File")
        print("2. Decompress File")
        print("3. Exit")
        print("Choose an option (1-3): ", end="")
    
    def get_user_choice(self):
        try:
            choice = input().strip()
            return int(choice)
        except ValueError:
            return -1
