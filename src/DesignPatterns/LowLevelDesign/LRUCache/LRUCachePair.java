package DesignPatterns.LowLevelDesign.LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCachePair {

  Map<Integer, Node> cache;
  Node start, end;
  int capacity;

  class Node {
    int key, value;
    Node left, right;

    Node() {
      this.left = null;
      this.right = null;
    }
  }

  public LRUCachePair(int capacity) {
    this.capacity = capacity;
    cache = new HashMap<>();
    start = new Node();
    end = new Node();
    start.left = null;
    start.right = end;
    end.left = start;
    end.right = null;
  }

  public void put(int key, int value) {
    if (cache.containsKey(key)) {
      Node node = cache.get(key);
      node.value = value;
      remove(node);
      addAtTop(node);
    } else {
      Node node = new Node();
      node.left = null;
      node.right = null;
      node.value = value;
      node.key = key;
      if (cache.size() == capacity) {
        cache.remove(end.key);
        remove(end);
        addAtTop(node);
      } else
        addAtTop(node);
    }
  }

  public int get(int key) {
    if (cache.containsKey(key)) {
      Node node = cache.get(key);
      remove(node);
      addAtTop(node);
      return node.value;
    }
    return -1;
  }

  public void remove(Node node) {
    if (node.left != null) node.left.right = node.right;
    else start = node.right;
    if (node.right != null) node.right.left = node.left;
    else end = node.left;
  }

  public void addAtTop(Node node) {
    node.right = start;
    node.left = null;
    if (start != null) start.left = node;
    start = node;
    if (end == null) end = start;
  }

  public static void main(String[] args) {
    LRUCachePair LRUCache = new LRUCachePair(3);
    LRUCache.put(1, 1);
    LRUCache.put(10, 15);
    LRUCache.put(15, 10);
    LRUCache.put(10, 6);
    LRUCache.put(12, 15);
    LRUCache.put(18, 10);
    LRUCache.put(13, 6);

    System.out.println(LRUCache.get(1));
    System.out.println(LRUCache.get(10));
    System.out.println(LRUCache.get(15));


  }
}
