package CoreJava.collections;

import java.util.HashSet;

public class Output1 {
  private String s;

  public Output1(String s) {
    this.s = s;
  }

  public static void main(String[] args) {
    HashSet<Object> hs = new HashSet<>();
    Output1 ws1 = new Output1("aardvark");
    Output1 ws2 = new Output1("aardvark");
    String s1 = new String("aardvark");
    String s2 = new String("aardvark");
    hs.add(ws1);
    hs.add(ws2);
    hs.add(s1);
    hs.add(s2);
    System.out.print(hs.size());
  }
}
