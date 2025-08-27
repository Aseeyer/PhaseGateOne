import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Item {
    String name;
    int quantity;
    double price;

    Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    double getTotalOfPurchase() {
        return quantity * price;
    }
}

public class CheckOutApp {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String cashierName = getCashierName();
        String customerName = getCustomerName();

        List<Item> items = collectItems();

        double discountPercent = getDiscount();
        double subTotal = calculateSubTotal(items);
        double discount = (discountPercent / 100) * subTotal;
        double vat = 0.175 * subTotal;
        double billTotal = (subTotal + vat) - discount;

        printInvoice(items, subTotal, discount, vat, billTotal, cashierName, customerName);

        double amountPaid = getPayment();
        double balance = amountPaid - billTotal;

        printReceipt(items, subTotal, discount, vat, billTotal, amountPaid, balance, cashierName, customerName);
    }

    static List<Item> collectItems() {
        List<Item> items = new ArrayList<>();

        while (true) {
            System.out.print("What did our customer buy? ");
            String name = input.nextLine();

            System.out.printf("How many pieces of %s did our customer buy? ", name);
            int qty = input.nextInt();

            System.out.printf("How much is the %s per unit? ", name);
            double price = input.nextDouble();

            input.nextLine();

            items.add(new Item(name, qty, price));

            System.out.print("Add more items? (yes/no): ");
            String addMore = input.nextLine();
            if (!addMore.equalsIgnoreCase("yes")) {
                break;
            }
        }
        return items;
    }

    static double getDiscount() {
        System.out.print("Enter discount (%): ");
        return input.nextDouble();
    }

    static double calculateSubTotal(List<Item> items) {
        double subTotal = 0;
        for (Item item : items) {
            subTotal += item.getTotalOfPurchase();
        }
        return subTotal;
    }

    static void printInvoice(List<Item> items, double subTotal, double discount, double vat, double billTotal,
                             String cashierName, String customerName) {
        System.out.println("\n================= INVOICE =================");
        printHeader(cashierName, customerName);
        printItems(items);
        System.out.println("-------------------------------------------");
        System.out.printf("Sub Total: %.2f%n", subTotal);
        System.out.printf("Discount: %.2f%n", discount);
        System.out.printf("VAT @ 17.50%%: %.2f%n", vat);
        System.out.println("-------------------------------------------");
        System.out.printf("Bill Total: %.2f%n", billTotal);
        System.out.println("THIS IS NOT A RECEIPT. KINDLY PAY " + billTotal);
        System.out.println("===========================================\n");
    }

    static double getPayment() {
        System.out.print("How much did the customer give to you? ");
        return input.nextDouble();
    }

    static String getCustomerName() {
        System.out.print("What is customer's name? ");
        return input.nextLine();
    }

    static String getCashierName() {
        System.out.print("What is cashier's name? ");
        return input.nextLine();
    }

    static void printReceipt(List<Item> items, double subTotal, double discount, double vat, double billTotal,
                             double amountPaid, double balance, String cashierName, String customerName) {
        System.out.println("\n================= RECEIPT =================");
        printHeader(cashierName, customerName);
        printItems(items);
        System.out.println("-------------------------------------------");
        System.out.printf("Sub Total: %.2f%n", subTotal);
        System.out.printf("Discount: %.2f%n", discount);
        System.out.printf("VAT @ 17.50%%: %.2f%n", vat);
        System.out.println("-------------------------------------------");
        System.out.printf("Bill Total: %.2f%n", billTotal);
        System.out.printf("Amount Paid: %.2f%n", amountPaid);
        System.out.printf("Balance: %.2f%n", balance);
        System.out.println("===========================================");
        System.out.println("THANK YOU FOR YOUR PATRONAGE!");
    }

    static void printHeader(String cashierName, String customerName) {
        System.out.println("SEMICOLON STORES");
        System.out.println("MAIN BRANCH");
        System.out.println("LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS");
        System.out.println("TEL: 03293828343");
        System.out.println("Date: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yy hh:mm:ss a")));
        System.out.println("Cashier: " + cashierName);
        System.out.println("Customer Name: " + customerName);
        System.out.println("-------------------------------------------");
        System.out.printf("%-10s %-5s %-10s %-10s%n", "ITEM", "QTY", "PRICE", "TOTAL(NGN)");
    }

    static void printItems(List<Item> items) {
        for (Item item : items) {
            System.out.printf("%-10s %-5d %-10.2f %-10.2f%n",
                    item.name, item.quantity, item.price, item.getTotalOfPurchase());
        }
    }
}
