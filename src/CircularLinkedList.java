public class CircularLinkedList {
  private Node _head;

  public CircularLinkedList() {
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
      _head.setNext(_head);
    } else {
      Node current;
      for (current = _head; current.getNext() != _head; current = current.getNext())
        ;
      current.setNext(new Node(number));
      current.getNext().setNext(_head);
    }
  }

  public boolean deleteNode(int value) {
    Node current;
    Node previous;
    if (_head == null) {
      return false;
    } else if (_head.getValue() == value && _head.getNext() == _head) {
      _head = null;
      return true;
    } else if (_head.getValue() == value) {
      for (current = _head; current.getNext() != _head; current = current.getNext())
        ;
      _head = _head.getNext();
      current.setNext(_head);
      return true;
    } else {
      previous = _head;
      for (current = _head.getNext(); current != _head && current.getValue() != value;) {
        current = current.getNext();
        previous = previous.getNext();
      }
      if (current == _head) {
        return false;
      } else {
        previous.setNext(current.getNext());
        return true;
      }
    }
  }

  public int get_Head() {
    return _head.getValue();
  }

  public int getTail() {
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
  // if (_head == null) {
  // System.out.println("This list is empty.");
  // } else {
  // Node current;
  // System.out.print(_head.getValue() + ", ");
  // for (current = _head.getNext(); current != _head; current = current.getNext())
  // {
  // System.out.print(current.getValue() + ", ");
  // }
  // System.out.println("");
  // }
  // }

  public String showNodes() {
    if (_head == null) {
      return ("This list is empty.");
    } else {
      Node current;
      String result = "";
      result += (_head.getValue() + ", ");
      for (current = _head.getNext(); current != _head; current = current.getNext()) {
        result += (current.getValue() + ", ");
      }
      return result;
    }
  }

  public boolean isEmpty() {
    return _head == null;
  }

  public int size() {
    if (_head == null) {
      return 0;
    } else {
      int count = 1;
      Node current;
      for (current = _head.getNext(); current != _head; current = current.getNext()) {
        count++;
      }
      return count;
    }
  }

  public void clear() {
    _head = null;
  }
}
