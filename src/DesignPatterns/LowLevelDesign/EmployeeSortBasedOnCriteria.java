package DesignPatterns.LowLevelDesign;

import java.util.Comparator;
import java.util.List;

public class EmployeeSortBasedOnCriteria {
  int sal, id, age;
  String fName, lName;
}

class EmployeeComparator implements Comparator<EmployeeSortBasedOnCriteria> {
  List<Comparator> comparators;

  EmployeeComparator(List<Comparator> comparators) {
    this.comparators = comparators;
  }

  @Override
  public int compare(EmployeeSortBasedOnCriteria o1, EmployeeSortBasedOnCriteria o2) {
    for (Comparator comp : comparators) {
      int result = comp.compare(o1, o2);
      if (result != 0) return result;
    }
    return 0;
  }
}
