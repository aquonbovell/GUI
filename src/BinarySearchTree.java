
public class BinarySearchTree extends AHierarchicalADT {

  public BinarySearchTree() {
    root = null;
  }

  public void purge() {
    root = null;
  }

  public String insert(int number) {
    try {
      root = insert(root, number);
      return (String.format("Inserted %d into the binary search tree.", number));
    } catch (Exception e) {
      return (String.format("Could not insert %d into the binary search tree.\n%s", number, e.getMessage()));
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
          return deleteNode;
        }
      }
      return node;
    }
    return node;
  }

  public String contains(int key) {
    if (root == null) {
      return ("The binary search tree is empty!");
    } else {
      return contains(root, key);
    }
  }

  private String contains(BinaryNode node, int key) {
    
    if (node.getValue() == key) {
      return (String.format("The binary search tree contains %d.", key));
    }
    if (node.getLeft() != null) {
      return contains(node.getLeft(), key);
    }
    if (node.getRight() != null) {
      return contains(node.getRight(), key);
    }
    return (String.format("The binary search tree does not contain %d.", key));
  }
}
