public class PriortyQueue {
  private Node _head;

  public PriortyQueue() {
    _head = null;
  }

  public void insert(int number) {
    if (_head == null) {
      _head = new Node(number);

    } else if (_head.getValue() > number) {
      Node current = _head;
      _head = new Node(number);
      _head.setNext(current);
    } else {
      Node current;
      for (current = _head; current.getNext() != null
          && current.getNext().getValue() <= number; current = current.getNext())
        ;

      Node newNode = new Node(number);
      newNode.setNext(current.getNext());
      current.setNext(newNode);
    }
  }

  public String dequeue() {
    if (_head == null) {
      return ("The priorty queue is empty.");
    } else {
      int result = _head.getValue();
      _head = _head.getNext();
      return (String.format("Dequeued %d from the priorty queue.", result));
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
      return ("The priorty queue is empty.");
    } else {
      String result = "";
      Node current;
      for (current = _head; current != null; current = current.getNext()) {
        result += (current.getValue() + ", ");
      }
      return result;
    }
  }

  public int size() {
    if (_head == null) {
      return (0);
    } else {
      int result = 0;
      Node current;
      for (current = _head; current != null; current = current.getNext()) {
        result++;
      }
      return result;
    }
  }

  public String getHead() {
    if (_head == null) {
      return ("The priorty queue is empty.");
    }
    return (String.format("The head of the priorty queue is %d.", _head.getValue()));
  }

  public String getTail() {
    if (_head == null) {
      return ("The priorty queue is empty.");
    }
    Node current;
    for (current = _head; current.getNext() != null; current = current.getNext())
      ;
    return (String.format("The tail of the priorty queue is %d.", current.getValue()));
  }
}
