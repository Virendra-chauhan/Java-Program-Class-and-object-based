package library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Write a java program to create a class called "Library" with a collection of books and methods to add and remove books.


class Book{
  private int bookId;
  private String bookName;
  private String bookAuthor;

  public Book(int bookId, String bookName, String bookAuthor){
      this.bookId = bookId;
      this.bookName = bookName;
      this.bookAuthor = bookAuthor;
  }

  public int getBookId(){
      return this.bookId;
  }
  public String getBookName(){
      return this.bookName;
  }
  public String getBookAuthor(){
      return this.bookAuthor;
  }
}
public class Library {
    private List<Book> books;

    public Library(){
        books = new ArrayList<>();
    }

    public void addBooks(Book b){
        books.add(b);

    }
    public void removeBooks(int id){
        books.removeIf(book -> book.getBookId() == id);
        System.out.println("removed....");
    }
    public void showBooks(){
        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("| %-10s | %-33s | %-5s %n","Book Id", "Book Name", "Book Author");
        System.out.println("-----------------------------------------------------------------------");

        for (Book b : books){
            System.out.printf("| %-10s | %-33s | %-5s %n",b.getBookId(), b.getBookName(), b.getBookAuthor());
        }
        System.out.println("-----------------------------------------------------------------------");
    }
}

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        Book b1 = new Book(101, "The Red Sar", "Javier Moro");
        Book b2 = new Book(102, "Freedom in Exile", "Dalai Lama");
        Book b3 = new Book(103, "My Favourite Nature Stories", "Khurshid M Kasuari");
        Book b4 = new Book(104, "Faces and Places Professor", "Deepak Nayyar");
        Book b5 = new Book(105, "Indian Parliamentary Diplomacy", "Meira Kumar");
        library.addBooks(b1);
        library.addBooks(b2);
        library.addBooks(b3);
        library.addBooks(b4);
        library.addBooks(b5);


        while(true){
            System.out.println("1. Show all Books.");
            System.out.println("2. Add Books.");
            System.out.println("3. Remove Books.");
            System.out.println("4. Exit");

            int num = sc.nextInt();
            if (num == 4){
                break;
            }
            switch (num){
                case 1 :
                    library.showBooks();
                    break;

                case 2 :
                    System.out.print("Enter Book Id : ");
                    int id = sc.nextInt();
                    System.out.print("Enter Book Name : ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.print("Enter Book Author : ");
                    String author = sc.nextLine();

                    Book b = new Book(id,name,author);
                    library.addBooks(b);
                    System.out.println("added....");
                    break;

                case 3 :
                    System.out.print("Enter Book Id : ");
                    int n = sc.nextInt();
                    library.removeBooks(n);
                    break;

                default:
                    System.out.println("Enter correct input.");
            }
        }
    }
}
