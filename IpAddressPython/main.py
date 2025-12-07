from ip_validator import is_valid_decimal, is_valid_binary, is_valid_hexadecimal
from ip_converter import decimal_to_octets, binary_to_octets, hex_to_octets
from ip_display import display_results, display_error

def main():
    input_str = input("Enter IP Address (Decimal/Binary/Hex): ").strip()
    
    octets = None
    
    if is_valid_decimal(input_str):
        octets = decimal_to_octets(input_str)
    elif is_valid_binary(input_str):
        octets = binary_to_octets(input_str)
    elif is_valid_hexadecimal(input_str):
        octets = hex_to_octets(input_str)
    else:
        display_error("Invalid input format. Please enter a valid decimal IP, 32-bit binary, or 8-character hex.")
        return
    
    display_results(octets)

if __name__ == "__main__":
    main()