package Algorithms.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class RedoUndo {
  private Stack<String> undo, redo;

  public RedoUndo() {
    undo = new Stack<>();
    redo = new Stack<>();
  }

  public void write(String str) {
    undo.push(str);
  }

  public void undo() {
    String str = undo.peek();
    undo.pop();
    redo.push(str);
  }

  public void redo() {
    String str = redo.peek();
    redo.pop();
    undo.push(str);
  }

  public void read() {
    Stack<String> revOrder = new Stack<>();
    while (!undo.isEmpty()) {
      revOrder.push(undo.peek());
      undo.pop();
    }
    while (!revOrder.empty()) {
      System.out.print(revOrder.peek());
      undo.push(revOrder.peek());
      revOrder.pop();
    }
    System.out.print(" ");
  }

  public void query(List<String> op) {
    int n=op.size();
    for(int i=0;i<n;i++){
      if(op.get(i).equals("Undo"))
        undo();
      else if(op.get(i).equals("Redo"))
        redo();
      else if(op.get(i).equals("Read"))
        read();
      else
        write(op.get(i).substring(6));
    }
  }
}

class Solution {
  public static void main(String[] args) {
    RedoUndo redoUndo=new RedoUndo();
    List<String> op= Arrays.asList("Write A", "Write B", "Write C", "Undo", "Read", "Redo", "Read");
    redoUndo.query(op);

  }
}
