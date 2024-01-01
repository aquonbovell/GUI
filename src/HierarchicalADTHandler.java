import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class HierarchicalADTHandler {
  private GUI gui;
  private AHierarchicalADT binaryTree;
  private AHierarchicalADT binarySearchTree;
  private AHierarchicalADT avlTree;
  private AHierarchicalADT rbTree;
  private AHierarchicalADT splayTree;
  private AHierarchicalADT binaryMinHeap;

  HierarchicalADTHandler(GUI object) {
    gui = object;
    binaryTree = new BinaryTree();
    binarySearchTree = new BinarySearchTree();
  }

  public JMenu createHierarchicalADTOptions() {
    JMenu hierarchialADT = new JMenu("Hierarchial ADTs");
    hierarchialADT.add(createOptions(binaryTree, "Binary Tree"));
    hierarchialADT.add(createOptions(binarySearchTree, "Binary Search Tree"));
    return hierarchialADT;
  }

  private JMenu createOptions(AHierarchicalADT object, String menuTitle) {
    JMenu linkedListMenu = new JMenu(menuTitle);
    JMenuItem load = new JMenuItem("Load");
    JMenuItem add = new JMenuItem("Add");
    JMenuItem remove = new JMenuItem("Remove");
    JMenuItem search = new JMenuItem("Search");
    JMenuItem levelOrder = new JMenuItem("LevelOrder");
    JMenuItem preOrder = new JMenuItem("PreOrder");
    JMenuItem inOrder = new JMenuItem("InOrder");
    JMenuItem postOrder = new JMenuItem("PostOrder");
    linkedListMenu.add(load);
    linkedListMenu.add(add);
    linkedListMenu.add(remove);
    linkedListMenu.add(search);
    linkedListMenu.add(levelOrder);
    linkedListMenu.add(preOrder);
    linkedListMenu.add(inOrder);
    linkedListMenu.add(postOrder);
    load.addActionListener(e -> load(object));
    add.addActionListener(e -> add(object));
    remove.addActionListener(e -> remove(object));
    search.addActionListener(e -> search(object));
    levelOrder.addActionListener(e -> levelOrder(object));
    preOrder.addActionListener(e -> preOrder(object));
    inOrder.addActionListener(e -> inOrder(object));
    postOrder.addActionListener(e -> postOrder(object));
    return linkedListMenu;
  }

  private void load(AHierarchicalADT object) {
    if (gui.filePath.getText().length() < 1) {
      JOptionPane.showMessageDialog(gui.frame, "Please select a file to open.", "Error",
          JOptionPane.ERROR_MESSAGE);
    } else {
      try {
        List<String> lines = Files.readAllLines(Paths.get(gui.filePath.getText()));
        gui.editBox.setText(""); // Clearing the text area before loading the file content
        object.purge();
        for (String line : lines) {
          object.insert(Integer.parseInt(line));
        }
        gui.editBox.setText("Loaded!");
      } catch (Exception ex) {
        ex.printStackTrace(); // Handling exceptions by printing the stack trace
      }
    }
  }

  private void add(AHierarchicalADT object) {
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
            gui.editBox.setText(object.insert(Integer.parseInt(result)));
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

  private void remove(AHierarchicalADT object) {
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

  private void search(AHierarchicalADT object) {
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

  private void levelOrder(AHierarchicalADT object) {
    try {
      gui.editBox.setText(object.levelOrder());
    } catch (Exception ex) {
      ex.printStackTrace(); // Handling exceptions by printing the stack trace
    }
  }

  private void preOrder(AHierarchicalADT object) {
    try {
      gui.editBox.setText(object.preOrder());
    } catch (Exception ex) {
      ex.printStackTrace(); // Handling exceptions by printing the stack trace
    }
  }

  private void inOrder(AHierarchicalADT object) {
    try {
      gui.editBox.setText(object.inOrder());
    } catch (Exception ex) {
      ex.printStackTrace(); // Handling exceptions by printing the stack trace
    }
  }

  private void postOrder(AHierarchicalADT object) {
    try {
      gui.editBox.setText(object.postOrder());
    } catch (Exception ex) {
      ex.printStackTrace(); // Handling exceptions by printing the stack trace
    }
  }
}
