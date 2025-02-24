import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {}
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

class DIContainer {
    private final Map<Class<?>, Object> instances = new HashMap<>();

    public void register(Class<?> clazz) {
        try {
            Object instance = clazz.getDeclaredConstructor().newInstance();
            instances.put(clazz, instance);
        } catch (Exception e) {
            throw new RuntimeException("Failed to register class: " + clazz.getName(), e);
        }
    }

    public void injectDependencies(Object object) {
        Class<?> clazz = object.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                Class<?> fieldType = field.getType();
                Object dependency = instances.get(fieldType);
                if (dependency == null) {
                    throw new RuntimeException("No registered instance for " + fieldType.getName());
                }
                field.setAccessible(true);
                try {
                    field.set(object, dependency);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Failed to inject dependency: " + fieldType.getName(), e);
                }
            }
        }
    }
}
class Service {
    public void serve() {
        System.out.println("Service is running...");
    }
}

class Client {
    @Inject
    private Service service;

    public void doWork() {
        service.serve();
        System.out.println("Client is working...");
    }
}
public class DIContainerDemo {
    public static void main(String[] args) {
        DIContainer container = new DIContainer();

        // Register dependencies
        container.register(Service.class);

        // Create client object and inject dependencies
        Client client = new Client();
        container.injectDependencies(client);

        // Use the client with injected dependencies
        client.doWork();
    }
}
