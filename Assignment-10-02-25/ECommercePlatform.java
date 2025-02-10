
// Abstract class Product
abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {  // Controlled updates
        if (price > 0) {
            this.price = price;
        } else {
            System.out.println("Invalid price value!");
        }
    }

    public abstract double calculateDiscount(); // Abstract method for discount

    public double getFinalPrice() {  // Template method for final price calculation
        return price - calculateDiscount();
    }

    public void displayProductDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Discount: " + calculateDiscount());
    }
}

// Interface for taxable products
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Electronics class implementing Taxable
class Electronics extends Product implements Taxable {
    private static final double ELECTRONICS_TAX_RATE = 0.18; // 18% tax

    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * ELECTRONICS_TAX_RATE;
    }

    @Override
    public String getTaxDetails() {
        return "Electronics Tax: " + calculateTax();
    }
}

// Clothing class implementing Taxable
class Clothing extends Product implements Taxable {
    private static final double CLOTHING_TAX_RATE = 0.05; // 5% tax

    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.15; // 15% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * CLOTHING_TAX_RATE;
    }

    @Override
    public String getTaxDetails() {
        return "Clothing Tax: " + calculateTax();
    }
}

// Groceries class (No tax applied)
class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }
}

// Main class to demonstrate polymorphism
public class ECommercePlatform {
    public static void main(String[] args) {
        Product p1 = new Electronics(101, "Laptop", 50000);
        Product p2 = new Clothing(102, "T-Shirt", 2000);
        Product p3 = new Groceries(103, "Apples", 500);

        Product[] products = {p1, p2, p3};

        for (Product product : products) {
            product.displayProductDetails();
            double finalPrice = product.getFinalPrice();

            if (product instanceof Taxable) {
                Taxable taxableProduct = (Taxable) product;
                System.out.println(taxableProduct.getTaxDetails());
                finalPrice += taxableProduct.calculateTax();
            }

            System.out.println("Final Price (After Tax & Discount): " + finalPrice);
            System.out.println("---------------------------");
        }
    }
}

