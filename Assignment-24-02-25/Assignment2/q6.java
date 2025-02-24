import java.lang.annotation.*;
import java.lang.reflect.AnnotatedElement;

// Define the custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
    String name();
}

// Apply the annotation to a class
@Author(name = "John Doe")
class Book {
    // Class content
}

public class ReflectionDemo {
    public static void main(String[] args) {
        Class<Book> bookClass = Book.class;

        // Retrieve and display annotation value
        if (bookClass.isAnnotationPresent(Author.class)) {
            Author author = bookClass.getAnnotation(Author.class);
            System.out.println("Author: " + author.name());
        } else {
            System.out.println("No Author annotation found.");
        }
    }
}
