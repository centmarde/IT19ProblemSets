import string
from collections import Counter


def normalize_word(word):
    word = word.strip(string.punctuation)
    word = word.lower()
    return word


def count_words(text, stopwords):
    words = text.split()
    
    normalized_words = []
    for word in words:
        normalized = normalize_word(word)
        if normalized and normalized not in stopwords:
            normalized_words.append(normalized)
    
    word_counts = Counter(normalized_words)
    
    return dict(word_counts)


def sort_word_counts(word_counts):
    sorted_counts = sorted(word_counts.items(), key=lambda x: (-x[1], x[0]))
    return sorted_counts