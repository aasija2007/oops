class Book {
    protected String title;
    protected String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void display() {
        System.out.println("Book: " + title);
        System.out.println("Author: " + author);
    }
}

// Inheritance
class EBook extends Book {
    private double fileSize;

    public EBook(String title, String author, double fileSize) {
        super(title, author);
        this.fileSize = fileSize;
    }

    // Method Overriding
    @Override
    public void display() {
        System.out.println("E-Book: " + title);
        System.out.println("Author: " + author);
        System.out.println("File Size: " + fileSize + " MB");
    }
}

// Composition
class Library {
    private Book[] books;

    public Library(Book[] books) {
        this.books = books;
    }

    // Polymorphism
    public void showBooks() {
        System.out.println("Library Collection:");
        for (Book b : books) {
            b.display();   // runtime polymorphism
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Book b1 = new Book("Java Basics", "James");
        Book b2 = new EBook("Advanced Java", "Oracle", 5.6);

        Book[] list = {b1, b2};

        Library lib = new Library(list);
        lib.showBooks();
    }
}