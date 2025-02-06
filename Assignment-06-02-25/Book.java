import java.util.*;

// Book class
class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}

// Library class
class Library {
    private String name;
    private List<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void showBooks() {
        System.out.println("Books in " + name + ":");
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor());
        }
    }
}

// Main class to test the implementation
public class LibrarySystem {
    public static void main(String[] args) {
        Library library1 = new Library("City Library");
        Library library2 = new Library("University Library");

        Book book1 = new Book("The Catcher in the Rye", "J.D. Salinger");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book book3 = new Book("1984", "George Orwell");

        library1.addBook(book1);
        library1.addBook(book2);
        library2.addBook(book3);

        library1.showBooks();
        library2.showBooks();
    }
}
