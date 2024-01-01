public class CircularLinkedList extends ALinearADT {
  private Node _head;

  public CircularLinkedList() {
    _head = null;
  }

  @Override
  public String add(int number) {
    try {
      if (_head == null) {
        _head = new Node(number);
        _head.setNext(_head);
        return (String.format("Added %d to the circular linked list.", number));
      } else {
        Node current;
        for (current = _head; current.getNext() != _head; current = current.getNext())
          ;
        current.setNext(new Node(number));
        current.getNext().setNext(_head);
        return (String.format("Added %d to the circular linked list.", number));
      }
    } catch (Exception e) {
      return (String.format("Could not add %d to the circular linked list.\n%s", number, e.getMessage()));
    }
  }

  @Override
  public String remove(int value) {
    Node current;
    Node previous;
    try {
      if (_head == null) {
        return (String.format("This circular linked list is empty."));
      } else if (_head.getValue() == value && _head.getNext() == _head) {
        _head = null;
        return (String.format("Removed %d from the circular linked list.", value));
      } else if (_head.getValue() == value) {
        for (current = _head; current.getNext() != _head; current = current.getNext())
          ;
        _head = _head.getNext();
        current.setNext(_head);
        return (String.format("Removed %d from the circular linked list.", value));
      } else {
        previous = _head;
        for (current = _head.getNext(); current != _head && current.getValue() != value;) {
          current = current.getNext();
          previous = previous.getNext();
        }
        if (current == _head) {
          return (String.format("Could not find %d in the circular linked list.", value));
        } else {
          previous.setNext(current.getNext());
          return (String.format("Removed %d from the circular linked list.", value));
        }
      }
    } catch (Exception e) {
      return (String.format("Could not remove %d from the circular linked list.\n%s", value, e.getMessage()));
    }
  }

  @Override
  public String remove(){
    throw new UnsupportedOperationException("CircularLinkedList does not support remove().");
  }

  @Override
  public String contains(int key) {
    try {
      if (_head == null) {
        return (String.format("This circular linked list is empty."));
      } else {
        Node current;
        for (current = _head; current != _head; current = current.getNext()) {
          if (current.getValue() == key) {
            return (String.format("The circular linked list contains %d.", key));
          }
        }
        return (String.format("The circular linked list does not contain %d.", key));
      }
    } catch (Exception e) {
      return (String.format("Could not determine if the circular linked list contains %d.\n%s", key, e.getMessage()));
    }
  }

  @Override
  public int size() {
    try {
      int count = 0;
      Node current;
      for (current = _head.getNext(); current != _head; current = current.getNext()) {
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
        return ("The circular linked list is empty.");
      } else {
        return ("The circular linked list is not empty.");
      }
    } catch (Exception e) {
      return (String.format("Could not determine if the circular linked list is empty.\n%s", e.getMessage()));
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
      for (current = _head; current != _head; current = current.getNext()) {
        result[index++] = current.getValue();
      }
      return result;
    } catch (Exception e) {
      return (new int[0]);
    }
  }

  @Override
  public String toString() {
    if (_head == null) {
      return ("This circular linked list is empty.");
    }
    String result = "";
    Node current;
    for (current = _head; current != _head; current = current.getNext()) {
      result += String.format("%d, ", current.getValue());
    }
    return result;
  }
}
