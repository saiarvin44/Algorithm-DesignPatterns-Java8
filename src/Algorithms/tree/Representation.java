package Algorithms.tree;

public class Representation {
  int key;
  Representation left, right;

  Representation(int key) {
    this.key = key;
  }
}

class Test {
  public static void main(String[] args) {
    Representation root = new Representation(10);
    root.left = new Representation(20);
    root.right = new Representation(30);
    root.left.right = new Representation(40);
  }
}
