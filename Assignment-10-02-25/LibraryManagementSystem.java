
// Abstract class representing a general Library Item
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public abstract int getLoanDuration(); // Abstract method to be overridden

    public String getItemDetails() {
        return "ID: " + itemId + ", Title: " + title + ", Author: " + author;
    }
}

// Interface for reservable items
interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

// Book subclass
class Book extends LibraryItem implements Reservable {
    private boolean isReserved;

    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
        this.isReserved = false;
    }

    @Override
    public int getLoanDuration() {
        return 14; // Books can be loaned for 14 days
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (!isReserved) {
            isReserved = true;
            System.out.println(borrowerName + " reserved the book: " + getItemDetails());
        } else {
            System.out.println("Book is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return !isReserved;
    }
}

// Magazine subclass
class Magazine extends LibraryItem {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // Magazines can be loaned for 7 days
    }
}

// DVD subclass
class DVD extends LibraryItem implements Reservable {
    private boolean isReserved;

    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
        this.isReserved = false;
    }

    @Override
    public int getLoanDuration() {
        return 5; // DVDs can be loaned for 5 days
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (!isReserved) {
            isReserved = true;
            System.out.println(borrowerName + " reserved the DVD: " + getItemDetails());
        } else {
            System.out.println("DVD is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return !isReserved;
    }
}

// Main class for testing
public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryItem book = new Book("B001", "Java Programming", "John Doe");
        LibraryItem magazine = new Magazine("M001", "Tech Monthly", "Jane Smith");
        LibraryItem dvd = new DVD("D001", "Inception", "Christopher Nolan");

        System.out.println(book.getItemDetails() + ", Loan Duration: " + book.getLoanDuration() + " days");
        System.out.println(magazine.getItemDetails() + ", Loan Duration: " + magazine.getLoanDuration() + " days");
        System.out.println(dvd.getItemDetails() + ", Loan Duration: " + dvd.getLoanDuration() + " days");

        Reservable reservableBook = (Reservable) book;
        reservableBook.reserveItem("Alice");
        System.out.println("Book available: " + reservableBook.checkAvailability());

        Reservable reservableDVD = (Reservable) dvd;
        reservableDVD.reserveItem("Bob");
        System.out.println("DVD available: " + reservableDVD.checkAvailability());
    }
}

