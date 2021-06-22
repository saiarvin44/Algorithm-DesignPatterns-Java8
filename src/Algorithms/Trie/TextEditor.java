package Algorithms.Trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TextEditor {
  static final int ALPHABET_SIZE = 26;
  static TrieNode root;
  static int size = -1;
  static List<String> list = new ArrayList<>();
  static Stack<ArrayList<Integer>> stack = new Stack<>();

  static void insert(String key) {
    size++;
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
    pCrawl.posList.add(size);
    list.add(key);
  }

  static TrieNode remove(TrieNode root, String key, int i) {
    if (root == null) return null;
    if (i == key.length()) {
      if (root.isEnd) root.isEnd = false;
      stack.push((ArrayList<Integer>) root.posList);
      if (isEmpty(root)) {
        root = null;
      }
      if (root != null) root.posList = new ArrayList<>();
      return root;
    }

    int index = key.charAt(i) - 'a';
    root.child[index] = remove(root.child[index], key, i + 1);
    if (isEmpty(root) && root.isEnd == false) {
      root = null;
    }
    return root;
  }

  private static boolean isEmpty(TrieNode root) {
    for (int i = 0; i < ALPHABET_SIZE; i++) if (root.child[i] != null) return false;
    return true;
  }

  static List<Integer> search(String key) {
    int level;
    int length = key.length();
    int index;

    TrieNode pCrawl = root;

    for (level = 0; level < length; level++) {
      index = key.charAt(level) - 'a';
      if (pCrawl.child[index] == null) return new ArrayList<>();
      pCrawl = pCrawl.child[index];
    }
    if (pCrawl != null && pCrawl.isEnd) return pCrawl.posList;
    return new ArrayList<>();
  }

  public static void main(String[] args) {
    String keys[] = {"bad", "bat", "geeks", "geeks", "cat", "cut"};

    root = new TrieNode();

    int i;
    for (i = 0; i < keys.length; i++) insert(keys[i]);

    if (search("bad").size() != 0) System.out.println("bad --- " + search("bad").size());
    else System.out.println("bad --- " + "Not there");

    if (search("geeks").size() != 0) System.out.println("geeks --- " + search("geeks").size());
    else System.out.println("geeks --- " + "Not there");

    remove(root, "geeks", 0);
    if (search("geeks").size() != 0) System.out.println("geeks --- " + search("geeks").size());
    else System.out.println("geeks --- " + "Not there");

    if (search("ca").size() != 0) System.out.println("ca --- " + search("ca").size());
    else System.out.println("ca --- " + "Not there");
  }

  static class TrieNode {
    TrieNode[] child = new TrieNode[ALPHABET_SIZE];
    boolean isEnd;
    List<Integer> posList;

    TrieNode() {
      isEnd = false;
      for (int i = 0; i < ALPHABET_SIZE; i++) child[i] = null;
      posList = new ArrayList<>();
    }
  }
}
