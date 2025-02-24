
// Parent class
class Animal {
    void makeSound() {  // Method to be overridden
        System.out.println("Animal makes a sound");
    }
}

// Child class overriding the method
class Dog extends Animal {
    @Override
    void makeSound() {  // Overriding method
        System.out.println("Dog barks");
    }
}

// Main class
public class OverrideExample {
    public static void main(String[] args) {
        Animal myDog = new Dog();  // Polymorphism
        myDog.makeSound();  // Calls the overridden method in Dog
    }
}

