package Algorithms.Trie;

public class Trie {
  static final int ALPHABET_SIZE = 26;
  static TrieNode root;

  static void insert(String key) {
    int level;
    int length = key.length();
    int index;

    TrieNode pCrawl = root;

    for (level = 0; level < length; level++) {
      index = key.charAt(level) - 'a';
      if (pCrawl.child[index] == null) pCrawl.child[index] = new TrieNode();
      pCrawl = pCrawl.child[index];
    }

    pCrawl.isEnd = true;
  }

  public static void main(String args[]) {
    String keys[] = {"bad", "bat", "geeks", "geeks", "cat", "cut"};
    String output[] = {"NO", "YES"};

    root = new TrieNode();

    int i;
    for (i = 0; i < keys.length; i++) insert(keys[i]);

    if (search("bad") == true) System.out.println("bad --- " + output[1]);
    else System.out.println("bad --- " + output[0]);

    if (search("geeks") == true) System.out.println("geeks --- " + output[1]);
    else System.out.println("geeks --- " + output[0]);

    if (search("ca") == true) System.out.println("ca --- " + output[1]);
    else System.out.println("ca --- " + output[0]);
  }

  static boolean search(String key) {
    int level;
    int length = key.length();
    int index;

    TrieNode pCrawl = root;

    for (level = 0; level < length; level++) {
      index = key.charAt(level) - 'a';
      if (pCrawl.child[index] == null) return false;
      pCrawl = pCrawl.child[index];
    }

    return (pCrawl != null && pCrawl.isEnd);
  }

  static TrieNode delete(TrieNode root, String key, int startingIndex) {
    if (root == null) return null;
    if (startingIndex == key.length()) {
      root.isEnd = false;
      if (isEmpty(root)) root = null;
      return root;
    }

    int index = key.charAt(startingIndex) - 'a';
    root.child[index] = delete(root.child[index], key, startingIndex + 1);
    if (isEmpty(root) && root.isEnd == false) root = null;
    return root;
  }

  private static boolean isEmpty(TrieNode root) {
    for (int i = 0; i < ALPHABET_SIZE; i++) if (root.child[i] != null) return false;
    return true;
  }

  static class TrieNode {
    TrieNode[] child = new TrieNode[ALPHABET_SIZE];
    boolean isEnd;

    TrieNode() {
      isEnd = false;
      for (int i = 0; i < ALPHABET_SIZE; i++) child[i] = null;
    }
  }
}
