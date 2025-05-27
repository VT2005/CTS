import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Prompt user for a number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Step 2: Print multiplication table from 1 to 10
        System.out.println("Multiplication Table for " + number + ":");
        for (int i = 1; i <= 10; i++) {
            int product = number * i;
            System.out.println(number + " x " + i + " = " + product);
        }

        scanner.close();
    }
}
