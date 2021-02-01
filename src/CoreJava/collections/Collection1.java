package CoreJava.collections;

import java.util.ArrayList;

public class Collection1 {
  public static void main(String[] args) {
    ArrayList<String> ex = new ArrayList<>();
    ex.add("hello");
    ex.add("world");
    ex.ensureCapacity(10);
    System.out.println("Minimum capacity : " + ex.size());
    String stringArray[] = new String[ex.size()];
    stringArray = ex.toArray(stringArray);
    System.out.println("ArrayList converted to String array : " + stringArray[1]);

    someMethod(1, 3);
  }

  private static void someMethod(int n, int m) {
    for (int i = n; i < m + 1; i++) {
      System.out.println();
      for (int j = n; j < m + 1; j++) System.out.print(i * j + " ");
    }
  }
}
