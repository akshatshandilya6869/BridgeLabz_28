
// Abstract class representing a food item
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract double calculateTotalPrice(); // Abstract method

    public String getItemDetails() {
        return "Item: " + itemName + ", Price: $" + price + ", Quantity: " + quantity;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

// Interface for applying discounts
interface Discountable {
    double applyDiscount(double percentage);
    String getDiscountDetails();
}

// VegItem subclass
class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount(double percentage) {
        return calculateTotalPrice() * (1 - percentage / 100);
    }

    @Override
    public String getDiscountDetails() {
        return "Discount available on Veg Items!";
    }
}

// NonVegItem subclass
class NonVegItem extends FoodItem implements Discountable {
    private static final double NON_VEG_SURCHARGE = 1.10; // 10% extra charge

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity() * NON_VEG_SURCHARGE;
    }

    @Override
    public double applyDiscount(double percentage) {
        return calculateTotalPrice() * (1 - percentage / 100);
    }

    @Override
    public String getDiscountDetails() {
        return "Non-Veg items have a 10% surcharge.";
    }
}

// Order Processing Class
public class FoodDeliverySystem {
    public static void processOrder(FoodItem item) {
        System.out.println(item.getItemDetails());
        System.out.println("Total Price: $" + item.calculateTotalPrice());
        if (item instanceof Discountable) {
            Discountable discountItem = (Discountable) item;
            System.out.println(discountItem.getDiscountDetails());
            System.out.println("Price after 10% discount: $" + discountItem.applyDiscount(10));
        }
        System.out.println("----------------------");
    }

    public static void main(String[] args) {
        FoodItem vegBurger = new VegItem("Veg Burger", 5.00, 2);
        FoodItem chickenPizza = new NonVegItem("Chicken Pizza", 10.00, 1);

        processOrder(vegBurger);
        processOrder(chickenPizza);
    }
}

