import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class LinearADTHandler {
  private GUI gui;
  private ALinearADT linkedList;
  private ALinearADT circularLinkedList;
  private ALinearADT stack;
  private ALinearADT queue;
  private ALinearADT deque;
  private ALinearADT priortyQueue;

  LinearADTHandler(GUI object) {
    gui = object;
    linkedList = new LinkedList();
    circularLinkedList = new CircularLinkedList();
    stack = new Stack();
    queue = new Queue();
    deque = new Deque();
    priortyQueue = new PriortyQueue();
  }

  public JMenu createLinearADTOptions() {
    JMenu linearADT = new JMenu("Linear ADT");
    linearADT.add(createOptions(linkedList, "Linked List"));
    linearADT.add(createOptions(circularLinkedList, "Circular Linked List"));
    linearADT.add(createOptions(stack, "Stack"));
    linearADT.add(createOptions(queue, "Queue"));
    linearADT.add(createOptions(deque, "Deque"));
    linearADT.add(createOptions(priortyQueue, "Priorty Queue"));
    return linearADT;
  }

  private JMenu createOptions(ALinearADT object, String menuTitle) {
    JMenu linkedListMenu = new JMenu(menuTitle);
    JMenuItem load = new JMenuItem("Load");
    JMenuItem add = new JMenuItem("Add");
    JMenuItem remove = new JMenuItem("Remove");
    JMenuItem search = new JMenuItem("Search");
    JMenuItem display = new JMenuItem("Display");
    linkedListMenu.add(load);
    linkedListMenu.add(add);
    linkedListMenu.add(remove);
    linkedListMenu.add(search);
    linkedListMenu.add(display);
    load.addActionListener(e -> load(object));
    add.addActionListener(e -> add(object));
    if (object instanceof Deque || object instanceof PriortyQueue || object instanceof Queue
        || object instanceof Stack) {
      remove.addActionListener(e -> removeNoArgs(object));
    } else {
      remove.addActionListener(e -> remove(object));
    }
    search.addActionListener(e -> search(object));
    display.addActionListener(e -> display(object));
    return linkedListMenu;
  }

  private void load(ALinearADT object) {
    if (gui.filePath.getText().length() < 1) {
      JOptionPane.showMessageDialog(gui, "Please select a file to open.", "Error",
          JOptionPane.ERROR_MESSAGE);
    } else {
      try {
        List<String> lines = Files.readAllLines(Paths.get(gui.filePath.getText()));
        gui.editBox.setText(""); // Clearing the text area before loading the file content
        object.purge();
        for (String line : lines) {
          object.add(Integer.parseInt(line));
        }
        gui.editBox.setText("Loaded!");
      } catch (Exception ex) {
        ex.printStackTrace(); // Handling exceptions by printing the stack trace
      }
    }
  }

  private void add(ALinearADT object) {
    boolean validInput = false;

    while (!validInput) {
      JTextField inputField = new JTextField();
      Object[] message = { "Please enter a number to add:", inputField };

      int option = JOptionPane.showConfirmDialog(
          null,
          message,
          "Input",
          JOptionPane.OK_CANCEL_OPTION,
          JOptionPane.QUESTION_MESSAGE);

      if (option == JOptionPane.OK_OPTION) {
        String result = inputField.getText().trim();

        if (!result.isEmpty()) {
          try {
            gui.editBox.setText(object.add(Integer.parseInt(result)));
            validInput = true;
          } catch (NumberFormatException ex) {
            ex.printStackTrace();
            // Handle invalid input format (e.g., if the input is not a valid integer)
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid integer.");
          }
        } else {
          // Handle the case where the user provided an empty string
          JOptionPane.showMessageDialog(null, "No input provided. Please enter a number.");
        }
      } else {
        // Handle the case where the user pressed "Cancel"
        validInput = true;
      }
    }
  }

  private void remove(ALinearADT object) {
    boolean validInput = false;

    while (!validInput) {
      JTextField inputField = new JTextField();
      Object[] message = { "Please enter a number to add:", inputField };

      int option = JOptionPane.showConfirmDialog(
          null,
          message,
          "Input",
          JOptionPane.OK_CANCEL_OPTION,
          JOptionPane.QUESTION_MESSAGE);

      if (option == JOptionPane.OK_OPTION) {
        String result = inputField.getText().trim();

        if (!result.isEmpty()) {
          try {
            gui.editBox.setText(object.remove(Integer.parseInt(result)));
            validInput = true;
          } catch (NumberFormatException ex) {
            ex.printStackTrace();
            // Handle invalid input format (e.g., if the input is not a valid integer)
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid integer.");
          }
        } else {
          // Handle the case where the user provided an empty string
          JOptionPane.showMessageDialog(null, "No input provided. Please enter a number.");
        }
      } else {
        // Handle the case where the user pressed "Cancel"
        validInput = true;
      }
    }
  }

  private void removeNoArgs(ALinearADT object) {
    try {
      gui.editBox.setText(object.remove());
    } catch (Exception ex) {
      ex.printStackTrace(); // Handling exceptions by printing the stack trace
    }
  }

  private void search(ALinearADT object) {
    boolean validInput = false;

    while (!validInput) {
      JTextField inputField = new JTextField();
      Object[] message = { "Please enter a number to add:", inputField };

      int option = JOptionPane.showConfirmDialog(
          null,
          message,
          "Input",
          JOptionPane.OK_CANCEL_OPTION,
          JOptionPane.QUESTION_MESSAGE);

      if (option == JOptionPane.OK_OPTION) {
        String result = inputField.getText().trim();

        if (!result.isEmpty()) {
          try {
            gui.editBox.setText(object.contains(Integer.parseInt(result)));
            validInput = true;
          } catch (NumberFormatException ex) {
            ex.printStackTrace();
            // Handle invalid input format (e.g., if the input is not a valid integer)
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid integer.");
          }
        } else {
          // Handle the case where the user provided an empty string
          JOptionPane.showMessageDialog(null, "No input provided. Please enter a number.");
        }
      } else {
        // Handle the case where the user pressed "Cancel"
        validInput = true;
      }
    }
  }

  private void display(ALinearADT object) {
    if (gui.editBox.getText().length() < 1) {
      JOptionPane.showMessageDialog(gui, "Please enter a number to display.", "Error",
          JOptionPane.ERROR_MESSAGE);
    } else {
      try {
        gui.editBox.setText(object.toString());
      } catch (Exception ex) {
        ex.printStackTrace(); // Handling exceptions by printing the stack trace
      }
    }
  }

}
