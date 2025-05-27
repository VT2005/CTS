import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWritingExample {

    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a string
        System.out.print("Enter a string to write to the file: ");
        String userInput = scanner.nextLine();

        // Writing the string to the file
        try (FileWriter writer = new FileWriter("output.txt")) {
            writer.write(userInput); // Write user input to file
            System.out.println("Data has been written to output.txt.");
        } catch (IOException e) {
            // Handle potential IOExceptions
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        } finally {
            // Close the scanner to avoid resource leak
            scanner.close();
        }
    }
}
