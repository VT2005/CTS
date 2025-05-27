import java.util.*;

public class LambdaExpressionExample {

    public static void main(String[] args) {
        // Create a list of strings
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Charlie", "David");

        // Sort the list using a lambda expression
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));

        // Display the sorted list
        System.out.println("Sorted List: " + names);
    }
}
