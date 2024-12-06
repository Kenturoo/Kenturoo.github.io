import java.util.Scanner;

public class NumberSystemConverter {

    // Method to convert a decimal number to another base (2-16)
    public static String convertFromDecimal(int decimal, int baseTo) {
        String digits = "0123456789ABCDEF";
        StringBuilder result = new StringBuilder();

        // Special case for base 10
        if (baseTo == 10) {
            return Integer.toString(decimal);
        }

        // Convert decimal to the specified base
        while (decimal > 0) {
            int remainder = decimal % baseTo;
            result.insert(0, digits.charAt(remainder));
            decimal /= baseTo;
        }

        return result.length() > 0 ? result.toString() : "0";
    }

    // Method to convert the input number from the original base to decimal
    public static double convertToDecimal(String number, int baseFrom) {
        String[] parts = number.split("\\.");
        int wholePart = Integer.parseInt(parts[0], baseFrom);
        double fractionalPart = 0.0;

        // Handle fractional part if it exists
        if (parts.length > 1) {
            String fraction = parts[1];
            for (int i = 0; i < fraction.length(); i++) {
                int digitValue = Character.digit(fraction.charAt(i), baseFrom);
                fractionalPart += digitValue / Math.pow(baseFrom, i + 1);
            }
        }

        return wholePart + fractionalPart;
    }

    // Method to convert the fractional part from decimal to another base
    public static String convertFractionalPart(double fractionalPart, int baseTo, int precision) {
        StringBuilder fractionalResult = new StringBuilder();
        String digits = "0123456789ABCDEF";

        while (fractionalPart > 0 && precision > 0) {
            fractionalPart *= baseTo;
            int integerPart = (int) fractionalPart;
            fractionalResult.append(digits.charAt(integerPart));
            fractionalPart -= integerPart;
            precision--;  // To avoid infinite loops
        }

        return fractionalResult.length() > 0 ? fractionalResult.toString() : "0";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Number System Converter (Base 2 to 16)");

        while (true) {
            System.out.print("\nEnter the base of the original number (2-16), or type 'STOP' to exit: ");
            String baseInput = scanner.nextLine();

            if (baseInput.equalsIgnoreCase("STOP")) {
                System.out.println("Exiting the program.");
                break;
            }

            int baseFrom;
            try {
                baseFrom = Integer.parseInt(baseInput);
                if (baseFrom < 2 || baseFrom > 16) {
                    System.out.println("Please enter a valid base between 2 and 16.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number or 'STOP'.");
                continue;
            }

            // Asking for the number in the specified base
            System.out.print("Enter the number in base " + baseFrom + ": ");
            String number = scanner.nextLine();

            try {
                // Convert the number to decimal
                double decimalNumber = convertToDecimal(number, baseFrom);

                // Display conversions to all bases (2-16)
                System.out.println("\nConversions:");
                for (int baseTo = 2; baseTo <= 16; baseTo++) {
                    String wholePart = convertFromDecimal((int) decimalNumber, baseTo);
                    String fractionalPart = convertFractionalPart(decimalNumber - (int) decimalNumber, baseTo, 5);
                    System.out.println("Base " + baseTo + ": " + wholePart + (fractionalPart.isEmpty() ? "" : "." + fractionalPart));
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number for the given base.");
            }
        }

        scanner.close();
    }
}
