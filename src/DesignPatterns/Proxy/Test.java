package DesignPatterns.Proxy;

public class Test {
  public static void main(String[] args) {
    String book = "new book";
    LazyBookParserProxy proxy = new LazyBookParserProxy(book);
    proxy.getNumPages();
  }
}
