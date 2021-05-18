package DesignPatterns.LowLevelDesign.List;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyList<E> {
  private static final int DEFAULT_CAPACITY = 10;
  private int size = 0;
  private Object elements[];

  public MyList() {
    elements = new Object[DEFAULT_CAPACITY];
  }

  public void add(E e) {
    if (size == elements.length) {
      ensureCapacity();
    }
    elements[size++] = e;
  }

  private void ensureCapacity() {
    int newSize = elements.length * 2;
    elements = Arrays.copyOf(elements, newSize);
  }

  public E get(int i) {
    if (i >= size || i < 0) throw new IndexOutOfBoundsException("Index : " + i + ", Size : " + i);
    return (E) elements[i];
  }
}

class MyListTest {
  @Test
  public void testMyList() {
    MyList<Integer> list = new MyList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(3);
    list.add(4);
    assertTrue(4 == list.get(4));
    assertTrue(2 == list.get(1));
    assertTrue(3 == list.get(2));
  }
}
