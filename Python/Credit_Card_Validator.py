def get_card_type(card_number: str) -> str:
    if card_number.startswith("4"):
        return "Visa"
    elif card_number.startswith("5"):
        return "MasterCard"
    elif card_number.startswith("37"):
        return "American Express"
    elif card_number.startswith("6"):
        return "Discover"
    else:
        return "Unknown"


def sum_of_double_even_place(card_number: str) -> int:
    total_sum = 0
    for position in range(len(card_number) - 2, -1, -2):
        digit = int(card_number[position])
        doubled_value = digit * 2
        total_sum += doubled_value - 9 if doubled_value > 9 else doubled_value
    return total_sum


def sum_of_odd_place(card_number: str) -> int:
    total_sum = 0
    for position in range(len(card_number) - 1, -1, -2):
        digit = int(card_number[position])
        total_sum += digit
    return total_sum


def is_valid(card_number: str) -> bool:
    even_sum = sum_of_double_even_place(card_number)
    odd_sum = sum_of_odd_place(card_number)
    total_sum = even_sum + odd_sum
    return total_sum % 10 == 0


card_number = input("Enter a credit card number: ")
card_type = get_card_type(card_number)
valid = is_valid(card_number)

print("Card Type:", card_type)
if valid:
    print(f"Card Number {card_number} is VALID")
else:
    print(f"Card Number {card_number} is INVALID")
