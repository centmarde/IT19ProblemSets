def is_valid_decimal(input_str):
    if not input_str:
        return False
    
    octets = input_str.split('.')
    if len(octets) != 4:
        return False
    
    for octet in octets:
        try:
            value = int(octet)
            if value < 0 or value > 255:
                return False
        except ValueError:
            return False
    return True

def is_valid_binary(input_str):
    if not input_str or len(input_str) != 32:
        return False
    
    for c in input_str:
        if c not in ['0', '1']:
            return False
    return True

def is_valid_hexadecimal(input_str):
    if not input_str or len(input_str) != 8:
        return False
    
    for c in input_str.lower():
        if c not in '0123456789abcdef':
            return False
    return True
