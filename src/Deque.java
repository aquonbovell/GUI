public class Deque extends ALinearADT {
  private Node _head;

  public Deque() {
    _head = null;
  }

  @Override
  public String add(int number) {
    return insertBack(number);
  }

  private String insertFront(int number) {
    try {
      if (_head == null) {
        _head = new Node(number);
        return (String.format("Added %d to the front of the deque.", number));

      } else {
        Node current = _head;
        _head = new Node(number);
        _head.setNext(current);
        return (String.format("Added %d to the front of the deque.", number));
      }
    } catch (Exception e) {
      return (String.format("Could not add %d to the front of the deque.\n%s", number, e.getMessage()));
    }
  }

  private String insertBack(int number) {
    try {
      if (_head == null) {
        _head = new Node(number);
        return (String.format("Added %d to the back of the deque.", number));

      } else {
        Node current;
        for (current = _head; current.getNext() != null; current = current.getNext())
          ;

        Node newNode = new Node(number);
        current.setNext(newNode);
        return (String.format("Added %d to the back of the deque.", number));
      }
    } catch (Exception e) {
      return (String.format("Could not add %d to the back of the deque.\n%s", number, e.getMessage()));
    }
  }

  @Override
  public String remove(int number) {
    throw new UnsupportedOperationException("Deque does not support remove(int key).");
  }

  @Override
  public String remove() {
    return removeFront();
  }

  private String removeFront() {
    try {
      if (_head == null) {
        return ("The deque is empty.");
      } else {
        int result = _head.getValue();
        _head = _head.getNext();
        return (String.format("Removed %d from the front of the deque.", result));
      }
    } catch (Exception e) {
      return (String.format("Could not remove from the front of the deque.\n%s", e.getMessage()));
    }
  }

  private String removeBack() {
    try {
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
    } catch (Exception e) {
      return (String.format("Could not remove from the back of the deque.\n%s", e.getMessage()));
    }
  }

  @Override
  public String contains(int number) {
    try {
      if (_head == null) {
        return ("The deque is empty.");
      } else {
        Node current;
        for (current = _head; current != null; current = current.getNext()) {
          if (current.getValue() == number) {
            return (String.format("The deque contains %d.", number));
          }
        }
        return (String.format("The deque does not contain %d.", number));
      }
    } catch (Exception e) {
      return (String.format("Could not determine if the deque contains %d.\n%s", number, e.getMessage()));
    }
  }

  @Override
  public int size() {
    try {
      int count = 0;
      Node current;
      for (current = _head; current != null; current = current.getNext()) {
        count++;
      }
      return (count);
    } catch (Exception e) {
      return (-1);
    }
  }

  @Override
  public String isEmpty() {
    try {
      if (_head == null) {
        return ("The deque is empty.");
      } else {
        return ("The deque is not empty.");
      }
    } catch (Exception e) {
      return (String.format("Could not determine if the deque is empty.\n%s", e.getMessage()));
    }
  }

  @Override
  public void purge() {
    _head = null;
  }

  @Override
  public int[] toArray() {
    try {
      int[] result = new int[size()];
      int index = 0;
      Node current;
      for (current = _head; current != null; current = current.getNext()) {
        result[index++] = current.getValue();
      }
      return (result);
    } catch (Exception e) {
      return (new int[0]);
    }
  }

  @Override
  public String toString() {
    if (_head == null) {
      return ("The deque is empty.");
    } else {
      String result = "";
      Node current;
      for (current = _head; current != null; current = current.getNext()) {
        result += String.format("%d, ", current.getValue());
      }
      return (result);
    }
  }
}
