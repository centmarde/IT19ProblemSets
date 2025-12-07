from analyzer import TextAnalyzer


def main():
    input_file = "input.txt"
    stopwords_file = "stopwords.txt"
    output_file = "output.txt"
    
    analyzer = TextAnalyzer(input_file, stopwords_file, output_file)
    analyzer.run()


if __name__ == "__main__":
    main()