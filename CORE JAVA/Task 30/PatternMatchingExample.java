public class PatternMatchingExample {

    public static void main(String[] args) {
        // Test the method with different object types
        printObjectType(42);        // Integer
        printObjectType("Hello");   // String
        printObjectType(3.14);      // Double
        printObjectType(true);      // Boolean
        printObjectType(new Object()); // Object
    }

    // Method to print the type of an object using pattern matching in a switch expression
    public static void printObjectType(Object obj) {
        // Use a switch expression with pattern matching
        switch (obj) {
            case Integer i -> System.out.println("Integer: " + i);
            case String s -> System.out.println("String: " + s);
            case Double d -> System.out.println("Double: " + d);
            case Boolean b -> System.out.println("Boolean: " + b);
            default -> System.out.println("Unknown type: " + obj.getClass().getName());
        }
    }
}
