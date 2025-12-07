class InvalidRLEFormatException(Exception):
    pass

class RLEDecompressor:
    
    @staticmethod
    def decompress(compressed_text):
        if not compressed_text:
            return ""
        
        decompressed = []
        i = 0
        
        while i < len(compressed_text):
            if i + 1 >= len(compressed_text):
                raise InvalidRLEFormatException(f"Invalid RLE format: incomplete pair at position {i}")
            
            character = compressed_text[i]
            count_str = ""
            i += 1
            
            while i < len(compressed_text) and compressed_text[i].isdigit():
                count_str += compressed_text[i]
                i += 1
            
            if not count_str:
                raise InvalidRLEFormatException(f"Invalid RLE format: no count found after character '{character}'")
            
            try:
                count = int(count_str)
                if count <= 0:
                    raise InvalidRLEFormatException(f"Invalid RLE format: count must be positive, got {count}")
                
                decompressed.append(character * count)
            except ValueError:
                raise InvalidRLEFormatException(f"Invalid RLE format: invalid count '{count_str}'")
        
        return ''.join(decompressed)
