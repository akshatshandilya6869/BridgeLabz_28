class Vehicle {
    int maxSpeed;
    String fuelType;
    
    Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }
    
    void displayInfo() {
        System.out.println("Vehicle Max Speed: " + maxSpeed + ", Fuel Type: " + fuelType);
    }
}

class Car extends Vehicle {
    int seatCapacity;
    
    Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }
    
    
    void displayInfo() {
        super.displayInfo();
        System.out.println("Seat Capacity: " + seatCapacity);
    }
}

class Truck extends Vehicle {
    int loadCapacity;
    
    Truck(int maxSpeed, String fuelType, int loadCapacity) {
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }
    
   
    void displayInfo() {
        super.displayInfo();
        System.out.println("Load Capacity: " + loadCapacity + " tons");
    }
}

class Motorcycle extends Vehicle {
    boolean hasSidecar;
    
    Motorcycle(int maxSpeed, String fuelType, boolean hasSidecar) {
        super(maxSpeed, fuelType);
        this.hasSidecar = hasSidecar;
    }
    
    
    void displayInfo() {
        super.displayInfo();
        System.out.println("Has Sidecar: " + hasSidecar);
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
    }
}