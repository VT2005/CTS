import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample {

    public static void main(String[] args) {
        // Create an ArrayList to store student names
        ArrayList<String> studentNames = new ArrayList<>();

        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Allow the user to enter names until they type "exit"
        while (true) {
            System.out.print("Enter a student name (or type 'exit' to stop): ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("exit")) {
                break; // Exit the loop if the user types "exit"
            }

            // Add the name to the ArrayList
            studentNames.add(name);
        }

        // Display all names entered
        System.out.println("\nList of student names entered:");
        for (String name : studentNames) {
            System.out.println(name);
        }

        // Close the scanner to avoid resource leak
        scanner.close();
    }
}
