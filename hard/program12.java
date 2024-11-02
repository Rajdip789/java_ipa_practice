import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

class Book {
    int id;
    String title;
    String author;
    double price;
    
    public Book(int id, String title, String author, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }
    
    int getId() {
        return this.id;
    }
    
    String getTitle() {
        return this.title;
    }
    
    String getAuthor() {
        return this.author;
    }
    
    double getPrice() {
        return this.price;
    }
}

public class program12 {
    static Book[] sortBooksByPrice(Book[] books) {
        Arrays.sort(books, new Comparator<Book>() {
            public int compare(Book b1, Book b2) {
                return Double.compare(b1.getPrice(), b2.getPrice());
            }
        });
        
        return books;
    }
    
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        Book[] books = new Book[4];
        
        for(int i = 0; i < books.length; i++) {
            int id = sc.nextInt();
            sc.nextLine();
            String title = sc.nextLine();
            String author = sc.nextLine();
            double price = sc.nextDouble();
            
            books[i] = new Book(id, title, author, price);
        }
        
        Book[] res = sortBooksByPrice(books);
        
        for(Book b : res) {
            System.out.println(b.getId() + " " + b.getTitle() + " "+ b.getAuthor() + " " + b.getPrice());
        }
    }
}

/*

--- input ---
1
hello
writer1
50
2
cup
writer2
55
3
Planet
writer3
45
4
India
writer4
40

--- ouput ---
4 India writer4 40.0
3 Planet writer3 45.0
1 hello writer1 50.0
2 cup writer2 55.0

*/