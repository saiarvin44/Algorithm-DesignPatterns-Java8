package BestPractices.BestAccessLevelPattern;

import java.util.Objects;

public class RestrictedAccessLevelForArrays {
  private static final Objects[] privateValues = {};

  public static final Objects[] values() {
    return privateValues.clone();
  }
}
