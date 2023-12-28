public class LinkedList {
  private Node _head;

  public LinkedList() {
    _head = null;
  }

  public void addToBeginning(int number) {
    Node current = _head;
    _head = new Node(number);
    _head.setNext(current);
  }

  public void addToEnd(int number) {
    if (_head == null) {
      _head = new Node(number);
    } else {
      Node current;
      for (current = _head; current.getNext() != null; current = current.getNext())
        ;
      current.setNext(new Node(number));
    }
  }

  public String deleteNode(int value) {
    Node current;
    Node previous;
    if (_head == null) {
      return ("This list is empty.");
    } else if (_head.getValue() == value) {
      _head = _head.getNext();
      return ("Deleted " + value + " from the list.");
    } else {
      previous = _head;
      for (current = previous.getNext(); current != null && current.getValue() != value;) {
        current = current.getNext();
        previous = previous.getNext();
      }
      if (current == null) {
        return ("Could not find " + value + " is this list");
      } else {
        int result = current.getValue();
        previous.setNext(current.getNext());
        return ("Deleted " + result + " from the list.");
      }
    }
  }

  public int get_Head() {
    if (_head != null) {
      return _head.getValue();
    }
    throw new IllegalStateException("The list is empty.");
  }

  public int getTail() {
    if (_head == null) {
      throw new IllegalStateException("The list is empty.");
    }
    Node current;
    for (current = _head; current.getNext() != null; current = current.getNext())
      ;
    return current.getValue();
  }

  public boolean find(int key) {
    if (_head == null) {
      return false;
    } else if (_head.getValue() == key) {
      return true;
    } else {
      Node current;
      for (current = _head; current != null; current = current.getNext()) {
        if (current.getValue() == key) {
          return true;
        }
      }
      return false;
    }
  }

  // public void showNodes() {
  //   if (_head == null) {
  //     System.out.println("This list is empty.");
  //   } else {
  //     Node current;
  //     for (current = _head; current != null; current = current.getNext()) {
  //       System.out.print(current.getValue() + ", ");
  //     }
  //     System.out.println("");
  //   }
  // }

  
  public String showNodes() {
    if (_head == null) {
      return ("This list is empty.");
    } else {
      String result = "";
      Node current;
      for (current = _head; current != null; current = current.getNext()) {
        result +=(current.getValue() + ", ");
      }
      return result;
    }
  }

  public boolean isEmpty() {
    return _head == null;
  }

  public int size() {
    int count = 0;
    Node current;
    for (current = _head; current != null; current = current.getNext()) {
      count++;
    }
    return count;
  }

  public void clear() {
    _head = null;
  }
}
