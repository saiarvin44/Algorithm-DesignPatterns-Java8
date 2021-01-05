package DesignPatterns.Proxy;

public class BookParser implements IBookParser {
  private String book;

  public BookParser(String book) {
    System.out.println("Expensive operation : ");
    this.book = book;
    System.out.println("Showing the book : " + book);
  }

  public int getNumPages() {
    System.out.println("Returning number of pages : " + this.book.length());
    return 100;
  }
}
