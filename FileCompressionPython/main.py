from file_handler import FileHandler
from rle_compressor import RLECompressor
from rle_decompressor import RLEDecompressor, InvalidRLEFormatException
from menu_handler import MenuHandler

class Main:
    INPUT_FILE = "input.txt"
    COMPRESSED_FILE = "compressed.txt"
    DECOMPRESSED_FILE = "decompressed.txt"
    
    def __init__(self):
        self.menu_handler = MenuHandler()
    
    def run(self):
        running = True
        
        while running:
            self.menu_handler.display_menu()
            choice = self.menu_handler.get_user_choice()
            
            if choice == 1:
                self.compress_file()
            elif choice == 2:
                self.decompress_file()
            elif choice == 3:
                print("Exiting...")
                running = False
            else:
                print("Invalid option. Please choose 1, 2, or 3.")
    
    def compress_file(self):
        try:
            if not FileHandler.file_exists(self.INPUT_FILE):
                print(f"Error: {self.INPUT_FILE} not found.")
                return
            
            content = FileHandler.read_file(self.INPUT_FILE)
            compressed = RLECompressor.compress(content)
            FileHandler.write_file(self.COMPRESSED_FILE, compressed)
            
            print("File compressed successfully!")
            print(f"Original size: {len(content)} characters")
            print(f"Compressed size: {len(compressed)} characters")
            compression_ratio = (1.0 - len(compressed) / len(content)) * 100 if len(content) > 0 else 0
            print(f"Compression ratio: {compression_ratio:.2f}%")
            
        except (FileNotFoundError, IOError) as e:
            print(f"Error during compression: {e}")
    
    def decompress_file(self):
        try:
            if not FileHandler.file_exists(self.COMPRESSED_FILE):
                print(f"Error: {self.COMPRESSED_FILE} not found.")
                return
            
            compressed = FileHandler.read_file(self.COMPRESSED_FILE)
            decompressed = RLEDecompressor.decompress(compressed)
            FileHandler.write_file(self.DECOMPRESSED_FILE, decompressed)
            
            print("File decompressed successfully!")
            print(f"Compressed size: {len(compressed)} characters")
            print(f"Decompressed size: {len(decompressed)} characters")
            
        except (FileNotFoundError, IOError) as e:
            print(f"Error during decompression: {e}")
        except InvalidRLEFormatException as e:
            print(f"Error: {e}")

if __name__ == "__main__":
    app = Main()
    app.run()