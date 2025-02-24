import java.util.ArrayList;

public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList list = new ArrayList(); // No generics used
        list.add("Hello");
        list.add(42);

        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}
