import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class UserService {
    @RoleAllowed("ADMIN")
    public void deleteUser() {
        System.out.println("User deleted successfully!");
    }
}

class SecurityManager {
    private final String currentUserRole;

    public SecurityManager(String currentUserRole) {
        this.currentUserRole = currentUserRole;
    }

    public void invokeMethod(Object obj, String methodName) {
        try {
            Method method = obj.getClass().getMethod(methodName);

            if (method.isAnnotationPresent(RoleAllowed.class)) {
                String requiredRole = method.getAnnotation(RoleAllowed.class).value();

                if (!currentUserRole.equals(requiredRole)) {
                    System.out.println("Access Denied!");
                    return;
                }
            }

            method.invoke(obj);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        UserService service = new UserService();
        
        SecurityManager adminUser = new SecurityManager("ADMIN");
        adminUser.invokeMethod(service, "deleteUser"); // Allowed

        SecurityManager normalUser = new SecurityManager("USER");
        normalUser.invokeMethod(service, "deleteUser"); // Access Denied
    }
}
