// Base class: Animal
class Animal {
    // Method in the Animal class
    public void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

// Subclass: Dog
class Dog extends Animal {
    // Overriding the makeSound method from Animal class
    @Override
    public void makeSound() {
        System.out.println("Bark");
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating an object of Animal class
        Animal animal = new Animal();
        animal.makeSound(); // Calls the method from Animal class

        // Creating an object of Dog class
        Dog dog = new Dog();
        dog.makeSound(); // Calls the overridden method from Dog class
    }
}
