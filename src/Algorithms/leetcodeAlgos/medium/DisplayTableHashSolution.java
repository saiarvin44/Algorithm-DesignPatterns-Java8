package Algorithms.leetcodeAlgos.medium;

import java.util.*;

class DisplayTableHashSolution {
  public static void main(String[] args) {
    List<List<String>> orders =
        Arrays.asList(
            Arrays.asList("David", "3", "Ceviche"),
            Arrays.asList("Corina", "10", "Beef Burrito"),
            Arrays.asList("David", "3", "Fried Chicken"),
            Arrays.asList("Carla", "5", "Water"),
            Arrays.asList("Carla", "5", "Ceviche"),
            Arrays.asList("Rous", "3", "Ceviche"));

    displayTable(orders);
  }

  public static List<List<String>> displayTable(List<List<String>> orders) {
    Map<Integer, Map<String, Integer>> count = new TreeMap<>();
    int n = orders.size();
    Map<String, Integer> foodCount;
    for (int i = 0; i < n; i++) {
      if (count.get(Integer.valueOf(orders.get(i).get(1))) != null) {
        foodCount = count.get(Integer.valueOf(orders.get(i).get(1)));
        foodCount.put(orders.get(i).get(2), foodCount.getOrDefault(orders.get(i).get(2), 0) + 1);
      } else {
        foodCount = new HashMap<>();
        foodCount.put(orders.get(i).get(2), 1);
        count.put(Integer.valueOf(orders.get(i).get(1)), foodCount);
      }
    }

    List<List<String>> ans = new ArrayList<>();
    List<String> firstCol = new ArrayList<>();
    firstCol.add("Table");
    List<String> subColumns = new ArrayList<>();
    Set<String> distinctFoodSet = new TreeSet<>();
    int countInt = 0;

    List<String> distinctFoodList;

    Map<String, Integer> foodValueMapping = new HashMap<>();
    for (Map.Entry entry : count.entrySet()) {
      foodValueMapping = (Map<String, Integer>) entry.getValue();
      for (Map.Entry entry2 : foodValueMapping.entrySet()) {
        distinctFoodSet.add((String) entry2.getKey());
      }
    }

    distinctFoodList = new ArrayList<>(distinctFoodSet);
    for (Map.Entry entry : count.entrySet()) {
      subColumns=new ArrayList<>();
      foodValueMapping = (Map<String, Integer>) entry.getValue();
      countInt++;
      int table = (int) entry.getKey();
      subColumns.add(String.valueOf(table));

      if (countInt == 1) {
        for (int i = 0; i < distinctFoodList.size(); i++) {
          firstCol.add(distinctFoodList.get(i));
        }
        ans.add(firstCol);
      }
      for (int i = 0; i < distinctFoodList.size(); i++) {
        subColumns.add(String.valueOf(foodValueMapping.getOrDefault(distinctFoodList.get(i), 0)));
      }
      ans.add(subColumns);
    }
    return ans;
  }
}
