class Course {
    private String courseName;
    private int courseId;

    public Course(String courseName, int courseId) {
        this.courseName = courseName;
        this.courseId = courseId;
    }

    public void displayCourse() {
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Name: " + courseName);
    }
}

class Student {
    private String studentName;
    private int studentId;
    private Course course;   // composition with course

    public Student(String studentName, int studentId, Course course) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.course = course;
    }

    public void displayStudent() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Student Name: " + studentName);
        course.displayCourse();
    }
}

class Book {
    private String bookName;
    private String author;

    public Book(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
    }

    public void displayBook() {
        System.out.println("Book: " + bookName + " | Author: " + author);
    }
}

class Library {
    private Book[] books;   // composition

    public Library(Book[] books) {
        this.books = books;
    }

    public void showBooks() {
        System.out.println("\nLibrary Books:");
        for (Book b : books) {
            b.displayBook();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Course c1 = new Course("Java Programming", 101);
        Student s1 = new Student("Aasija", 1, c1);

        Book b1 = new Book("Java Basics", "James Gosling");
        Book b2 = new Book("OOP Concepts", "Bjarne");

        Book[] bookList = {b1, b2};
        Library lib = new Library(bookList);

        s1.displayStudent();
        lib.showBooks();
    }
}