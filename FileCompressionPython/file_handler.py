import os

class FileHandler:
    
    @staticmethod
    def read_file(filename):
        try:
            with open(filename, 'r') as file:
                return file.read()
        except FileNotFoundError:
            raise FileNotFoundError(f"File '{filename}' not found")
        except IOError as e:
            raise IOError(f"Error reading file '{filename}': {str(e)}")
    
    @staticmethod
    def write_file(filename, content):
        try:
            with open(filename, 'w') as file:
                file.write(content)
        except IOError as e:
            raise IOError(f"Error writing to file '{filename}': {str(e)}")
    
    @staticmethod
    def file_exists(filename):
        return os.path.exists(filename)
