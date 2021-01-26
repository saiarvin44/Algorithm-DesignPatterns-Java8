package algorithms.BinaryHeap;

public class MinHeap {
  int[] arr;
  int size;
  int capacity;

  MinHeap(int c) {
    arr = new int[c];
    size = 0;
    capacity = c;
  }

  int left(int i) {
    return (2 * i + 1);
  }

  int right(int i) {
    return (2 * i + 2);
  }

  int parent(int i) {
    return (i - 1) / 2;
  }

  void insert(int x) {
    if (size == capacity) return;
    size++;
    arr[size - 1] = x;
    for (int i = size - 1; i != 0 && arr[parent(i)] > arr[i]; ) {
      swapElts(arr, i, parent(i));
      i = parent(i);
    }
  }

  void minHeapify(int start) {
    int lt = left(start), rt = right(start);
    int smallest = start;
    if (lt < size && arr[lt] < arr[start]) smallest = lt;
    if (rt < size && arr[rt] < arr[start]) smallest = rt;
    if (smallest != start) {
      swapElts(arr, start, smallest);
      minHeapify(smallest);
    }
  }

  int getMinimum() {
    return arr[0];
  }

  int extractMin() {
    if (size == 0) return Integer.MAX_VALUE;
    if (size == 1) {
      size--;
      return arr[0];
    }
    swapElts(arr, 0, size - 1);
    size--;
    minHeapify(0);
    return arr[size];
  }

  void decreaseKey(int index, int value) {
    arr[index] = value;
    while (index != 0 && arr[parent(index)] > arr[index]) {
      swapElts(arr, index, parent(index));
      index = parent(index);
    }
  }

  void deleteKey(int i) {
    decreaseKey(i, Integer.MIN_VALUE);
    extractMin();
  }

  void buildHeap() {
    for (int i = (size - 2) / 2; i >= 0; i--) minHeapify(i);
  }

  private void swapElts(int[] arr, int i, int parent) {
    int temp = arr[i];
    arr[i] = arr[parent(i)];
    arr[parent(i)] = temp;
  }
}
