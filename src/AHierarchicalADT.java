import java.util.Queue;
import java.util.LinkedList;

public abstract class AHierarchicalADT {
  protected BinaryNode root;

  public abstract void purge();

  public abstract String insert(int number);

  public abstract String remove(int key);

  public abstract String contains(int key);

  final public String levelOrder() {
    if (root == null) {
      if (this instanceof BinaryTree)
        return ("The binary tree is empty!");
      else if (this instanceof BinarySearchTree)
        return ("The binary search tree is empty!");
      // else if (this instanceof AVLTree)
      //   return ("The AVL tree is empty!");
      // else if (this instanceof RedBlackTree)
      //   return ("The red-black tree is empty!");
      // else if (this instanceof SplayTree)
      //   return ("The splay tree is empty!");
      // else if (this instanceof BinaryMinHeap)
      //   return ("The binary min heap is empty!");
      // else if (this instanceof BinaryMaxHeap)
      //   return ("The binary max heap is empty!");
      else
        return ("The data structure is empty!");
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

  final public String inOrder() {
    if (root == null) {
      if (this instanceof BinaryTree)
        return ("The binary tree is empty!");
      else if (this instanceof BinarySearchTree)
        return ("The binary search tree is empty!");
      // else if (this instanceof AVLTree)
      //   return ("The AVL tree is empty!");
      // else if (this instanceof RedBlackTree)
      //   return ("The red-black tree is empty!");
      // else if (this instanceof SplayTree)
      //   return ("The splay tree is empty!");
      // else if (this instanceof BinaryMinHeap)
      //   return ("The binary min heap is empty!");
      // else if (this instanceof BinaryMaxHeap)
      //   return ("The binary max heap is empty!");
      else
        return ("The data structure is empty!");
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

  final public String preOrder() {
    if (root == null) {
      if (this instanceof BinaryTree)
        return ("The binary tree is empty!");
      else if (this instanceof BinarySearchTree)
        return ("The binary search tree is empty!");
      // else if (this instanceof AVLTree)
      //   return ("The AVL tree is empty!");
      // else if (this instanceof RedBlackTree)
      //   return ("The red-black tree is empty!");
      // else if (this instanceof SplayTree)
      //   return ("The splay tree is empty!");
      // else if (this instanceof BinaryMinHeap)
      //   return ("The binary min heap is empty!");
      // else if (this instanceof BinaryMaxHeap)
      //   return ("The binary max heap is empty!");
      else
        return ("The data structure is empty!");
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

  final public String postOrder() {
    if (root == null) {
      if (this instanceof BinaryTree)
        return ("The binary tree is empty!");
      else if (this instanceof BinarySearchTree)
        return ("The binary search tree is empty!");
      // else if (this instanceof AVLTree)
      //   return ("The AVL tree is empty!");
      // else if (this instanceof RedBlackTree)
      //   return ("The red-black tree is empty!");
      // else if (this instanceof SplayTree)
      //   return ("The splay tree is empty!");
      // else if (this instanceof BinaryMinHeap)
      //   return ("The binary min heap is empty!");
      // else if (this instanceof BinaryMaxHeap)
      //   return ("The binary max heap is empty!");
      else
        return ("The data structure is empty!");
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
