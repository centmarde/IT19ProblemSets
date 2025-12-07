from ip_converter import octets_to_decimal, octets_to_binary, octets_to_hex

def display_results(octets):
    decimal = octets_to_decimal(octets)
    binary = octets_to_binary(octets)
    hex_str = octets_to_hex(octets)
    
    print("Output:")
    print(f"Decimal: {decimal}")
    print(f"Binary : {binary}")
    print(f"Hex : {hex_str}")

def display_error(message):
    print(f"Error: {message}")
