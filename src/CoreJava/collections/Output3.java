package CoreJava.collections;

public class Output3 {
  Node root;

  static Node newNode(int data) {
    Node node = new Node();
    node.data = data;
    node.left = node.right = null;
    return node;
  }

  public static void main(String[] args) {
    Output3 tree = new Output3();
    tree.root = newNode(1);
    tree.root.left = newNode(2);
    tree.root.right = newNode(3);
    tree.root.left.left = newNode(4);
    tree.root.left.right = newNode(5);
    System.out.println("Inorder :");
    tree.inOrder(tree.root);
    tree.mirror(tree.root);
    System.out.println("Inorder mirrored :");
    tree.inOrder(tree.root);
  }

  private Node mirror(Node root) {
    if (root == null) return null;
    Node left = mirror(root.left);
    Node right = mirror(root.right);
    root.left = right;
    root.right = left;
    return root;
  }

  private void inOrder(Node root) {
    if (root == null) return;
    inOrder(root.left);
    System.out.print(root.data + " ");
    inOrder(root.right);
  }

  static class Node {
    int data;
    Node left, right;
  }
}
