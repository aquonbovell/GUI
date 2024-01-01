public class Queue extends ALinearADT {
  private Node _head;

  public Queue() {
    _head = null;
  }

  @Override
  public String add(int number) {
    try {
      if (_head == null) {
        _head = new Node(number);
        return (String.format("Added %d to the queue.", number));
      } else {
        Node current;
        for (current = _head; current.getNext() != null; current = current.getNext())
          ;
        current.setNext(new Node(number));
        return (String.format("Added %d to the queue.", number));
      }
    } catch (Exception e) {
      return (String.format("Could not add %d to the queue.\n%s", number, e.getMessage()));
    }
  }

  @Override
  public String remove(int number) {
    throw new UnsupportedOperationException("Queue does not support remove(int key).");
  }

  @Override
  public String remove() {
    try {
      if (_head == null) {
        return ("The queue is empty.");
      } else {
        int value = _head.getValue();
        _head = _head.getNext();
        return (String.format("Dequeued %d from the queue.", value));
      }
    } catch (Exception e) {
      return (String.format("Could not dequeue from the queue.\n%s", e.getMessage()));
    }

  }

  @Override
  public String contains(int key) {
    try {
      if (_head == null) {
        return ("The queue is empty.");
      }
      Node current;
      for (current = _head; current != null; current = current.getNext()) {
        if (current.getValue() == key) {
          return (String.format("The queue contains %d.", key));
        }
      }
      return (String.format("The queue does not contain %d.", key));

    } catch (Exception e) {
      return (String.format("Could not check if the queue contains %d.\n%s", key, e.getMessage()));
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
        return ("The queue is empty.");
      } else {
        return ("The queue is not empty.");
      }
    } catch (Exception e) {
      return (String.format("Could not check if the queue is empty.\n%s", e.getMessage()));
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
      result += String.format("%d ", current.getValue());
    }
    return (result);
  }
}
