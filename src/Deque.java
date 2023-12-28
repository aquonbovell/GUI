public class Deque {
  private Node _head;

  public Deque() {
    _head = null;
  }

  public void insertFront(int number) {
    if (_head == null) {
      _head = new Node(number);

    } else {
      Node current = _head;
      _head = new Node(number);
      _head.setNext(current);
    }
  }

  public void insertBack(int number) {
    if (_head == null) {
      _head = new Node(number);

    } else {
      Node current;
      for (current = _head; current.getNext() != null; current = current.getNext())
        ;

      Node newNode = new Node(number);
      current.setNext(newNode);
    }
  }

  public String removeFront() {
    if (_head == null) {
      return ("The deque is empty.");
    } else {
      int result = _head.getValue();
      _head = _head.getNext();
      return (String.format("Removed %d from the front of the deque.", result));
    }

  }

  public String removeBack() {
    if (_head == null) {
      return ("The deque is empty.");
    } else if (_head.getNext() == null) {
      int result = _head.getValue();
      _head = null;
      return (String.format("Removed %d from the back of the deque.", result));
    } else {
      Node current;
      Node previous = _head;
      for (current = _head; current.getNext() != null; current = current.getNext()) {
        previous = current;
      }
      int result = current.getValue();
      previous.setNext(null);
      return (String.format("Removed %d from the back of the deque.", result));
    }
  }

  public boolean find(int number) {
    if (_head == null) {
      return false;
    } else {
      Node current;
      for (current = _head; current != null; current = current.getNext()) {
        if (current.getValue() == number) {
          return true;
        }
      }
      return false;
    }
  }

  public void purge() {
    _head = null;
  }

  public boolean isEmpty() {
    if (_head == null) {
      return (true);
    }
    return (false);
  }

  public String showNodes() {
    if (_head == null) {
      return ("The deque is empty.");
    } else {
      String result = "";
      Node current;
      for (current = _head; current != null; current = current.getNext()) {
        result += (current.getValue() + ", ");
      }
      return (result);
    }
  }

  public String getHead() {
    if (_head == null) {
      return ("The deque is empty.");
    } else {
      return (String.format("The head of the deque is %d.", _head.getValue()));
    }
  }

  public String getTail() {
    if (_head == null) {
      return ("The deque is empty.");
    } else {
      Node current;
      for (current = _head; current.getNext() != null; current = current.getNext())
        ;
      return (String.format("The tail of the deque is %d.", current.getValue()));
    }
  }
}
