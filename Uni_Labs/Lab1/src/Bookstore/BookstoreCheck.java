package Bookstore;

public class BookstoreCheck {

    public boolean checkDuplicate(Book b1, Book b2) {
        return b1.getAuthor().equals(b2.getAuthor()) && b1.getPublisher().equals(b2.getPublisher())
                && b1.getTitle().equals(b2.getTitle()) && b1.getPageCount() == b2.getPageCount();
    }

    public void whichBigger(Book b1, Book b2) {
        if ((b1.getPageCount() > b2.getPageCount())) {
            System.out.println(b1.getTitle());
        } else if (b2.getPageCount() > b1.getPageCount()) {
            System.out.println(b2.getTitle());
        } else {
            System.out.println("Pagini egale");
        }
    }

}
