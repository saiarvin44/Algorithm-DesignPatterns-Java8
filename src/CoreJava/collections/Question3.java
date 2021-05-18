package CoreJava.collections;

public class Question3 {
  public static void main(String[] args) {
    String a = "FalabellaIndia";
    String b = new String(a);
    int value = 0;
    value = (a == b) ? 1 : 2;
    if (value == 1) System.out.print("FalabellaIndia");
    else if (value == 2) System.out.print("Falabella India");
    else System.out.print("Falabella chile");
  }
}
