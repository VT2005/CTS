public class MethodOverloading {

    // Method that adds two integers
    public static int add(int a, int b) {
        return a + b;
    }

    // Method that adds two doubles
    public static double add(double a, double b) {
        return a + b;
    }

    // Method that adds three integers
    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        // Calling the add method with two integers
        int sumInt = add(5, 10);
        System.out.println("Sum of two integers: " + sumInt);

        // Calling the add method with two doubles
        double sumDouble = add(5.5, 10.3);
        System.out.println("Sum of two doubles: " + sumDouble);

        // Calling the add method with three integers
        int sumThreeInts = add(3, 6, 9);
        System.out.println("Sum of three integers: " + sumThreeInts);
    }
}
