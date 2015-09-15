
public class FibNode {
  int key = 0;
  int rank;
  FibNode prev;
  FibNode next;
  FibNode parent = null;
  FibNode child = null;
  boolean isMarked;
  boolean isMinimum;

  public FibNode(int key) {
    this.key = key;
    this.next = this;
    this.prev = this;
    rank = 0;
  }

  public int getKey() {
    return key;
  }

  public void setKey(int key) {
    this.key = key;
  }

  public String printNode() {
    return printNode(0);
  }

  public String printNode(int level) {
    StringBuilder sb = new StringBuilder();

    FibNode current = this;
    do {
      sb.append("{Node: ")
          .append(current.key)
          .append("  Lev: ")
          .append(level)
          .append(" ");

      if (current.child != null) {
        sb.append("\n")
            .append(current.child.printNode(level + 1));
      }
      current = current.next;
    } while (current != this);
    return sb.append('}').toString();
  }
}