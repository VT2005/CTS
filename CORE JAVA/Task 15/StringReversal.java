import java.util.Scanner;

public class StringReversal {

    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user to enter a string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Reverse the string using StringBuilder
        StringBuilder reversedString = new StringBuilder(input);
        reversedString.reverse();

        // Display the reversed string
        System.out.println("Reversed string: " + reversedString.toString());

        // Close the scanner to avoid resource leak
        scanner.close();
    }
}
