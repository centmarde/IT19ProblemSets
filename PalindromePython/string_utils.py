import re

def clean_string(text):
    return re.sub(r'[^a-zA-Z0-9]', '', text).lower()

def is_palindrome(text):
    cleaned = clean_string(text)
   
    char_array = list(cleaned)
   
    reversed_array = char_array[::-1]
    return char_array == reversed_array

def are_anagrams(text1, text2):
    cleaned1 = clean_string(text1)
    cleaned2 = clean_string(text2)
   
    array1 = list(cleaned1)
    array2 = list(cleaned2)
   
    sorted_array1 = sorted(array1)
    sorted_array2 = sorted(array2)
    return sorted_array1 == sorted_array2