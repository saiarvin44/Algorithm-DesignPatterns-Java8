package Algorithms.hashing;

import java.util.ArrayList;
import java.util.LinkedList;

public class chaining {
  int bucket;
  ArrayList<LinkedList<Integer>> table;

  chaining(int b) {
    bucket = b;
    table = new ArrayList<LinkedList<Integer>>();
    for (int i = 0; i < bucket; i++) table.add(new LinkedList<Integer>());
  }

  public static void main(String[] args) {}

  void insert(int key) {
    int i = key % bucket;
    this.table.get(i).add(key);
  }

  void remove(int key) {
    int i = key % bucket;
    this.table.get(i).remove((Integer) i);
  }

  boolean search(int key) {
    int i = key % bucket;
    return this.table.get(i).contains(key);
  }
}
