import java.util.Scanner;

public class FactorialCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Get input
        System.out.print("Enter a non-negative integer: ");
        int number = scanner.nextInt();

        // Step 2: Validate input
        if (number < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            long factorial = 1; // Use long to support large numbers

            // Step 3: Calculate factorial using for loop
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }

            // Step 4: Display result
            System.out.println("Factorial of " + number + " is: " + factorial);
        }

        scanner.close();
    }
}
