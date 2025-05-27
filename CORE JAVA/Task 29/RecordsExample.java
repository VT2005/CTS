import java.util.*;
import java.util.stream.*;

public class RecordsExample {

    // Define a record named Person
    public record Person(String name, int age) { }

    public static void main(String[] args) {
        // Create instances of the Person record
        Person p1 = new Person("John", 25);
        Person p2 = new Person("Alice", 30);
        Person p3 = new Person("Bob", 20);
        Person p4 = new Person("Charlie", 35);

        // Create a List of Person records
        List<Person> people = Arrays.asList(p1, p2, p3, p4);

        // Filter persons based on age (e.g., age >= 30) using Streams
        List<Person> adults = people.stream()
                                    .filter(p -> p.age() >= 30)  // Filter by age
                                    .collect(Collectors.toList());  // Collect results into a list

        // Display the result
        System.out.println("People aged 30 or older:");
        adults.forEach(person -> System.out.println(person.name() + " - " + person.age()));
    }
}
