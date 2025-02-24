import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// Define an interface
interface Greeting {
    void sayHello(String name);
}

// Implement the interface
class GreetingImpl implements Greeting {
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }
}

// Create a dynamic proxy handler
class LoggingProxyHandler implements InvocationHandler {
    private final Object target;

    public LoggingProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Executing method: " + method.getName());
        return method.invoke(target, args);
    }
}

public class ProxyDemo {
    public static void main(String[] args) {
        // Create an instance of the target class
        Greeting greeting = new GreetingImpl();

        // Create a proxy instance
        Greeting proxyInstance = (Greeting) Proxy.newProxyInstance(
            Greeting.class.getClassLoader(),
            new Class[]{Greeting.class},
            new LoggingProxyHandler(greeting)
        );

        // Call method on proxy
        proxyInstance.sayHello("Alice");
    }
}
