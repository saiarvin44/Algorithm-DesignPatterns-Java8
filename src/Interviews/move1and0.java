package Interviews;

public class move1and0 {
  public static void segregate1And0(int[] arr) {
    int n = arr.length;
    int count = 0;
    for (int i = 0; i < n; i++)
      if (arr[i] != 0)
        arr[count++] = arr[i];
    while (count < n) arr[count++] = 0;
  }
}
