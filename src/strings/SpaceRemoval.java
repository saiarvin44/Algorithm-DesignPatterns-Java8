package strings;

public class SpaceRemoval {
  public static void main(String[] args) {
      String demo="SRH GFH";
      demo = demo.replaceAll("\\s", "");
      System.out.print(demo);
  }
}
