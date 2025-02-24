import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "DEFAULT_KEY";

    public static void printApiKey() {
        System.out.println("API_KEY: " + API_KEY);
    }
}

public class ReflectionDemo {
    public static void main(String[] args) {
        try {
            Class<Configuration> configClass = Configuration.class;

            Field apiKeyField = configClass.getDeclaredField("API_KEY");
            apiKeyField.setAccessible(true); // Allow access to private field

            System.out.println("Before Modification:");
            Configuration.printApiKey();

            // Modify static field value
            apiKeyField.set(null, "NEW_SECRET_KEY");

            System.out.println("\nAfter Modification:");
            Configuration.printApiKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
