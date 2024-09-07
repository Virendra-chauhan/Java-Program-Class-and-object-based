package book;

import java.util.ArrayList;
import java.util.Scanner;

public class Book {
    private String title;
    private String author;
    private String isbn;

    Book(String title, String author, String isbn){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String getAuthor(){
        return author;
    }

    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    public String getIsbn(){
        return isbn;
    }

}

class Library{
    private ArrayList<Book> books;

    Library(){
        books = new ArrayList<>();
    }

    public void addBooks(Book b){
        books.add(b);
        System.out.println("added...");
    }

    public void removeBook(String author){
        books.removeIf(book -> book.getAuthor().equalsIgnoreCase(author));
        System.out.println("removed...");
    }

    public void display(){
        System.out.println("Book Title | Author Name | ISBN ");
        for (Book b : books){
            System.out.println(b.getTitle() + " | " + b.getAuthor() + " | " + b.getIsbn());
        }

        System.out.println("****************************************************************");
    }
}

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while (true){
            System.out.print("Enter Book Title (or exit): ");
            String title = sc.nextLine();

            if (title.equalsIgnoreCase("exit")){
                break;
            }

            System.out.print("Enter Book Author : ");
            String author = sc.nextLine();

            System.out.print("Enter Book ISBN : ");
            String isbn = sc.nextLine();

            Book book = new Book(title,author,isbn);

            library.addBooks(book);
        }
        System.out.println("*********************** Books Collection ***********************");
        library.display();

        while (true){
            System.out.print("Do you want to remove any book enter author name (or exit) : ");
            String remove = sc.nextLine();
            if (remove.equalsIgnoreCase("exit")){
                break;
            }
            library.removeBook(remove);
        }


        System.out.println("*********************** After Remove, Books Collection ***********************");
        library.display();
    }
}

