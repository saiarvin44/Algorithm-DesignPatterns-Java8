package DesignPatterns.Bridge;

public class Test {
  public static void main(String[] args) {
    View view = new LongFormView(new ArtistResource(new Artist()));
    System.out.println(view.show());
  }
}
