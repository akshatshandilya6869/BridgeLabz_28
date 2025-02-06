import java.util.*;
// Product class
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// Order class (Aggregation - contains multiple Product objects)
class Order {
    private int orderId;
    private List<Product> products;
    private Customer customer;

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void showOrderDetails() {
        System.out.println("Order ID: " + orderId + " placed by " + customer.getName());
        System.out.println("Products:");
        for (Product product : products) {
            System.out.println("- " + product.getName() + " ($" + product.getPrice() + ")");
        }
    }
}

// Customer class
class Customer {
    private String name;
    private List<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public void showCustomerOrders() {
        System.out.println("Customer: " + name);
        for (Order order : orders) {
            order.showOrderDetails();
        }
    }
}

// Main class to demonstrate E-commerce platform
public class EcommercePlatform {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Alice");
        
        Product product1 = new Product("Laptop", 1200.50);
        Product product2 = new Product("Smartphone", 699.99);
        
        Order order1 = new Order(1, customer1);
        order1.addProduct(product1);
        order1.addProduct(product2);
        
        customer1.placeOrder(order1);
        
        customer1.showCustomerOrders();
    }
}
