package CoreJava.bitManipulation;

import java.util.ArrayList;
import java.util.List;

public class BinaryAdd {
  public static void main(String[] args) {
    List<Integer> binary = new ArrayList<>();
    int sum = 0;
    binary.add(1);
    binary.add(1);
    binary.add(1);
    for (int elt : binary) {
      sum = (sum << 1) | elt;
    }
  }
}
