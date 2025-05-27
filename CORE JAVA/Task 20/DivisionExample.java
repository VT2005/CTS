import java.util.Scanner;

public class DivisionExample {

    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user for two integers
        System.out.print("Enter the first integer: ");
        int num1 = scanner.nextInt();
        
        System.out.print("Enter the second integer: ");
        int num2 = scanner.nextInt();
        
        // Try-catch block to handle division by zero
        try {
            int result = num1 / num2;  // Attempt division
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            // Handle division by zero (or any other arithmetic exception)
            System.out.println("Error: Cannot divide by zero.");
        } finally {
            // Close the scanner to avoid resource leak
            scanner.close();
        }
    }
}
