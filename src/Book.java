import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Book {
    String title;
    String author;
    String isbn;
    public Book(String title, String author, String isbn){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
}

class Library{
    List<Book> books ;
    Library(){
        books = new ArrayList<>();
    }
    public void addBooks(Book book){
        books.add(book);
    }
    public void removeBooks(Book book){
        books.remove(book);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        int i = 0;
        do {
            System.out.print("Enter Book Title : " );
            String t = sc.next();
            System.out.print("Enter Book Author : " );
            String a = sc.next();
            System.out.print("Enter Book ISBN : ");
            String ist = sc.next();
            System.out.print("If you want to add Books press 'yes' otherwise 'no' : ");
            String y = sc.next();
            Book boo = new Book(t,a,ist);
            library.addBooks(boo);
            if (y.equals("yes")){
                i++;
            }else {
                break;
            }
        }while (i > 0);

        System.out.println("------------------ All Books -------------------");
        for (Book b : library.books){
            System.out.println("Title : "+b.title+ ", Author : "+b.author+ ", ISBN : "+ b.isbn);
        }

        System.out.print("Do you want to remove any book press Enter 'yes' Or 'no' : ");
        String ye = sc.next();
        if (ye.equals("yes")){
            System.out.print("Enter Book title Name : ");
            String rem = sc.next();
            for (Book b : library.books){
                if (b.title.equals(rem)){
                    library.removeBooks(b);
                }
            }

            System.out.println("------------------After Removing All Books -------------------");

            for (Book b : library.books){
                System.out.println("Title : "+b.title+ ", Author : "+b.author+ ", ISBN : "+ b.isbn);
            }
        }
    }
}