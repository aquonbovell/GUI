public class Stack {
  private Node _head;

  public Stack() {
    _head = null;
  }

  public void push(int number) {
    Node current = _head;
    _head = new Node(number);
    _head.setNext(current);
  }

  public String pop() {
    if (_head == null) {
      return ("The stack is empty.");
    }
    int result = _head.getValue();
    _head = _head.getNext();
    return (String.format("Popped %d from the stack.", result));
  }

  public String peek() {
    if (_head == null) {
      return ("The stack is empty.");
    }
    return (String.format("Peeked %d from the stack.", _head.getValue()));
  }

  public boolean isEmpty() {
    if (_head == null) {
      return (true);
    }
    return (false);
  }

  public String showNodes() {
    if (_head == null) {
      return ("The stack is empty.");
    } else {
      String result = "";
      Node current;
      for (current = _head; current != null; current = current.getNext()) {
        result += (current.getValue() + ", ");
      }
      return result;
    }
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

  public int getHead() {
    return _head.getValue();
  }

  public int getTail() {
    Node current;
    for (current = _head; current.getNext() != null; current = current.getNext())
      ;
    return current.getValue();
  }

  public boolean deleteNode(int key) {
    if (_head == null) {
      return false;
    } else if (_head.getValue() == key && _head.getNext() == null) {
      _head = null;
      return true;
    } else if (_head.getValue() == key) {
      _head = _head.getNext();
      return true;
    } else {
      Node current;
      Node previous = _head;
      for (current = _head.getNext(); current.getNext() != null;) {
        if (current.getValue() == key) {
          previous.setNext(current.getNext());
          return true;
        } else {
          current = current.getNext();
          previous = previous.getNext();
        }
      }
      if (current.getValue() == key) {
        previous.setNext(null);
        return true;
      }
      return false;
    }
  }

  public void purge() {
    _head = null;
  }

}
