from file_handler import read_file, load_stopwords, export_results
from text_processor import count_words, sort_word_counts
from display import display_results


class TextAnalyzer:
    
    def __init__(self, input_file="input.txt", stopwords_file="stopwords.txt", output_file="output.txt"):
        self.input_file = input_file
        self.stopwords_file = stopwords_file
        self.output_file = output_file
        self.text = None
        self.stopwords = None
        self.word_counts = None
        self.sorted_counts = None
    
    def load_data(self):
        print(f"Reading input file: {self.input_file}")
        self.text = read_file(self.input_file)
        
        if not self.text.strip():
            raise ValueError("Input file is empty. Please provide a text file with content.")
        
        print(f"Loading stopwords from: {self.stopwords_file}")
        self.stopwords = load_stopwords(self.stopwords_file)
    
    def analyze(self):
        print("Analyzing text...")
        self.word_counts = count_words(self.text, self.stopwords)
        
        if not self.word_counts:
            raise ValueError("No words found after filtering stopwords.")
        
        self.sorted_counts = sort_word_counts(self.word_counts)
    
    def show_results(self):
        display_results(self.sorted_counts)
    
    def save_results(self):
        export_results(self.sorted_counts, self.output_file)
    
    def run(self):
        try:
            self.load_data()
            self.analyze()
            self.show_results()
            self.save_results()
        except FileNotFoundError as e:
            print(f"Error: {e}")
        except ValueError as e:
            print(f"Error: {e}")
        except Exception as e:
            print(f"An unexpected error occurred: {e}")