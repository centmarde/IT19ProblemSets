import re

def clean_string(text):
    return re.sub(r'[^a-zA-Z0-9]', '', text).lower()

def is_palindrome(text):
    cleaned = clean_string(text)
    return cleaned == cleaned[::-1]

def are_anagrams(text1, text2):
    cleaned1 = clean_string(text1)
    cleaned2 = clean_string(text2)
    return sorted(cleaned1) == sorted(cleaned2)