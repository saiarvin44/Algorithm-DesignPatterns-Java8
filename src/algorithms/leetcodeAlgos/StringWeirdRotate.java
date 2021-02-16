package algorithms.leetcodeAlgos;

public class StringWeirdRotate {
  public static void main(String[] args) {
    String s = "123456";
    System.out.print(checkWeirdRotate(s));
  }

  private static int checkWeirdRotate(String s) {
    int countFirst, countSecond, travel, res, charToSubtract = 0;
    int t;
    for (int i = 10; i < 100; i++) {
      char second = (char) ((i % 10) + '0');
      t = i / 10;
      char first = (char) ((t % 10) + '0');
      countFirst = 0;
      countSecond = 0;
      travel = 0;
      while (travel != s.length()) {
        while (travel != s.length() && s.charAt(travel) != first) travel++;

        if (travel != s.length() && s.charAt(travel) == first) {
          countFirst++;
          travel++;
        } else break;
        while (travel != s.length() && s.charAt(travel) != second) travel++;

        if (travel != s.length() && s.charAt(travel) == second) {
          countSecond++;
          travel++;
        } else break;
      }
      res = Math.min(countFirst, countSecond);
      charToSubtract = Math.max(2 * res, charToSubtract);
    }
    return s.length() - charToSubtract;
  }
}
