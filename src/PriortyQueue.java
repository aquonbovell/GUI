public class PriortyQueue extends ALinearADT {
  private Node _head;

  public PriortyQueue() {
    _head = null;
  }

  @Override
  public String add(int number) {
    try {
      if (_head == null) {
        _head = new Node(number);
        return (String.format("Added %d to the priorty queue.", number));
      } else if (_head.getValue() > number) {
        Node current = _head;
        _head = new Node(number);
        _head.setNext(current);
        return (String.format("Added %d to the priorty queue.", number));
      } else {
        Node current;
        for (current = _head; current.getNext() != null
            && current.getNext().getValue() <= number; current = current.getNext())
          ;

        Node newNode = new Node(number);
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        return (String.format("Added %d to the priorty queue.", number));
      }

    } catch (Exception e) {
      return (String.format("Could not add %d to the priorty queue.\n%s", number, e.getMessage()));
    }
  }

  @Override
  public String remove(int number) {
    throw new UnsupportedOperationException("PriortyQueue does not support remove(int key).");
  }

  @Override
  public String remove() {
    try {
      if (_head == null) {
        return ("The priorty queue is empty.");
      } else {
        int result = _head.getValue();
        _head = _head.getNext();
        return (String.format("Dequeued %d from the priorty queue.", result));
      }
    } catch (Exception e) {
      return (String.format("Could not dequeue from the priorty queue.\n%s", e.getMessage()));
    }
  }

  @Override
  public String contains(int number) {
    try {
      if (_head == null) {
        return ("The priorty queue is empty.");
      } else {
        Node current;
        for (current = _head; current != null; current = current.getNext()) {
          if (current.getValue() == number) {
            return (String.format("The priorty queue contains %d.", number));
          }
        }
        return (String.format("The priorty queue does not contain %d.", number));
      }
    } catch (Exception e) {
      return (String.format("Could not check if the priorty queue contains %d.\n%s", number, e.getMessage()));
    }
  }

  @Override
  public int size() {
    try {
      int result = 0;
      Node current;
      for (current = _head; current != null; current = current.getNext()) {
        result++;
      }
      return result;
    } catch (Exception e) {
      return (-1);
    }
  }

  @Override
  public String isEmpty() {
    try {
      if (_head == null) {
        return ("The priorty queue is empty.");
      } else {
        return ("The priorty queue is not empty.");
      }
    } catch (Exception e) {
      return (String.format("Could not check if the priorty queue is empty.\n%s", e.getMessage()));
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
    String result = "";
    Node current;
    for (current = _head; current != null; current = current.getNext()) {
      result += String.format("%d ", current.getValue());
    }
    return result;
  }

}
