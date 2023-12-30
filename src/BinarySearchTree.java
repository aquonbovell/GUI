import java.util.Queue;
import java.util.LinkedList;

public class BinarySearchTree {
  private BinaryNode root;

  public BinarySearchTree() {
    root = null;
  }

  public void purge() {
    root = null;
  }

  public boolean insert(int number) {
    try {
      root = insert(root, number);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  private BinaryNode insert(BinaryNode node, int number) {
    if (node == null) {
      return new BinaryNode(number);
    }
    if (number < node.getValue()) {
      node.setLeft(insert(node.getLeft(), number));
    } else if (number > node.getValue()) {
      node.setRight(insert(node.getRight(), number));
    }
    return node;
  }

  public String remove(int key) {
    if (root == null) {
      return ("The binary search tree is empty!");
    }
    StringBuilder result = new StringBuilder();
    root = remove(root, key, result);
    return result.length() > 0 ? result.toString()
        : String.format("Could not remove %d from the binary search tree.", key);
  }

  private BinaryNode remove(BinaryNode node, int key, StringBuilder result) {
    if (node == null) {
      return null;
    }
    if (key < node.getValue()) {
      node.setLeft(remove(node.getLeft(), key, result));
    } else if (key > node.getValue()) {
      node.setRight(remove(node.getRight(), key, result));
    } else {
      if (node.getLeft() == null && node.getRight() == null) {
        node = null;
        result.append(String.format("Removed %d from the binary search tree.", key));
      } else if (node.getLeft() == null) {
        node = node.getRight();
        result.append(String.format("Removed %d from the binary search tree.", key));
      } else if (node.getRight() == null) {
        result.append(String.format("Removed %d from the binary search tree.", key));
        node = node.getLeft();
      } else {
        BinaryNode deleteNode = node;
        BinaryNode parent = node;
        node = node.getRight();
        while (node.getLeft() != null) {
          parent = node;
          node = node.getLeft();
        }
        result.append(String.format("Removed %d from the binary search tree.", key));
        deleteNode.setValue(node.getValue());
        if (parent == deleteNode) {
          parent.setRight(node.getRight());
          return parent;
        } else {
          parent.setLeft(node.getRight());
          node.setRight(parent);
        }
      }
      return node;
    }
    return node;
  }

  public boolean contains(int key) {
    if (root == null) {
      return false;
    } else {
      return contains(root, key);
    }
  }

  private boolean contains(BinaryNode node, int key) {
    if (node.getValue() == key) {
      return true;
    }
    if (node.getLeft() != null) {
      if (contains(node.getLeft(), key)) {
        return true;
      }
    }
    if (node.getRight() != null) {
      if (contains(node.getRight(), key)) {
        return true;
      }
    }
    return false;
  }

  public String levelOrder() {
    if (root == null) {
      return ("The binary search tree is empty!");
    }
    String result = "";
    Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
    queue.add(root);
    while (!queue.isEmpty()) {
      BinaryNode node = queue.remove();
      result += (node.getValue() + ", ");
      if (node.getLeft() != null) {
        queue.add(node.getLeft());
      }
      if (node.getRight() != null) {
        queue.add(node.getRight());
      }
    }
    return result;
  }

  public String inOrder() {
    if (root == null) {
      return ("The binary search tree is empty!");
    }
    return inOrder(root);
  }

  private String inOrder(BinaryNode node) {
    String result = "";
    if (node.getLeft() != null) {
      result += inOrder(node.getLeft());
    }
    result += (node.getValue() + ", ");
    if (node.getRight() != null) {
      result += inOrder(node.getRight());
    }
    return result;
  }

  public String preOrder() {
    if (root == null) {
      return ("The binary search tree is empty!");
    }
    return preOrder(root);
  }

  private String preOrder(BinaryNode node) {
    String result = "";
    result += (node.getValue() + ", ");
    if (node.getLeft() != null) {
      result += preOrder(node.getLeft());
    }
    if (node.getRight() != null) {
      result += preOrder(node.getRight());
    }
    return result;
  }

  public String postOrder() {
    if (root == null) {
      return ("The binary search tree is empty!");
    }
    return postOrder(root);
  }

  private String postOrder(BinaryNode node) {
    String result = "";
    if (node.getLeft() != null) {
      result += postOrder(node.getLeft());
    }
    if (node.getRight() != null) {
      result += postOrder(node.getRight());
    }
    result += (node.getValue() + ", ");
    return result;
  }
}
