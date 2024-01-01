public class Stack extends ALinearADT {
  private Node _head;

  public Stack() {
    _head = null;
  }

  @Override
  public String add(int number) {
    try {
      Node current = _head;
      _head = new Node(number);
      _head.setNext(current);
      return (String.format("Added %d to the stack.", number));
    } catch (Exception e) {
      return (String.format("Could not add %d to the stack.\n%s", number, e.getMessage()));
    }
  }

  @Override
  public String remove(int key) {
    throw new UnsupportedOperationException("Stack does not support remove(int key).");
  }

  @Override
  public String remove() {
    try {
      if (_head == null) {
        return ("The stack is empty.");
      }
      int result = _head.getValue();
      _head = _head.getNext();
      return (String.format("Popped %d from the stack.", result));
    } catch (Exception e) {
      return (String.format("Could not pop from the stack.\n%s", e.getMessage()));
    }
  }

  @Override
  public String contains(int key) {
    try {
      if (_head == null) {
        return ("The stack is empty.");
      }
      Node current;
      for (current = _head; current != null; current = current.getNext()) {
        if (current.getValue() == key) {
          return (String.format("The stack contains %d.", key));
        }
      }
      return (String.format("The stack does not contain %d.", key));

    } catch (Exception e) {
      return (String.format("Could not check if the stack contains %d.\n%s", key, e.getMessage()));
    }
  }

  @Override
  public int size() {
    try {
      int size = 0;
      Node current;
      for (current = _head; current != null; current = current.getNext()) {
        size++;
      }
      return (size);
    } catch (Exception e) {
      return (-1);
    }
  }

  @Override
  public String isEmpty() {
    try {
      if (_head == null) {
        return ("The stack is empty.");
      }
      return ("The stack is not empty.");
    } catch (Exception e) {
      return (String.format("Could not check if the stack is empty.\n%s", e.getMessage()));
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
    String result = "";
    Node current;
    for (current = _head; current != null; current = current.getNext()) {
      result += String.format("%d, ", current.getValue());
    }
    return (result);
  }

  public String peek() {
    try {
      if (_head == null) {
        return ("The stack is empty.");
      }
      return (String.format("Peeked %d from the stack.", _head.getValue()));
    } catch (Exception e) {
      return (String.format("Could not peek from the stack.\n%s", e.getMessage()));
    }
  }

}
