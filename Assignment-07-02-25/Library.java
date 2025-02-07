class Book {
    String title;
    int publicationYear;
    
    Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }
    
    void displayInfo() {
        System.out.println("Title: " + title + ", Year: " + publicationYear);
    }
}

class Author extends Book {
    String name;
    String bio;
    
    Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }
    
    
    void displayInfo() {
        super.displayInfo();
        System.out.println("Author: " + name + ", Bio: " + bio);
    }
}

public class Main {
    public static void main(String[] args) {
        // Animal Hierarchy
        Animal dog = new Dog("Buddy", 5);
        Animal cat = new Cat("Whiskers", 3);
        Animal bird = new Bird("Tweety", 2);
        dog.makeSound();
        cat.makeSound();
        bird.makeSound();
        
        // Employee Management
        Manager manager = new Manager("Alice", 101, 90000, 5);
        Developer developer = new Developer("Bob", 102, 80000, "Java");
        Intern intern = new Intern("Charlie", 103, 30000, "6 months");
        manager.displayDetails();
        developer.displayDetails();
        intern.displayDetails();
        
        // Vehicle System
        Vehicle car = new Car(200, "Petrol", 5);
        Vehicle truck = new Truck(150, "Diesel", 10);
        Vehicle motorcycle = new Motorcycle(180, "Petrol", false);
        car.displayInfo();
        truck.displayInfo();
        motorcycle.displayInfo();
        
        // Library Management
        Author author = new Author("Java Programming", 2021, "John Doe", "Expert in Java");
        author.displayInfo();
    }
}