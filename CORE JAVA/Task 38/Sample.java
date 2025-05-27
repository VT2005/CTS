public class Sample {
    private int number;

    public Sample(int number) {
        this.number = number;
    }

    public void display() {
        System.out.println("Number is: " + number);
    }

    public int square() {
        return number * number;
    }

    public static void main(String[] args) {
        Sample obj = new Sample(5);
        obj.display();
        System.out.println("Square: " + obj.square());
    }
}
