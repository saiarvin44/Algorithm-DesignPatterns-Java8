package algorithms.stack;

import java.util.Stack;

// all operations supported in O(1)
class MinStack {

  Stack<Long> st;
  Long min;

  public MinStack() {
    st = new Stack();
  }

  public void push(long x) {
    if (this.st.isEmpty()) {
      this.st.push(x);
      this.min = x;
    } else if (x < this.min) {
      this.st.push((2 * x) - this.min);
      this.min = x;
    } else this.st.push(x);
  }

  public void pop() {
    long t = this.st.pop();
    // int res=0;
    if (t < this.min) this.min = 2 * this.min - t;
  }

  public int top() {
    if (this.st.peek() < this.min) return this.min.intValue();
    else return this.st.peek().intValue();
  }

  public int getMin() {
    return this.min.intValue();
  }
}
