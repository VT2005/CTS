import java.util.Scanner;

public class ArraySumAndAverage {

    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user to enter the number of elements
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        // Create an array to hold the elements
        int[] numbers = new int[n];
        
        // Read the elements into the array
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        // Calculate the sum of the elements
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }

        // Calculate the average
        double average = sum / (double) n;

        // Display the sum and average
        System.out.println("Sum of elements: " + sum);
        System.out.println("Average of elements: " + average);

        // Close the scanner to avoid resource leak
        scanner.close();
    }
}
