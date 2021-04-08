package BestPractices.IncorrectOverridingEquals;

import java.awt.*;

public class Point {

  private final int x;

  private final int y;

  public Point(int x, int y) {

    this.x = x;

    this.y = y;
  }

  @Override
  public boolean equals(Object o) {

    if (!(o instanceof Point)) return false;

    Point p = (Point) o;

    return p.x == x && p.y == y;
  }
}

class ColorPoint extends Point {

  private final Color color;

  public ColorPoint(int x, int y, Color color) {

    super(x, y);

    this.color = color;
  }

  @Override
  public boolean equals(Object o) {

    if (!(o instanceof ColorPoint)) return false;

    return super.equals(o) && ((ColorPoint) o).color == color;
  }
}

class demo {
  public static void main(String[] args) {
    Point p = new Point(1, 2);
    ColorPoint cp = new ColorPoint(1, 2, Color.RED);
    System.out.println(p.equals(cp));
    System.out.println(cp.equals(p));
    
  }
}
