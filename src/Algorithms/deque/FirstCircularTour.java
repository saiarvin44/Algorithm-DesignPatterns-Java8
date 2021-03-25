package Algorithms.deque;

public class FirstCircularTour {
  public static void main(String[] args) {
    int[] petrol = new int[] {4, 8, 7, 4};
    int[] dist = new int[] {6, 5, 3, 5};
    int ans = naive(petrol, dist);
    System.out.print(ans);
    int ans2 = efficient(petrol, dist);
    System.out.print(ans2);
  }

  private static int efficient(int[] petrol, int[] dist) {
    int start = 0, curr_pet = 0, prev_pet = 0;
    for (int i = 0; i < petrol.length; i++) {
      curr_pet += (petrol[i] - dist[i]);
      if (curr_pet < 0) {
        start = i + 1;
        prev_pet += curr_pet;
        curr_pet = 0;
      }
    }
    return (curr_pet + prev_pet) >= 0 ? start + 1 : -1;
  }

  private static int naive(int[] petrol, int[] dist) {
    for (int start = 0; start < petrol.length; start++) {
      int curr_petrol = 0;
      int end = start;
      while (true) {
        curr_petrol += (petrol[end] - dist[end]);
        if (curr_petrol < 0) break;
        end = (end + 1) % petrol.length;
        if (end == start) return start + 1;
      }
    }
    return -1;
  }
}
