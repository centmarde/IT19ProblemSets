"""
Text Analysis Tool - Word Frequency Counter
Reads a text file, counts word frequencies while excluding stopwords,
and displays results in descending order.
"""

import string
import os
from collections import Counter


def read_file(filename):
    """
    Read and return the contents of a file.
    
    Args:
        filename (str): Path to the file to read
        
    Returns:
        str: Contents of the file
        
    Raises:
        FileNotFoundError: If the file doesn't exist
        IOError: If there's an error reading the file
    """
    if not os.path.exists(filename):
        raise FileNotFoundError(f"File '{filename}' not found.")
    
    # Check file size (max 5 MB)
    file_size = os.path.getsize(filename)
    if file_size > 5 * 1024 * 1024:  # 5 MB in bytes
        raise ValueError(f"File size ({file_size / (1024*1024):.2f} MB) exceeds 5 MB limit.")
    
    with open(filename, 'r', encoding='utf-8') as file:
        content = file.read()
    
    return content


def load_stopwords(stopwords_file):
    """
    Load stopwords from a file into a set.
    
    Args:
        stopwords_file (str): Path to the stopwords file
        
    Returns:
        set: Set of stopwords in lowercase
    """
    try:
        content = read_file(stopwords_file)
        # Split by lines and strip whitespace, convert to lowercase
        stopwords = set(word.strip().lower() for word in content.split('\n') if word.strip())
        return stopwords
    except FileNotFoundError:
        print(f"Warning: Stopwords file '{stopwords_file}' not found. Proceeding without stopwords.")
        return set()


def normalize_word(word):
    """
    Normalize a word by converting to lowercase and removing punctuation.
    
    Args:
        word (str): Word to normalize
        
    Returns:
        str: Normalized word
    """
    # Remove punctuation from the word
    word = word.strip(string.punctuation)
    # Convert to lowercase
    word = word.lower()
    return word


def count_words(text, stopwords):
    """
    Count the frequency of words in text, excluding stopwords.
    
    Args:
        text (str): Text to analyze
        stopwords (set): Set of stopwords to exclude
        
    Returns:
        dict: Dictionary mapping words to their frequencies
    """
    # Split text into words
    words = text.split()
    
    # Normalize words and filter out stopwords and empty strings
    normalized_words = []
    for word in words:
        normalized = normalize_word(word)
        if normalized and normalized not in stopwords:
            normalized_words.append(normalized)
    
    # Count word frequencies using Counter
    word_counts = Counter(normalized_words)
    
    return dict(word_counts)


def sort_word_counts(word_counts):
    """
    Sort word counts in descending order of frequency.
    
    Args:
        word_counts (dict): Dictionary of word frequencies
        
    Returns:
        list: List of tuples (word, count) sorted by count (descending)
    """
    # Sort by count (descending), then alphabetically for ties
    sorted_counts = sorted(word_counts.items(), key=lambda x: (-x[1], x[0]))
    return sorted_counts


def display_results(sorted_counts):
    """
    Display word frequency results to the console.
    
    Args:
        sorted_counts (list): List of tuples (word, count)
    """
    print("\nWord Frequency Count (excluding stopwords):")
    for word, count in sorted_counts:
        print(f"{word} -> {count}")


def export_results(sorted_counts, output_file):
    """
    Export word frequency results to a file.
    
    Args:
        sorted_counts (list): List of tuples (word, count)
        output_file (str): Path to the output file
    """
    try:
        with open(output_file, 'w', encoding='utf-8') as file:
            for word, count in sorted_counts:
                file.write(f"{word}: {count}\n")
        print(f"\nResults exported to '{output_file}'")
    except IOError as e:
        print(f"Error writing to file '{output_file}': {e}")


def main():
    """
    Main function to run the text analysis tool.
    """
    # File paths
    input_file = "input.txt"
    stopwords_file = "stopwords.txt"
    output_file = "output.txt"
    
    try:
        # Read input text
        print(f"Reading input file: {input_file}")
        text = read_file(input_file)
        
        # Check if file is empty
        if not text.strip():
            print("Error: Input file is empty. Please provide a text file with content.")
            return
        
        # Load stopwords
        print(f"Loading stopwords from: {stopwords_file}")
        stopwords = load_stopwords(stopwords_file)
        
        # Count words
        print("Analyzing text...")
        word_counts = count_words(text, stopwords)
        
        # Check if any words remain after filtering
        if not word_counts:
            print("No words found after filtering stopwords.")
            return
        
        # Sort results
        sorted_counts = sort_word_counts(word_counts)
        
        # Display results
        display_results(sorted_counts)
        
        # Export results
        export_results(sorted_counts, output_file)
        
    except FileNotFoundError as e:
        print(f"Error: {e}")
    except ValueError as e:
        print(f"Error: {e}")
    except Exception as e:
        print(f"An unexpected error occurred: {e}")


if __name__ == "__main__":
    main()