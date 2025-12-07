public class RLEDecompressor {
    
    public static String decompress(String compressed) throws InvalidRLEFormatException {
        if (compressed == null || compressed.isEmpty()) {
            return "";
        }
        
        StringBuilder decompressed = new StringBuilder();
        int i = 0;
        
        while (i < compressed.length()) {
            if (i + 1 >= compressed.length()) {
                throw new InvalidRLEFormatException("Invalid RLE format: incomplete pair at position " + i);
            }
            
            char character = compressed.charAt(i);
            StringBuilder countStr = new StringBuilder();
            i++;
            
            while (i < compressed.length() && Character.isDigit(compressed.charAt(i))) {
                countStr.append(compressed.charAt(i));
                i++;
            }
            
            if (countStr.length() == 0) {
                throw new InvalidRLEFormatException("Invalid RLE format: no count found after character '" + character + "'");
            }
            
            try {
                int count = Integer.parseInt(countStr.toString());
                if (count <= 0) {
                    throw new InvalidRLEFormatException("Invalid RLE format: count must be positive, got " + count);
                }
                
                for (int j = 0; j < count; j++) {
                    decompressed.append(character);
                }
            } catch (NumberFormatException e) {
                throw new InvalidRLEFormatException("Invalid RLE format: invalid count '" + countStr + "'");
            }
        }
        
        return decompressed.toString();
    }
    
    public static class InvalidRLEFormatException extends Exception {
        public InvalidRLEFormatException(String message) {
            super(message);
        }
    }
}
