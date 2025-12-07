class RLECompressor:
    
    @staticmethod
    def compress(input_text):
        if not input_text:
            return ""
        
        compressed = []
        i = 0
        
        while i < len(input_text):
            current_char = input_text[i]
            count = 1
            
            while i + count < len(input_text) and input_text[i + count] == current_char:
                count += 1
            
            compressed.append(current_char + str(count))
            i += count
        
        return ''.join(compressed)
