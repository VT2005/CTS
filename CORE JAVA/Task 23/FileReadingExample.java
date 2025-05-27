import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadingExample {

    public static void main(String[] args) {
        // Absolute path of the file to read
        String filePath = "C:\\Users\\vaish\\OneDrive\\Desktop\\SOLUTIONS\\CORE JAVA\\Task 22\\output.txt";

        // Reading the file and displaying its contents
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read and display each line from the file
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Display the line on the console
            }

        } catch (IOException e) {
            // Handle any IOExceptions (e.g., file not found, cannot read)
            System.out.println("An error occurred while reading the file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
