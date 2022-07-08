package Algorithms.LinkedList;

import DesignPatterns.LowLevelDesign.Iterator.List;

public class Main {
  public static void main(String[] args) {
    List<String> myList = new List<>();

    myList.add("This");
    myList.add("is");
    myList.add("a");
    myList.add("List");
    myList.add("Iterator");

    for (String str : myList) System.out.println(str);
  }
}
