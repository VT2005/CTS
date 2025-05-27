// Define the Playable interface
interface Playable {
    void play();  // Abstract method to be implemented by classes
}

// Guitar class implementing Playable interface
class Guitar implements Playable {
    @Override
    public void play() {
        System.out.println("Playing the guitar: Strum strum!");
    }
}

// Piano class implementing Playable interface
class Piano implements Playable {
    @Override
    public void play() {
        System.out.println("Playing the piano: Plink plink!");
    }
}

public class Main {
    public static void main(String[] args) {
        // Create objects of Guitar and Piano
        Playable guitar = new Guitar();
        Playable piano = new Piano();

        // Call the play method for both objects
        guitar.play();  // Calls the play method from Guitar class
        piano.play();   // Calls the play method from Piano class
    }
}
