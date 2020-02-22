import Bookstore.Book;
import Bookstore.BookstoreCheck;
import Bookstore.BookstoreTest;
import ComplexNumber.TestOperation;

public class Main {

    public static void main(String[] args) {
        TestOperation test = new TestOperation();
        test.testAdd();
        test.testMultiply();

        BookstoreTest booktest = new BookstoreTest();

        Book b1 = booktest.getBook();
        Book b2 = booktest.getBook();

        BookstoreCheck bookstoreCheck = new BookstoreCheck();

        System.out.println("Carti identice? " + bookstoreCheck.checkDuplicate(b1, b2));
        bookstoreCheck.whichBigger(b1, b2);

        b1.printBook();

    }

}
