import os


def read_file(filename):
    if not os.path.exists(filename):
        raise FileNotFoundError(f"File '{filename}' not found.")
    
    file_size = os.path.getsize(filename)
    if file_size > 5 * 1024 * 1024:
        raise ValueError(f"File size ({file_size / (1024*1024):.2f} MB) exceeds 5 MB limit.")
    
    with open(filename, 'r', encoding='utf-8') as file:
        content = file.read()
    
    return content


def load_stopwords(stopwords_file):
    try:
        content = read_file(stopwords_file)
        stopwords = set(word.strip().lower() for word in content.split('\n') if word.strip())
        return stopwords
    except FileNotFoundError:
        print(f"Warning: Stopwords file '{stopwords_file}' not found. Proceeding without stopwords.")
        return set()


def export_results(sorted_counts, output_file):
    try:
        with open(output_file, 'w', encoding='utf-8') as file:
            for word, count in sorted_counts:
                file.write(f"{word}: {count}\n")
        print(f"\nResults exported to '{output_file}'")
    except IOError as e:
        print(f"Error writing to file '{output_file}': {e}")