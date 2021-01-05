package DesignPatterns.Proxy;

public class LazyBookParserProxy implements IBookParser {
  private BookParser bookParser = null;
  private String book;

  public LazyBookParserProxy(String book) {
    this.book = book;
  }

  @Override
  public int getNumPages() {
    if (this.bookParser == null) this.bookParser = new BookParser(this.book);
    return this.bookParser.getNumPages();
  }
}
