package CoreJava.bitManipulation;

public class Output {
  public static void main(String[] args) {
    System.out.println(calc());
    cal(50,150);
  }

  public static int[][] cal(int a, int b) {
    int[][] ans = new int[100][3];
    boolean found = false;
    boolean comp;
    int count = 0;
    int inc = 0;
    for (int i = a; i <= b; i++) {
      count = 0;
      for (int j = i; j <= b; j++) {
        comp = false;
        for (int k = 2; k <= j / 2; k++) {
          if (j % k == 0) {
            comp = true;
            break;
          }
        }
        if (!comp && count < 5) {
          found = false;
          break;
        } else {
          count++;
        }
      }
      if (found && count > 5) {

        ans[inc][0] = i;
        ans[inc][1] = i + count;
        ans[inc][2] = count;
        inc++;
      }
    }
    return ans;
  }

  public static int calc() {
    int a = 10;
    int b = a | a + 6;
    int c = 0;
    c += --a * b << 2;
    a = a++ - b;
    return a;
  }
}
