import java.lang.reflect.Constructor;

class Student {
    private String name;

    public Student() {
        this.name = "Default Student";
    }

    public Student(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Student Name: " + name);
    }
}

public class ReflectionDemo {
    public static void main(String[] args) {
        try {
            // Get the Class object
            Class<?> studentClass = Class.forName("Student");

            // Create an instance using the default constructor
            Object student1 = studentClass.getDeclaredConstructor().newInstance();
            ((Student) student1).display();

            // Create an instance using the parameterized constructor
            Constructor<?> constructor = studentClass.getDeclaredConstructor(String.class);
            Object student2 = constructor.newInstance("John Doe");
            ((Student) student2).display();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
