def display_results(sorted_counts):
    print("\nWord Frequency Count (excluding stopwords):")
    for word, count in sorted_counts:
        print(f"{word} -> {count}")