public class Queue {
  private Node _head;

  public Queue() {
    _head = null;
  }

  public void enqueue(int number) {
    if (_head == null) {
      _head = new Node(number);
    } else {
      Node current;
      for (current = _head; current.getNext() != null; current = current.getNext())
        ;
      current.setNext(new Node(number));
    }
  }

  public String dequeue() {
    if (_head == null) {
      return ("The queue is empty.");
    } else {
      int value = _head.getValue();
      _head = _head.getNext();
      return (String.format("Dequeued %d from the queue.", value));
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
      return ("The queue is empty.");
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
}
