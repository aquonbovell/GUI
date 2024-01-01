public class LinkedList extends ALinearADT {
  private Node _head;

  public LinkedList() {
    _head = null;
  }

  @Override
  public String add(int number) {
    try {
      if (_head == null) {
        _head = new Node(number);
        return (String.format("Added %d to the linked list.", number));
      } else {
        Node current;
        for (current = _head; current.getNext() != null; current = current.getNext())
          ;
        current.setNext(new Node(number));
        return (String.format("Added %d to the linked list.", number));
      }
    } catch (Exception e) {
      return (String.format("Could not add %d to the linked list.\n%s", number, e.getMessage()));
    }
  }

  @Override
  public String remove(int value) {
    try {
      if (_head == null) {
        return (String.format("This linked list is empty."));
      } else if (_head.getValue() == value) {
        _head = _head.getNext();
        return (String.format("Removed %d from the linked list.", value));
      } else {
        Node current;
        Node previous;
        previous = _head;
        for (current = previous.getNext(); current != null && current.getValue() != value;) {
          current = current.getNext();
          previous = previous.getNext();
        }
        if (current == null) {
          return (String.format("Could not find %d in the linked list.", value));
        } else {
          int result = current.getValue();
          previous.setNext(current.getNext());
          return (String.format("Removed %d from the linked list.", result));
        }
      }
    } catch (Exception e) {
      return (String.format("Could not remove %d from the linked list.\n%s", value, e.getMessage()));
    }
  }

  @Override
  public String remove() {
    throw new UnsupportedOperationException("LinkedList does not support remove().");
  }

  @Override
  public String contains(int key) {
    try {
      if (_head == null) {
        return (String.format("This linked list is empty."));
      } else if (_head.getValue() == key) {
        return (String.format("The linked list contains %d.", key));
      } else {
        Node current;
        for (current = _head; current != null; current = current.getNext()) {
          if (current.getValue() == key) {
            return (String.format("The linked list contains %d.", key));
          }
        }
        return (String.format("The linked list does not contain %d.", key));
      }
    } catch (Exception e) {
      return (String.format("Could not determine if the linked list contains %d.\n%s", key, e.getMessage()));
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
      return count;
    } catch (Exception e) {
      return (-1);
    }
  }

  @Override
  public String isEmpty() {
    try {
      if (_head == null) {
        return ("This linked list is empty.");
      } else {
        return ("This linked list is not empty.");
      }
    } catch (Exception e) {
      return (String.format("Could not determine if the linked list is empty.\n%s", e.getMessage()));
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
      Node current;
      int i;
      for (current = _head, i = 0; current != null; current = current.getNext(), i++) {
        result[i] = current.getValue();
      }
      return result;
    } catch (Exception e) {
      return (new int[0]);
    }
  }

  @Override
  public String toString() {
    if (_head == null) {
      return ("This linked list is empty.");
    } else {
      String result = "";
      Node current;
      for (current = _head; current != null; current = current.getNext()) {
        result += String.format("%d, ", current.getValue());
      }
      return result;
    }
  }

}
