import java.util.Scanner;

public class RecursiveFibonacci {

    // Recursive method to calculate the nth Fibonacci number
    public static int fibonacci(int n) {
        // Base case: Fibonacci of 0 is 0, Fibonacci of 1 is 1
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2); // Recursive call
        }
    }

    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user for input
        System.out.print("Enter a positive integer n: ");
        int n = scanner.nextInt();

        // Validate the input to ensure it's a positive integer
        if (n < 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            // Call the fibonacci method and display the result
            int result = fibonacci(n);
            System.out.println("The " + n + "th Fibonacci number is: " + result);
        }

        // Close the scanner to avoid resource leak
        scanner.close();
    }
}
