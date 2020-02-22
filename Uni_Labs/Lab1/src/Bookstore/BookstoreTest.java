package Bookstore;

import java.util.Scanner;

public class BookstoreTest {

    public void testBookstore() {
        Book book = new Book();
        Scanner s = new Scanner(System.in);
    }

    public Book getBook() {
        Book book = new Book();
        Scanner s = new Scanner(System.in);

        System.out.print("Titlul cartii: ");
        String title = s.nextLine();
        book.setTitle(title);


        System.out.print("Autorul cartii: ");
        String author = s.nextLine();
        book.setAuthor(author);


        System.out.print("Publisherul cartii: ");
        String publisher = s.nextLine();
        book.setPublisher(publisher);

        System.out.print("Numarul de pagini al cartii: ");
        int pageCount = s.nextInt();
        if (pageCount != 0) {
            book.setPageCount(pageCount);
        } else {
            System.out.println("WRONG PAGECOUNT");
        }
        return book;
    }

    public void printBook(Book book) {
        String message = String.format(
                "\n BOOK_TITLE: %1$s \n BOOK_AUTHOR: %2$s \n BOOK_PUBLISHER: %3$s \n",
                book.getTitle().toUpperCase(),
                book.getAuthor(),
                book.getPublisher().toLowerCase()
        );
        System.out.println(message);
    }

}
