import java.util.*;

public class ShoppingCart {
    public static void main(String[] args) {
        // Store product prices in HashMap
        Map productPrices = new HashMap();
        productPrices.put("Laptop", 800);
        productPrices.put("Phone", 500);
        productPrices.put("Tablet", 300);
        productPrices.put("Headphones", 100);

        // Maintain order of items added using LinkedHashMap
        Map cart = new LinkedHashMap();
        addToCart(cart, "Phone", productPrices);
        addToCart(cart, "Laptop", productPrices);
        addToCart(cart, "Headphones", productPrices);
        addToCart(cart, "Tablet", productPrices);

        System.out.println("Cart in order of addition: " + cart);

        // Display items sorted by price using TreeMap
        Map sortedCart = new TreeMap(new PriceComparator(cart));
        sortedCart.putAll(cart);
        System.out.println("Cart sorted by price: " + sortedCart);
    }

    public static void addToCart(Map cart, String product, Map prices) {
        if (prices.containsKey(product)) {
            cart.put(product, prices.get(product));
        }
    }
}

// Comparator to sort items by price
class PriceComparator implements Comparator {
    private Map baseMap;

    public PriceComparator(Map baseMap) {
        this.baseMap = baseMap;
    }

    public int compare(Object a, Object b) {
        return ((Integer) baseMap.get(a)).compareTo((Integer) baseMap.get(b));
    }
}
