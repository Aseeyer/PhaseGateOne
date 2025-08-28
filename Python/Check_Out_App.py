from datetime import datetime

class Item:
    def __init__(self, name, quantity, price):
        self.name = name
        self.quantity = quantity
        self.price = price

    def get_total_of_purchase(self):
        return self.quantity * self.price


def get_cashier_name():
    return input("What is cashier's name? ")


def get_customer_name():
    return input("What is customer's name? ")


def collect_items():
    items = []
    while True:
        name = input("What did our customer buy? ")
        qty = int(input(f"How many pieces of {name} did our customer buy? "))
        price = float(input(f"How much is the {name} per unit? "))

        items.append(Item(name, qty, price))

        add_more = input("Add more items? (yes/no): ").strip().lower()
        if add_more != "yes":
            break
    return items


def get_discount():
    return float(input("Enter discount (%): "))


def calculate_sub_total(items):
    return sum(item.get_total_of_purchase() for item in items)


def print_header(cashier_name, customer_name):
    print("SEMICOLON STORES")
    print("MAIN BRANCH")
    print("LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS")
    print("TEL: 03293828343")
    print("Date:", datetime.now().strftime("%d-%b-%y %I:%M:%S %p"))
    print("Cashier:", cashier_name)
    print("Customer Name:", customer_name)
    print("-------------------------------------------")
    print(f"{'ITEM':<10} {'QTY':<5} {'PRICE':<10} {'TOTAL(NGN)':<10}")


def print_items(items):
    for item in items:
        print(f"{item.name:<10} {item.quantity:<5} {item.price:<10.2f} {item.get_total_of_purchase():<10.2f}")


def print_invoice(items, sub_total, discount, vat, bill_total, cashier_name, customer_name):
    print("\n================= INVOICE =================")
    print_header(cashier_name, customer_name)
    print_items(items)
    print("-------------------------------------------")
    print(f"Sub Total: {sub_total:.2f}")
    print(f"Discount: {discount:.2f}")
    print(f"VAT @ 7.50%: {vat:.2f}")
    print("-------------------------------------------")
    print(f"Bill Total: {bill_total:.2f}")
    print("THIS IS NOT A RECEIPT. KINDLY PAY", bill_total)
    print("===========================================\n")


def get_payment():
    return float(input("How much did the customer give to you? "))


def print_receipt(items, sub_total, discount, vat, bill_total, amount_paid, balance, cashier_name, customer_name):
    print("\n================= RECEIPT =================")
    print_header(cashier_name, customer_name)
    print_items(items)
    print("-------------------------------------------")
    print(f"Sub Total: {sub_total:.2f}")
    print(f"Discount: {discount:.2f}")
    print(f"VAT @ 7.50%: {vat:.2f}")
    print("-------------------------------------------")
    print(f"Bill Total: {bill_total:.2f}")
    print(f"Amount Paid: {amount_paid:.2f}")
    print(f"Balance: {balance:.2f}")
    print("===========================================")
    print("THANK YOU FOR YOUR PATRONAGE!")


def main():
    cashier_name = get_cashier_name()
    customer_name = get_customer_name()

    items = collect_items()

    discount_percent = get_discount()
    sub_total = calculate_sub_total(items)
    discount = (discount_percent / 100) * sub_total
    vat = 0.075 * sub_total
    bill_total = (sub_total + vat) - discount

    print_invoice(items, sub_total, discount, vat, bill_total, cashier_name, customer_name)

    amount_paid = get_payment()
    balance = amount_paid - bill_total

    print_receipt(items, sub_total, discount, vat, bill_total, amount_paid, balance, cashier_name, customer_name)


if __name__ == "__main__":
    main()
