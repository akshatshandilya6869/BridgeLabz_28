import java.lang.reflect.Field;

class JsonSerializer {
    public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder("{");

        Field[] fields = obj.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            try {
                json.append("\"").append(fields[i].getName()).append("\": ")
                    .append(formatValue(fields[i].get(obj)));

                if (i < fields.length - 1) {
                    json.append(", ");
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Error accessing field", e);
            }
        }

        json.append("}");
        return json.toString();
    }

    private static String formatValue(Object value) {
        if (value instanceof String) {
            return "\"" + value + "\"";
        }
        return String.valueOf(value);
    }
}

// Sample class to test
class User {
    private String name;
    private int age;
    private boolean active;

    public User(String name, int age, boolean active) {
        this.name = name;
        this.age = age;
        this.active = active;
    }
}

public class ReflectionDemo {
    public static void main(String[] args) {
        User user = new User("Alice", 25, true);
        String json = JsonSerializer.toJson(user);
        System.out.println(json);
    }
}
