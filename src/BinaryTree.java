import java.util.Queue;
import java.util.LinkedList;

public class BinaryTree {
  private BinaryNode root;

  public BinaryTree() {
    root = null;
  }

  public void purge() {
    root = null;
  }

  public boolean insert(int number) {
    if (root == null) {
      root = new BinaryNode(number);
      return true;
    }
    Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
    queue.add(root);
    while (!queue.isEmpty()) {
      BinaryNode node = queue.remove();
      if (node.getLeft() == null) {
        node.setLeft(new BinaryNode(number));
        return true;
      } else if (node.getRight() == null) {
        node.setRight(new BinaryNode(number));
        return true;
      } else {
        queue.add(node.getLeft());
        queue.add(node.getRight());
      }
    }
    return false;
  }

  public String remove(int key) {
    if (root == null) {
      return ("The binary tree is empty!");
    }
    if (root.getValue() == key && root.getLeft() == null && root.getRight() == null) {
      root = null;
      return (String.format("Removed %d from the binary tree.", key));

    }
    Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
    queue.add(root);
    BinaryNode keyBinaryNode = null, node = null;

    while (!queue.isEmpty()) {
      node = queue.remove();
      if (node.getValue() == key) {
        keyBinaryNode = node;
      }
      if (node.getLeft() != null) {
        queue.add(node.getLeft());
      }
      if (node.getRight() != null) {
        queue.add(node.getRight());
      }

    }
    if (keyBinaryNode != null) {
      int x = node.getValue();
      removeLastNode(node);
      keyBinaryNode.setValue(x);
      return (String.format("Removed %d from the binary tree.", key));
    }
    return (String.format("Could not find %d in the binary tree.", key));
  }

  private void removeLastNode(BinaryNode deleteNode) {
    Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
    queue.add(root);
    BinaryNode node = null;
    while (!queue.isEmpty()) {
      node = queue.remove();
      if (node.getValue() == deleteNode.getValue()) {
        node = null;
        return;
      }
      if (node.getLeft() != null) {
        if (node.getLeft().getValue() == deleteNode.getValue()) {
          node.setLeft(null);
          return;
        } else {
          queue.add(node.getLeft());
        }
      }
      if (node.getRight() != null) {
        if (node.getRight().getValue() == deleteNode.getValue()) {
          node.setRight(null);
          return;
        } else {
          queue.add(node.getRight());
        }
      }
    }
  }

  public boolean contains(int key) {
    if (root == null) {
      return false;
    }
    Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
    queue.add(root);
    while (!queue.isEmpty()) {
      BinaryNode node = queue.remove();
      if (node.getValue() == key) {
        return true;
      }
      if (node.getLeft() != null) {
        queue.add(node.getLeft());
      }
      if (node.getRight() != null) {
        queue.add(node.getRight());
      }
    }
    return false;
  }
  
  public String levelOrder(){
    if (root == null) {
      return("The binary tree is empty!");
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
      return("The binary tree is empty!");
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
      return("The binary tree is empty!");
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
      return("The binary tree is empty!");
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
