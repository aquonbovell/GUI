import java.util.Queue;
import java.util.LinkedList;

public class BinaryTree extends AHierarchicalADT {

  public BinaryTree() {
    root = null;
  }

  @Override
  public void purge() {
    root = null;
  }

  @Override
  public String insert(int number) {
    try {
      if (root == null) {
        root = new BinaryNode(number);
        return (String.format("Inserted %d into the binary tree.", number));
      }
      Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
      queue.add(root);
      while (!queue.isEmpty()) {
        BinaryNode node = queue.remove();
        if (node.getLeft() == null) {
          node.setLeft(new BinaryNode(number));
          return (String.format("Inserted %d into the binary tree.", number));
        } else if (node.getRight() == null) {
          node.setRight(new BinaryNode(number));
          return (String.format("Inserted %d into the binary tree.", number));
        } else {
          if (node.getLeft() != null)
            queue.add(node.getLeft());
          if (node.getRight() != null)
            queue.add(node.getRight());
        }
      }
      return (String.format("Could not insert %d into the binary tree.", number));
    } catch (Exception e) {
      return (String.format("Could not insert %d into the binary tree.\n%s", number, e.getMessage()));
    }
  }

  @Override
  public String remove(int key) {
    try {
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
    } catch (Exception e) {
      return (String.format("Could not remove %d from the binary tree.\n%s", key, e.getMessage()));
    }
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

  @Override
  public String contains(int key) {
    try {
      if (root == null) {
        return ("The binary tree is empty!");
      }
      Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
      queue.add(root);
      while (!queue.isEmpty()) {
        BinaryNode node = queue.remove();
        if (node.getValue() == key) {
          return (String.format("The binary tree contains %d.", key));
        }
        if (node.getLeft() != null) {
          queue.add(node.getLeft());
        }
        if (node.getRight() != null) {
          queue.add(node.getRight());
        }
      }
      return (String.format("The binary tree does not contain %d.", key));
    } catch (Exception e) {
      return (String.format("Could not determine if the binary tree contains %d.\n%s", key, e.getMessage()));
    }
  }
}
