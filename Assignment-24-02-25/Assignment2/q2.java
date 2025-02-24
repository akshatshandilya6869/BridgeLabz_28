import java.lang.reflect.Field;

class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public void displayAge() {
        System.out.println("Age: " + age);
    }
}

public class ReflectionDemo {
    public static void main(String[] args) {
        try {
            Person person = new Person(25);
            person.displayAge();

            Field ageField = Person.class.getDeclaredField("age");
            ageField.setAccessible(true); // Allow access to private field

            System.out.println("\nModifying age using reflection...");
            ageField.set(person, 30); // Modify private field

            person.displayAge(); // Verify modification
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
