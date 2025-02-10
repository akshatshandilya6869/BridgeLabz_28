
// Abstract class representing a vehicle
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public abstract double calculateFare(double distance); // Abstract method

    public String getVehicleDetails() {
        return "Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate: $" + ratePerKm + " per km";
    }

    public double getRatePerKm() {
        return ratePerKm;
    }
}

// Interface for GPS functionality
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Car subclass
class Car extends Vehicle implements GPS {
    private String location;

    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Unknown";
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    @Override
    public String getCurrentLocation() {
        return "Car is at " + location;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}

// Bike subclass
class Bike extends Vehicle implements GPS {
    private String location;

    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Unknown";
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() * 0.9; // 10% discount for bikes
    }

    @Override
    public String getCurrentLocation() {
        return "Bike is at " + location;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}

// Auto subclass
class Auto extends Vehicle implements GPS {
    private String location;

    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Unknown";
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 5; // $5 base charge for autos
    }

    @Override
    public String getCurrentLocation() {
        return "Auto is at " + location;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}

// Ride Booking System
public class RideHailingApp {
    public static void bookRide(Vehicle vehicle, double distance) {
        System.out.println(vehicle.getVehicleDetails());
        System.out.println("Fare for " + distance + " km: $" + vehicle.calculateFare(distance));

        if (vehicle instanceof GPS) {
            GPS gpsVehicle = (GPS) vehicle;
            gpsVehicle.updateLocation("Downtown");
            System.out.println(gpsVehicle.getCurrentLocation());
        }

        System.out.println("----------------------");
    }

    public static void main(String[] args) {
        Vehicle car = new Car("C001", "John Doe", 2.50);
        Vehicle bike = new Bike("B001", "Alice Smith", 1.50);
        Vehicle auto = new Auto("A001", "Bob Brown", 2.00);

        bookRide(car, 10);
        bookRide(bike, 10);
        bookRide(auto, 10);
    }
}

