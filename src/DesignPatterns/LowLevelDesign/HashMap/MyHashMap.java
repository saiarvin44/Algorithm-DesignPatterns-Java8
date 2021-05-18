package DesignPatterns.LowLevelDesign.HashMap;

import java.util.LinkedList;

public class MyHashMap {
  private LinkedList<Node>[] buckets;
  private int capacity;
  private double loadFactor;
  private int count;

  public MyHashMap(int capacity) {
    this.capacity = capacity;
    this.buckets = new LinkedList[capacity];
    this.loadFactor = 0.75;
    this.count = 0;
  }

  public static void main(String[] args) {
    MyHashMap map = new MyHashMap(1000);
    map.put(3, 7);
    map.put(4, 8);
    System.out.println(map.get(3)); // 7
    System.out.println(map.get(4)); // 8

    map.put(3, 9);
    map.put(1, 2);
    map.put(2, 3);
    map.put(4, 5);
    map.put(6, 7);
    map.put(7, 8);
    map.put(8, 9);
    map.put(9, 10);

    System.out.println(map.get(3)); // 9
    System.out.println(map.get(4)); // 5
    System.out.println(map.get(5)); // -1
    System.out.println(map.get(6)); // 7
    System.out.println(map.get(7)); // 8
  }

  public void put(int key, int value) {
    int index = hash(key);
    LinkedList<Node> list = buckets[index];
    if (list != null) {
      for (Node node : list) {
        if (node.key == key) {
          node.value = value;
          return;
        }
      }
    }
    if (capacity * loadFactor == count) {
      capacity *= 2;
      LinkedList<Node>[] oldBuckets = buckets;
      buckets = new LinkedList[capacity];
      for (LinkedList<Node> bucket : oldBuckets) {
        if (bucket != null) {
          for (Node node : bucket) {
            index = hash(node.key);
            list = buckets[index];
            if (list == null) list = new LinkedList<>();
            list.addFirst(node);
            buckets[index] = list;
          }
        }
      }
    }
    list = new LinkedList<>();
    list.addFirst(new Node(key, value));
    buckets[index] = list;
    count++;
  }

  public int get(int key) {
    int index = hash(key);
    LinkedList<Node> list = buckets[index];
    if (list == null || list.isEmpty()) return -1;
    for (Node node : list) {
      if (node.key == key) return node.value;
    }
    return -1;
  }

  private int hash(int key) {
    return key % capacity;
  }

  static class Node {
    int key;
    int value;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }
}
