import java.util.Scanner;

// Custom Exception Class
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message); // Pass the message to the superclass (Exception)
    }
}

public class CustomExceptionExample {

    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter their age
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        try {
            // Check if age is less than 18
            if (age < 18) {
                throw new InvalidAgeException("Age is less than 18. You are not allowed.");
            } else {
                System.out.println("You are allowed.");
            }
        } catch (InvalidAgeException e) {
            // Catch and handle the custom exception
            System.out.println("Exception: " + e.getMessage());
        } finally {
            // Close the scanner to avoid resource leak
            scanner.close();
        }
    }
}
