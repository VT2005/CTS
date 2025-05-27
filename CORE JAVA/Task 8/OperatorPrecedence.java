public class OperatorPrecedence {
    public static void main(String[] args) {
        // Expression without parentheses
        int result1 = 10 + 5 * 2; // 5 * 2 = 10, then 10 + 10 = 20
        System.out.println("Result1 (10 + 5 * 2): " + result1);

        // Expression with parentheses
        int result2 = (10 + 5) * 2; // 10 + 5 = 15, then 15 * 2 = 30
        System.out.println("Result2 ((10 + 5) * 2): " + result2);

        // More complex expression
        int result3 = 100 / 5 + 3 * 4 - 6; // 100/5 = 20, 3*4 = 12, 20 + 12 - 6 = 26
        System.out.println("Result3 (100 / 5 + 3 * 4 - 6): " + result3);

        // With parentheses for custom precedence
        int result4 = 100 / (5 + 3) * (4 - 2); // 5+3=8, 100/8=12, 4-2=2, 12*2=24
        System.out.println("Result4 (100 / (5 + 3) * (4 - 2)): " + result4);
    }
}
