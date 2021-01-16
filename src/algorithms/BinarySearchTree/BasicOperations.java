package algorithms.BinarySearchTree;

public class BasicOperations {
  boolean search(Node root, int x) {
    if (root == null) return false;
    else if (root.key == x) return true;
    else if (root.key < x) return search(root.right, x);
    else return search(root.left, x);
  }

  Node insert(Node root, int x) {
    if (root == null) return new Node(x);
    if (root.key > x) root.left = insert(root.left, x);
    else if (root.key < x) root.right = insert(root.right, x);
    return root;
  }

  Node insertIterative(Node root, int x) {
    Node temp = new Node(x);
    Node parent = null, curr = root;
    while (curr != null) {
      parent = curr;
      if (curr.key > x) curr = curr.left;
      else if (curr.key < x) curr = curr.right;
      else return root;
    }
    if (parent == null) return temp;
    if (parent.key > x) parent.left = temp;
    else parent.right = temp;
    return root;
  }

  Node deleteNode(Node root, int x) {
    if (root == null) return null;
    if (root.key > x) root.left = deleteNode(root.left, x);
    else if (root.key < x) root.right = deleteNode(root.right, x);
    else {
      if (root.left == null) return root.right;
      else if (root.right == null) return root.left;
      else {
        Node succ = getSucc(root);
        root.key = succ.key;
        // delete the next node which we ket as root from the subtree
        root.right = deleteNode(root.right, succ.key);
      }
    }
    return root;
  }

  private Node getSucc(Node root) {
    Node curr = root.right;
    while (curr != null && curr.left != null) curr = curr.left;
    return curr;
  }

  private Node floor(Node root, int x) {
    Node res = null;
    while (root != null) {
      if (root.key == x) return root;
      else if (root.key > x) root = root.left;
      else {
        res = root;
        root = root.right;
      }
    }
    return res;
  }
}
