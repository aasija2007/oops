
import java.util.*;

class  Main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of books");
        int n = sc.nextInt();
        sc.nextLine();

        
        LibraryManagement l[] = new LibraryManagement[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the book " + (i + 1) + " detail ");
            String input = sc.nextLine();
            String arr[] = input.split(",");

            int a = Integer.parseInt(arr[0]);
            String b = arr[1];
            String c = arr[2];
            String d = arr[3];
            int e = Integer.parseInt(arr[4]);
            String f = arr[5];

            l[i] = new LibraryManagement(a, b, c, d, e, f);
        }

        System.out.println("Books Details");
        for (int i = 0; i < n; i++) {
            l[i].display();
        }
    }
}

class LibraryManagement {

    int bookid;
    String title;
    String authorname;
    String publishername;
    int price;
    String language;

    LibraryManagement(int a, String b, String c, String d, int e, String f) {
        this.bookid = a;
        this.title = b;
        this.authorname = c;
        this.publishername = d;
        this.price = e;
        this.language = f;
    }

    void display() {
        System.out.println("Bookid: " + bookid);
        System.out.println("Title: " + title);
        System.out.println("AuthorName: " + authorname);
        System.out.println("PublisherName: " + publishername);
        System.out.println("Price: " + price);
        System.out.println("Language: " + language);
        
    }
}
