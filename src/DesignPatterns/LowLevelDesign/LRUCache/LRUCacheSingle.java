package DesignPatterns.LowLevelDesign.LRUCache;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

public class LRUCacheSingle {
  Set<Integer> cache;
  int capacity;

  public LRUCacheSingle(int capacity) {
    this.cache = new LinkedHashSet<>(capacity);
    this.capacity = capacity;
  }

  public void refer(int key) {
    if (get(key) == false) put(key);
  }

  private boolean get(int key) {
    if (!cache.contains(key)) return false;
    cache.remove(key);
    cache.add(key);
    return true;
  }

  private void put(int key) {
    if (cache.size() == capacity) {
      int firstKey = cache.iterator().next();
      cache.remove(firstKey);
    }
    cache.add(key);
  }

  public void display() {
    LinkedList<Integer> list = new LinkedList<>(cache);
    Iterator<Integer> itr = list.descendingIterator();
    while (itr.hasNext()) System.out.println(itr.next() + " ");
  }

  public static void main(String[] args) {
    LRUCacheSingle cache=new LRUCacheSingle(4);
    cache.refer(1);
    cache.refer(2);
    cache.refer(3);
    cache.refer(1);
    cache.refer(4);
    cache.refer(5);
    cache.display();
  }
}
