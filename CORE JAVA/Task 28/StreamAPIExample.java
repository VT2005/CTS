import java.util.*;
import java.util.stream.*;

public class StreamAPIExample {

    public static void main(String[] args) {
        // Create a List of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Use Stream API to filter even numbers
        List<Integer> evenNumbers = numbers.stream()
                                           .filter(n -> n % 2 == 0)  // Filter even numbers
                                           .collect(Collectors.toList());  // Collect the result into a list

        // Display the result
        System.out.println("Even Numbers: " + evenNumbers);
    }
}
