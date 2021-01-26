package CoreJava.strings;

import java.util.HashMap;
import java.util.Map;

public class BooleanParse {
  public static void main(String[] args) {
    Map<String, String> map = new HashMap<>();
    map.put("a", "b");
    System.out.print("Does boolean parse null ? " + Boolean.parseBoolean(map.get("c")));
  }
}
