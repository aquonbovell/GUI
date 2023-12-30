public class BinaryNode {
  private int value;
  private BinaryNode left;
  private BinaryNode right;

  public BinaryNode() {
    value = 0;
    left = null;
    right = null;
  }

  public BinaryNode(int number) {
    value = number;
    left = null;
    right = null;
  }

  public int getValue() {
    return value;
  }

  public BinaryNode getLeft() {
    return left;
  }

  public BinaryNode getRight() {
    return right;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public void setLeft(BinaryNode left) {
    this.left = left;
  }

  public void setRight(BinaryNode right) {
    this.right = right;
  }

}
