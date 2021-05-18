package CoreJava.Generics;

import java.util.ArrayList;
import java.util.List;

interface A {
  void x();
}

public class Output1 implements A {
  @Override
  public void x() {}

  public void y() {}
}

class C extends Output1 {
  public void x() {}
}

class demo {
  public static void main(String[] args) {
    List<A> list = new ArrayList<>();
    list.add(new Output1());
    list.add(new C());
    for (A a : list) {
      a.x();
    }
  }
}
