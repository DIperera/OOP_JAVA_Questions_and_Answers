/*
Create a Java class named "Book" with the attributes (String) title, (String) author and (int) pageCount. 
Write a constructor to initialize the attributes and provide getters and setters for all three attributes. 
Implement a method named "isShortBook" that returns true if the page count is less than 200, and false otherwise. 
Implement a method called "print" that prints the details of the book.

Create a class called "BookApp" with the main method. Create 2 Book objects and accept the user inputs for 
attributes and assign them. Display the details of both books.
*/

package labtestimages;

import java.util.Scanner;

public class Book {
    private String title;
    private String author;
    private int pageCount;

    public Book(String title, String author, int pageCount) {
        this.title = title;
        this.author = author;
        this.pageCount = pageCount;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public boolean isShortBook() {
        if (pageCount < 200) {
            return true;
        } else {
            return false;
        }
    }

    public void print() {
        System.out.println("Title is " + title + ". Author is " + author + ". Page count is " + pageCount);
    }
}

public class BookApp {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the details of book 1 :");
        String title1 = sc.next();
        String author1 = sc.next();
        int pages1 = sc.nextInt();
        
        System.out.println("Enter the details of book 2 :");
        String title2 = sc.next();
        String author2 = sc.next();
        int pages2 = sc.nextInt();
        
        Book book1 = new Book(title1, author1, pages1);
        Book book2 = new Book(title2, author2, pages2);
        
        book1.print();
        book2.print();
        
        if (book1.isShortBook()) {
            System.out.println("Book1 has less than 200 pages");
        } else {
            System.out.println("Book1 has more than 200 pages");
        }
        if (book2.isShortBook()) {
            System.out.println("Book2 has less than 200 pages");
        } else {
            System.out.println("Book2 has more than 200 pages");
        }
        
        sc.close();
    }
}
