package CoreJava.Exception;

public class Output1 {
  public static void main(String[] args) {
    int x = 10;
    int y = 2;
    try {
      for (int z = 2; z >= 0; z--) {
        int ans = x / z;
        System.out.print(ans + " ");
      }
    } catch (ArithmeticException e) {

    } catch (Exception e) {
      System.out.print("E1");
    }
  }
}
