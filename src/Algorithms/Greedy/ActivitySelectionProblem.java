package Algorithms.Greedy;

import java.util.*;

public class ActivitySelectionProblem {
  private static MyComparator comparator;

  public static void main(String[] args) {
    List<Activity> list = new ArrayList<>();
    list.add(new Activity(12, 25));
    list.add(new Activity(10, 20));
    list.add(new Activity(20, 30));

    System.out.print(activitySelection(list));
  }

  private static int activitySelection(List<Activity> list) {
    Collections.sort(list, comparator);
    int res = 1;
    int prev = 0;
    for (int curr = 1; curr < list.size(); curr++) {
      if (list.get(curr).getStart() >= list.get(prev).getFinish()) {
        res++;
        prev = curr;
      }
    }
    return res;
  }
}

class MyComparator implements Comparator<Activity> {

  @Override
  public int compare(Activity a, Activity b) {
    return a.getFinish() - b.getFinish();
  }
}

class Activity {
  static int start;
  static int finish;

  Activity(int s, int f) {
    start = s;
    finish = f;
  }

  public static int getStart() {
    return start;
  }

  public static int getFinish() {
    return finish;
  }
}
