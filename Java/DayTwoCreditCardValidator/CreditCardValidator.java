import java.util.Scanner;

public class CreditCardValidator {

    public static String getCardType(String cardNumber) {
        if (cardNumber.startsWith("4")) {
            return "Visa";
        } else if (cardNumber.startsWith("5")) {
            return "MasterCard";
        } else if (cardNumber.startsWith("37")) {
            return "American Express";
        } else if (cardNumber.startsWith("6")) {
            return "Discover";
        } else {
            return "Unknown";
        }
    }

    public static int sumOfDoubleEvenPlace(String cardNumber) {
        int sum = 0;
        for (int position = cardNumber.length() - 2; position >= 0; position -= 2) {
            int digit = Character.getN umericValue(cardNumber.charAt(position));
            int doubledValue = digit * 2;
            sum += (doubledValue > 9) ? (doubledValue - 9) : doubledValue;
        }
        return sum;
    }

    public static int sumOfOddPlace(String cardNumber) {
        int sum = 0;
        for (int position = cardNumber.length() - 1; position >= 0; position -= 2) {
            int digit = Character.getNumericValue(cardNumber.charAt(position));
            sum += digit;
        }
        return sum;
    }

    public static boolean isValid(String cardNumber) {
        int evenSum = sumOfDoubleEvenPlace(cardNumber);
        int oddSum = sumOfOddPlace(cardNumber);
        int totalSum = evenSum + oddSum;
        return totalSum % 10 == 0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a credit card number: ");
        String cardNumber = input.nextLine();

        String cardType = getCardType(cardNumber);
        boolean valid = isValid(cardNumber);

        System.out.println("Card Type: " + cardType);
        if (valid) {
            System.out.println("Card Number " + cardNumber + " is VALID");
        } else {
            System.out.println("Card Number " + cardNumber + " is INVALID");
        }
   }
}
