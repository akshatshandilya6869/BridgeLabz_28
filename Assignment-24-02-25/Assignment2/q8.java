import java.lang.reflect.Field;
import java.util.Map;

class ObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            T instance = clazz.getDeclaredConstructor().newInstance();

            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                Field field;
                try {
                    field = clazz.getDeclaredField(entry.getKey());
                    field.setAccessible(true);
                    field.set(instance, entry.getValue());
                } catch (NoSuchFieldException ignored) {
                    // Skip unknown properties
                }
            }
            return instance;
        } catch (Exception e) {
            throw new RuntimeException("Error creating object", e);
        }
    }
}

// Sample class to test
class User {
    private String name;
    private int age;

    public void display() {
        System.out.println("User{name='" + name + "', age=" + age + "}");
    }
}

public class ReflectionDemo {
    public static void main(String[] args) {
        Map<String, Object> properties = Map.of(
            "name", "Alice",
            "age", 25
        );

        User user = ObjectMapper.toObject(User.class, properties);
        user.display();
    }
}
