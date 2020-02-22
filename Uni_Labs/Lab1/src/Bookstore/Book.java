package Bookstore;

public class Book {

    private String title;
    private String author;
    private String publisher;
    private int pageCount;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void printBook() {
        System.out.println("BOOK_TITLE: " + this.getTitle().toUpperCase());
        System.out.println("BOOK_AUTHOR: " + this.getAuthor());
        System.out.println("BOOK_PUBLISHER: " + this.getPublisher().toLowerCase());
    }

}
