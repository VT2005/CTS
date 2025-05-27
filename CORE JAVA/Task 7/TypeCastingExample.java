public class TypeCastingExample {
    public static void main(String[] args) {
        // Step 1: Convert double to int (explicit/narrowing)
        double decimalValue = 9.75;
        int intValue = (int) decimalValue;  // Manual casting
        System.out.println("Original double: " + decimalValue);
        System.out.println("After casting to int: " + intValue);

        // Step 2: Convert int to double (implicit/widening)
        int number = 25;
        double convertedDouble = number;  // Automatically cast
        System.out.println("Original int: " + number);
        System.out.println("After casting to double: " + convertedDouble);
    }
}
