public class RedBlackTree {

  private Node root;

  public void add(int key, int val) {
    root = new Node(key, val);
  }

  public Integer delete(int key) {
    Integer res = root.getValue();
    root = null;
    return res;
  }

  protected Node getRoot() {
    return root;
  }

  public Integer get(int key) {
    Integer res = null;
    if (root!= null) {
      res = root.getValue();
    }
    return res;
  }

  public static Node parent(Node node) {
    return (node == null) ? null : node.parent;
  }

  public static Node grandparent(Node node) {
    return parent(parent(node));
  }

  public static Node uncle(Node node) {
    Node granny = grandparent(node);
    Node parent = parent(node);
    if (granny == null) return null;
    return (granny.getLeft() == parent) ? granny.getRight() : granny.getLeft();
  }

  public static class Node {
    private int key, value;
    private boolean isRed = true;
    private Node left, right, parent;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }

    public Node setLeft(Node node) {
      this.left = node;
      return this;
    }

    public Node setRight(Node node) {
      this.right = node;
      return this;
    }

    public Node getLeft() {
      return left;
    }

    public Node getRight() {
      return right;
    }

    public int getKey() {
      return key;
    }

    public int getValue() {
      return value;
    }

    public boolean isRed() {
      return isRed;
    }

    public void setRed() {
      isRed = true;
    }

    public void setBlack() {
      isRed = false;
    }

    @Override
    public String toString() {
      return String.format("{key: %d, value: %d, %s}",
          key, value, (isRed)?"red": "black");
    }
  }
}
