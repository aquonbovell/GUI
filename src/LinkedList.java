public class LinkedList {
  private Node head;

  public LinkedList() {
    head = null;
  }

  public void addToBeginning(int number) {
    Node current = head;
    head = new Node(number);
    head.setNext(current);
  }

  public void addToEnd(int number) {
    if (head == null) {
      head = new Node(number);
    } else {
      Node current;
      for (current = head; current.getNext() != null; current = current.getNext())
        ;
      current.setNext(new Node(number));
    }
  }

  public void deleteNode(int value) {
    Node current;
    Node previous;
    if (head == null) {
      return;
    } else if (head.getValue() == value) {
      head = head.getNext();
      return;
    } else {
      previous = head;
      for (current = previous.getNext(); current != null && current.getValue() != value;) {
        current = current.getNext();
        previous = previous.getNext();
      }
      if (current == null) {
        System.out.println("Could not find " + value + " is this list");
      } else {
        previous.setNext(current.getNext());
      }
    }
  }

  public int getHead() {
    if (head != null) {
      return head.getValue();
    }
    throw new IllegalStateException("The list is empty.");
  }

  public int getTail() {
    if (head == null) {
      throw new IllegalStateException("The list is empty.");
    }
    Node current;
    for (current = head; current.getNext() != null; current = current.getNext())
      ;
    return current.getValue();
  }

  public boolean find(int key) {
    if (head == null) {
      return false;
    } else if (head.getValue() == key) {
      return true;
    } else {
      Node current;
      for (current = head; current != null; current = current.getNext()) {
        if (current.getValue() == key) {
          return true;
        }
      }
      return false;
    }
  }

  public void showNodes() {
    if (head == null) {
      System.out.println("This list is empty.");
    } else {
      Node current;
      for (current = head; current != null; current = current.getNext()) {
        System.out.print(current.getValue() + ", ");
      }
      System.out.println("");
    }
  }

  public boolean isEmpty() {
    return head == null;
  }
}
