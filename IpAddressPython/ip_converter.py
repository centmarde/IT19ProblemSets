def decimal_to_octets(decimal):
    parts = decimal.split('.')
    return [int(part) for part in parts]

def binary_to_octets(binary):
    octets = []
    for i in range(4):
        octet_binary = binary[i * 8:(i + 1) * 8]
        octets.append(binary_to_decimal(octet_binary))
    return octets

def hex_to_octets(hex_str):
    hex_str = hex_str.upper()
    octets = []
    for i in range(4):
        octet_hex = hex_str[i * 2:(i + 1) * 2]
        octets.append(hex_to_decimal(octet_hex))
    return octets

def octets_to_decimal(octets):
    return '.'.join(str(octet) for octet in octets)

def octets_to_binary(octets):
    binary_parts = []
    for octet in octets:
        binary_parts.append(decimal_to_binary(octet, 8))
    return '.'.join(binary_parts)

def octets_to_hex(octets):
    hex_str = ''
    for octet in octets:
        hex_str += decimal_to_hex(octet, 2)
    return hex_str

def binary_to_decimal(binary):
    result = 0
    power = 0
    for i in range(len(binary) - 1, -1, -1):
        if binary[i] == '1':
            result += (1 << power)
        power += 1
    return result

def hex_to_decimal(hex_str):
    result = 0
    power = 0
    for i in range(len(hex_str) - 1, -1, -1):
        c = hex_str[i]
        if c.isdigit():
            digit = int(c)
        else:
            digit = ord(c) - ord('A') + 10
        result += digit * (16 ** power)
        power += 1
    return result

def decimal_to_binary(decimal, length):
    binary = ''
    for i in range(length - 1, -1, -1):
        if (decimal & (1 << i)) != 0:
            binary += '1'
        else:
            binary += '0'
    return binary

def decimal_to_hex(decimal, length):
    hex_chars = '0123456789ABCDEF'
    hex_str = ''
    for i in range(length - 1, -1, -1):
        nibble = (decimal >> (i * 4)) & 0xF
        hex_str += hex_chars[nibble]
    return hex_str
