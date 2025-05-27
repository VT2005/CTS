import java.util.HashMap;
import java.util.Scanner;

public class HashMapExample {

    public static void main(String[] args) {
        // Create a HashMap to store student ID (Integer) and name (String)
        HashMap<Integer, String> studentMap = new HashMap<>();

        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Allow the user to add student ID and name pairs
        while (true) {
            System.out.print("Enter student ID (or type 'exit' to stop): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break; // Exit the loop if the user types "exit"
            }

            try {
                // Convert the input to an integer for the student ID
                int studentId = Integer.parseInt(input);

                // Prompt for the student's name
                System.out.print("Enter student name: ");
                String studentName = scanner.nextLine();

                // Add the student ID and name to the HashMap
                studentMap.put(studentId, studentName);

            } catch (NumberFormatException e) {
                System.out.println("Invalid ID. Please enter a valid integer for student ID.");
            }
        }

        // Display all student IDs and names
        System.out.println("\nStudent ID to Name Mapping:");
        for (Integer id : studentMap.keySet()) {
            System.out.println("ID: " + id + " - Name: " + studentMap.get(id));
        }

        // Retrieve a student's name based on their ID
        System.out.print("\nEnter a student ID to retrieve the name: ");
        int searchId = scanner.nextInt();
        if (studentMap.containsKey(searchId)) {
            System.out.println("Student Name: " + studentMap.get(searchId));
        } else {
            System.out.println("No student found with ID " + searchId);
        }

        // Close the scanner to avoid resource leak
        scanner.close();
    }
}
