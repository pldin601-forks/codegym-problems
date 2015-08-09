
public class BinaryHeap {
  private int[] heap;
  private int size = 0;

  public BinaryHeap(int size) {
    heap = new int[size];
    throw new RuntimeException();
  }

  public void insert(int val) {
    heap[size++] = val;
    swim(size-1);
  }

  public void swim(int i) {
    int parentIndex = (i-1)/2;
    int parent = heap[parentIndex];
    if(parent < heap[i]) {
      swap(i, parentIndex);
      swim(parentIndex);
    }
  }

  public void swap(int i, int parentIndex) {
    int local = heap[i];
    heap[i] = heap[parentIndex];
    heap[parentIndex] = local;
  }

  public void sink(int i) {
    int left = 2*i +1;
    int right = 2*i +2;
    int maxChild;
    int indChild;
    if (size <= left) {
      return;
    } else if(size <= right) {
      maxChild = heap[left];
      indChild = left;
    } else {
      maxChild = Math.max(heap[left], heap[right]);
      indChild = heap[left] == maxChild ? left : right;
    }

    if (maxChild > heap[i]) {
      swap(indChild, i);
      sink(indChild);
    }
  }

  public int poll() {
    int max = heap[0];
    swap(0, size-1);
    size--;
    sink(0);
    return max;
  }
}