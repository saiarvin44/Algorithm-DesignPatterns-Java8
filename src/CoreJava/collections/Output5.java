package CoreJava.collections;

public class Output5 {
  public static void main(String[] args) {
    int[] a = {1};
    Output5 t = new Output5();
    t.increment(a);
    System.out.println(a[a.length - 1]);
  }

  void increment(int[] i) {
    i[i.length - 1]++;
  }
}
