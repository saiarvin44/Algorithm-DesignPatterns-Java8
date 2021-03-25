package Algorithms.leetcodeAlgos;

import java.util.Stack;

public class CrawlerLogFolder {
  public static void main(String[] args) {
    String[] logs = new String[] {"./", "../", "./"};
    System.out.print(minOperations(logs));
  }

  public static int minOperations(String[] logs) {
    Stack<String> s = new Stack<>();
    for (int i = 0; i < logs.length; i++) {
      if (logs[i].startsWith("..")) {
        if (s.size() > 0) s.pop();
      } else if (!logs[i].startsWith("./")) {
        s.push(logs[i]);
      }
    }
    return s.size();
  }
}
