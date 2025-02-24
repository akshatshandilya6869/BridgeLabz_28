import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class User {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }
}

class JsonSerializer {
    public static String serialize(Object obj) {
        try {
            Map<String, String> jsonMap = new HashMap<>();
            for (Field field : obj.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(JsonField.class)) {
                    String key = field.getAnnotation(JsonField.class).name();
                    String value = field.get(obj).toString();
                    jsonMap.put(key, value);
                }
            }
            return jsonMap.toString().replace("=", ": ");
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Serialization error", e);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        User user = new User("JohnDoe", 30);
        String json = JsonSerializer.serialize(user);
        System.out.println(json);
    }
}
