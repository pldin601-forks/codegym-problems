public class FibNode<E extends Comparable<E>> implements Comparable<FibNode<E>> {

  E key;
  int rank;
  FibNode<E> prev;
  FibNode<E> next;
  FibNode<E> parent;
  FibNode<E> child;

  boolean isMarked;
  boolean isMinimum;

  public FibNode() {
    this.key = null;
  }

  public FibNode(E key) {
    this.key = key;
    this.next = this;
    this.prev = this;
    rank = 0;
  }

  public E getKey() {
    return key;
  }

  public void setKey(E key) {
    this.key = key;
  }

  public int compareTo(FibNode<E> that) {
    return this.key.compareTo(that.key);
  }
}
