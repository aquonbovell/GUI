import java.awt.BorderLayout;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

public class GUI {
  // Declaring private member variables
  private JFrame frame;
  private JMenuBar menuBar;
  private JMenu linearADTs;
  private JMenu hierarchicalADTs;
  private JTextField filePath;
  private JLabel fileLabel;
  private JTextArea editBox;
  private LinkedList linkedList;
  private CircularLinkedList circularLinkedList;
  private Stack stack;
  private Queue queue;
  private Deque deque;
  private PriortyQueue priortyQueue;
  private BinaryTree binaryTree;
  private BinarySearchTree binarySearchTree;

  // Constructor to initialize the GUI with specified title, width, and height
  public GUI(String title, int width, int height) {
    // Initializing the JFrame and setting its properties
    linkedList = new LinkedList();
    circularLinkedList = new CircularLinkedList();
    stack = new Stack();
    queue = new Queue();
    deque = new Deque();
    priortyQueue = new PriortyQueue();
    binaryTree = new BinaryTree();
    binarySearchTree = new BinarySearchTree();

    frame = new JFrame(title);
    frame.setResizable(false);
    frame.setLayout(null); // Using null layout

    // Creating and setting up the menu bar
    menuBar = new JMenuBar();
    menuBar.add(createFileOptions());
    menuBar.add(linearADTs = new JMenu("Linear ADTs"));
    menuBar.add(hierarchicalADTs = new JMenu("Hierarchical ADTs"));
    linearADTs.add(createLinkedListOptions());
    linearADTs.add(createCircularLinkedListOptions());
    linearADTs.add(createStackOptions());
    linearADTs.add(createQueueOptions());
    linearADTs.add(createPriortyQueueOptions());
    linearADTs.add(createDequeOptions());
    hierarchicalADTs.add(createBinaryTreeOptions());
    hierarchicalADTs.add(createBinarySearchTreeOptions());
    frame.setJMenuBar(menuBar);

    // Creating components for file path display, file label, and text editing
    fileLabel = new JLabel("File Name:  ");
    fileLabel.setBounds(5, 0, 75, 20);

    filePath = new JTextField();
    filePath.setEditable(false);
    filePath.setCursor(null);
    fileLabel.setLabelFor(filePath);
    filePath.setBounds(80, 0, width - 150, 20);

    editBox = new JTextArea();
    editBox.setLineWrap(true);
    editBox.setWrapStyleWord(true);
    editBox.setTabSize(1);

    // Creating a scroll pane for the text area and setting its bounds
    JScrollPane scrollPane = new JScrollPane(editBox);
    scrollPane.setBounds(5, 30, width - 25, height - 100);

    // Creating a panel to contain the file label and file path field
    JPanel panel = new JPanel();
    panel.setBounds(5, 5, width - 25, 20);
    panel.setLayout(new BorderLayout());
    panel.add(fileLabel, BorderLayout.LINE_START);
    panel.add(filePath, 1);

    // Adding components to the frame
    frame.add(panel);
    frame.add(scrollPane);

    // Setting frame properties
    frame.setTitle(title);
    frame.setSize(width, height);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  // Method to set GUI visibility
  public void setVisible(boolean visible) {
    frame.setVisible(visible);
  }

  // Method to create file options in the menu
  private JMenu createFileOptions() {
    JMenu file = new JMenu("File");
    JMenuItem open = new JMenuItem("Open");
    JMenuItem display = new JMenuItem("Display");
    JMenuItem save = new JMenuItem("Save");
    JMenuItem saveAs = new JMenuItem("Save As");
    JMenuItem exit = new JMenuItem("Exit");
    file.add(open);
    file.add(display);
    file.add(save);
    file.add(saveAs);
    file.add(exit);
    open.addActionListener(e -> openFile());
    display.addActionListener(e -> displayFile());
    save.addActionListener(e -> saveFile());
    saveAs.addActionListener(e -> saveAsFile());
    exit.addActionListener(e -> exit());
    return file;
  }

  private JMenu createLinkedListOptions() {
    JMenu linkedList = new JMenu("Linked List");
    JMenuItem load = new JMenuItem("Load");
    JMenuItem add = new JMenuItem("Add");
    JMenuItem remove = new JMenuItem("Remove");
    JMenuItem search = new JMenuItem("Search");
    JMenuItem display = new JMenuItem("Display");
    linkedList.add(load);
    linkedList.add(add);
    linkedList.add(remove);
    linkedList.add(search);
    linkedList.add(display);
    load.addActionListener(e -> loadLinkedList());
    add.addActionListener(e -> addLinkedList());
    remove.addActionListener(e -> removeLinkedList());
    search.addActionListener(e -> searchLinkedList());
    display.addActionListener(e -> displayLinkedList());
    return linkedList;
  }

  private JMenu createCircularLinkedListOptions() {
    JMenu circularLinkedList = new JMenu("Circular Linked List");
    JMenuItem load = new JMenuItem("Load");
    JMenuItem add = new JMenuItem("Add");
    JMenuItem remove = new JMenuItem("Remove");
    JMenuItem search = new JMenuItem("Search");
    JMenuItem display = new JMenuItem("Display");
    circularLinkedList.add(load);
    circularLinkedList.add(add);
    circularLinkedList.add(remove);
    circularLinkedList.add(search);
    circularLinkedList.add(display);
    load.addActionListener(e -> loadCircularLinkedList());
    add.addActionListener(e -> addCircularLinkedList());
    remove.addActionListener(e -> removeCircularLinkedList());
    search.addActionListener(e -> searchCircularLinkedList());
    display.addActionListener(e -> displayCircularLinkedList());
    return circularLinkedList;
  }

  private JMenu createStackOptions() {
    JMenu stack = new JMenu("Stack");
    JMenuItem load = new JMenuItem("Load");
    JMenuItem push = new JMenuItem("Push");
    JMenuItem pop = new JMenuItem("Pop");
    JMenuItem peek = new JMenuItem("Peek");
    JMenuItem find = new JMenuItem("Search");
    JMenuItem isEmpty = new JMenuItem("isEmpty");
    JMenuItem display = new JMenuItem("Display");
    stack.add(load);
    stack.add(push);
    stack.add(pop);
    stack.add(peek);
    stack.add(find);
    stack.add(isEmpty);
    stack.add(display);
    load.addActionListener(e -> loadStack());
    push.addActionListener(e -> pushStack());
    pop.addActionListener(e -> popStack());
    peek.addActionListener(e -> peekStack());
    find.addActionListener(e -> findStack());
    isEmpty.addActionListener(e -> isEmptyStack());
    display.addActionListener(e -> displayStack());
    return stack;
  }

  private JMenu createQueueOptions() {
    JMenu queue = new JMenu("Queue");
    JMenuItem load = new JMenuItem("Load");
    JMenuItem enqueue = new JMenuItem("Enqueue");
    JMenuItem dequeue = new JMenuItem("Dequeue");
    JMenuItem find = new JMenuItem("Search");
    JMenuItem isEmpty = new JMenuItem("isEmpty");
    JMenuItem display = new JMenuItem("Display");
    queue.add(load);
    queue.add(enqueue);
    queue.add(dequeue);
    queue.add(find);
    queue.add(isEmpty);
    queue.add(display);
    load.addActionListener(e -> loadQueue());
    enqueue.addActionListener(e -> enqueueQueue());
    dequeue.addActionListener(e -> dequeueQueue());
    find.addActionListener(e -> findQueue());
    isEmpty.addActionListener(e -> isEmptyQueue());
    display.addActionListener(e -> displayQueue());
    return queue;
  }

  private JMenu createDequeOptions() {
    JMenu deque = new JMenu("Deque");
    JMenuItem load = new JMenuItem("Load");
    JMenuItem insertFront = new JMenuItem("Insert Front");
    JMenuItem insertBack = new JMenuItem("Insert Back");
    JMenuItem removeFront = new JMenuItem("Remove Front");
    JMenuItem removeBack = new JMenuItem("Remove Back");
    JMenuItem find = new JMenuItem("Search");
    JMenuItem isEmpty = new JMenuItem("isEmpty");
    JMenuItem display = new JMenuItem("Display");
    deque.add(load);
    deque.add(insertFront);
    deque.add(insertBack);
    deque.add(removeFront);
    deque.add(removeBack);
    deque.add(find);
    deque.add(isEmpty);
    deque.add(display);
    load.addActionListener(e -> loadDeque());
    insertFront.addActionListener(e -> insertFrontDeque());
    insertBack.addActionListener(e -> insertBackDeque());
    removeFront.addActionListener(e -> removeFrontDeque());
    removeBack.addActionListener(e -> removeBackDeque());
    find.addActionListener(e -> findDeque());
    isEmpty.addActionListener(e -> isEmptyDeque());
    display.addActionListener(e -> displayDeque());
    return deque;
  }

  private JMenu createPriortyQueueOptions() {
    JMenu priortyQueue = new JMenu("Priorty Queue");
    JMenuItem load = new JMenuItem("Load");
    JMenuItem insert = new JMenuItem("Insert");
    JMenuItem dequeue = new JMenuItem("Dequeue");
    JMenuItem find = new JMenuItem("Search");
    JMenuItem isEmpty = new JMenuItem("isEmpty");
    JMenuItem display = new JMenuItem("Display");
    priortyQueue.add(load);
    priortyQueue.add(insert);
    priortyQueue.add(dequeue);
    priortyQueue.add(find);
    priortyQueue.add(isEmpty);
    priortyQueue.add(display);
    load.addActionListener(e -> loadPriortyQueue());
    insert.addActionListener(e -> insertPriortyQueue());
    dequeue.addActionListener(e -> dequeuePriortyQueue());
    find.addActionListener(e -> findPriortyQueue());
    isEmpty.addActionListener(e -> isEmptyPriortyQueue());
    display.addActionListener(e -> displayPriortyQueue());
    return priortyQueue;
  }

  private JMenu createBinaryTreeOptions() {
    JMenu binaryTree = new JMenu("Binary Tree");
    JMenuItem load = new JMenuItem("Load");
    JMenuItem insert = new JMenuItem("Insert");
    JMenuItem remove = new JMenuItem("Remove");
    JMenuItem find = new JMenuItem("Search");
    JMenuItem inOrder = new JMenuItem("inOrder");
    JMenuItem preOrder = new JMenuItem("preOrder");
    JMenuItem postOrder = new JMenuItem("postOrder");
    binaryTree.add(load);
    binaryTree.add(insert);
    binaryTree.add(remove);
    binaryTree.add(find);
    binaryTree.add(inOrder);
    binaryTree.add(preOrder);
    binaryTree.add(postOrder);
    load.addActionListener(e -> loadBinaryTree());
    insert.addActionListener(e -> insertBinaryTree());
    remove.addActionListener(e -> removeBinaryTree());
    find.addActionListener(e -> findBinaryTree());
    inOrder.addActionListener(e -> inOrderBinaryTree());
    preOrder.addActionListener(e -> preOrderBinaryTree());
    postOrder.addActionListener(e -> postOrderBinaryTree());
    return binaryTree;
  }

  private JMenu createBinarySearchTreeOptions() {
    JMenu binarySearchTree = new JMenu("Binary Search Tree");
    JMenuItem load = new JMenuItem("Load");
    JMenuItem insert = new JMenuItem("Insert");
    JMenuItem remove = new JMenuItem("Remove");
    JMenuItem find = new JMenuItem("Search");
    JMenuItem inOrder = new JMenuItem("inOrder");
    JMenuItem preOrder = new JMenuItem("preOrder");
    JMenuItem postOrder = new JMenuItem("postOrder");
    binarySearchTree.add(load);
    binarySearchTree.add(insert);
    binarySearchTree.add(remove);
    binarySearchTree.add(find);
    binarySearchTree.add(inOrder);
    binarySearchTree.add(preOrder);
    binarySearchTree.add(postOrder);
    load.addActionListener(e -> loadBinarySearchTree());
    insert.addActionListener(e -> insertBinarySearchTree());
    remove.addActionListener(e -> removeBinarySearchTree());
    find.addActionListener(e -> findBinarySearchTree());
    inOrder.addActionListener(e -> inOrderBinarySearchTree());
    preOrder.addActionListener(e -> preOrderBinarySearchTree());
    postOrder.addActionListener(e -> postOrderBinarySearchTree());
    return binarySearchTree;
  }

  // Method to handle file opening
  private void openFile() {
    JFileChooser fileChooser = new JFileChooser("./");
    // Creating file filters for different file types
    FileFilter[] filters = createFileFilters(".txt", "Text Files (*.txt)", ".csv", "CSV Files (*.csv)", ".dat",
        "DAT Files (*.dat)");
    for (FileFilter filter : filters) {
      fileChooser.addChoosableFileFilter(filter);
    }
    // Opening the file chooser dialog
    if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
      String fileName = fileChooser.getSelectedFile().getAbsolutePath();
      filePath.setText(fileName);
    }
  }

  // Method to display contents of the selected file
  private void displayFile() {
    loadFile(editBox);
  }

  // Method to save the contents of the text area to a file
  private void saveFile() {
    saveFile(editBox);
  }

  // Method to save contents of the text area to a new file or overwrite an
  // existing file
  private void saveAsFile() {
    JFileChooser fileChooser = new JFileChooser("./");
    // Creating file filters for different file types
    FileFilter[] filters = createFileFilters(".txt", "Text Files (*.txt)", ".csv", "CSV Files (*.csv)", ".dat",
        "DAT Files (*.dat)");
    for (FileFilter filter : filters) {
      fileChooser.addChoosableFileFilter(filter);
    }
    fileChooser.setSelectedFile(filePath.getText().length() > 0 ? new File(filePath.getText()) : null);
    // Showing the save dialog and handling file saving
    if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
      String fileName = fileChooser.getSelectedFile().getAbsolutePath();
      String fileFilter = fileChooser.getFileFilter().getDescription();
      // Checking file extension and applying appropriate extension if needed
      if (fileName.contains(".") && !fileFilter.contains("(*.")) {
        // Do nothing
      } else {
        if (fileName.contains(".")) {
          fileName = fileName.substring(0, fileName.indexOf("."));
        }
        String extension = ".txt";
        if (fileFilter.contains("(*.")) {
          extension = fileFilter.substring(fileFilter.indexOf("*") + 1, fileFilter.indexOf(")"));
        }
        fileName += extension;
      }
      saveFileAs(editBox, fileName);
    }
  }

  // Method to exit the application
  private void exit() {
    System.exit(0);
  }

  // Method to create file filters for specific extensions and descriptions
  private FileFilter[] createFileFilters(String... extensionsAndDescriptions) {
    if (extensionsAndDescriptions.length % 2 != 0) {
      throw new IllegalArgumentException(
          "Invalid number of arguments. Each extension must have a corresponding description.");
    }

    FileFilter[] filters = new FileFilter[extensionsAndDescriptions.length / 2];
    for (int i = 0; i < extensionsAndDescriptions.length; i += 2) {
      String extension = extensionsAndDescriptions[i];
      String description = extensionsAndDescriptions[i + 1];
      filters[i / 2] = createFileFilter(extension, description);
    }
    return filters;
  }

  // Method to create a file filter for a specific extension and description
  private FileFilter createFileFilter(String extension, String description) {
    return new FileFilter() {
      public boolean accept(File f) {
        return f.getName().toLowerCase().endsWith(extension) || f.isDirectory();
      }

      public String getDescription() {
        return description;
      }
    };
  }

  // Method to load the contents of a selected file into the text area
  private void loadFile(JTextArea mainEditBox) {
    if (filePath.getText().length() < 1) {
      JOptionPane.showMessageDialog(frame, "Please select a file to open.", "Error",
          JOptionPane.ERROR_MESSAGE);
    } else {
      try {
        List<String> lines = Files.readAllLines(Paths.get(filePath.getText()));
        mainEditBox.setText(""); // Clearing the text area before loading the file content
        for (String line : lines) {
          mainEditBox.append(line + "\n"); // Appending each line from the file to the text area
        }
      } catch (Exception ex) {
        ex.printStackTrace(); // Handling exceptions by printing the stack trace
      }
    }
  }

  // Method to save the contents of the text area to a file
  private void saveFile(JTextArea mainEditBox) {
    if (filePath.getText().length() < 1) {
      JOptionPane.showMessageDialog(frame, "Please select a file to save to.", "Error",
          JOptionPane.ERROR_MESSAGE);
    } else {
      try {
        Files.write(Paths.get(filePath.getText()), mainEditBox.getText().getBytes());
        // Writing the text area content to the selected file path
      } catch (Exception ex) {
        ex.printStackTrace(); // Handling exceptions by printing the stack trace
      }
    }
  }

  // Method to save the contents of the text area to a specified file path
  private void saveFileAs(JTextArea mainEditBox, String filePath) {
    File file = new File(filePath);
    if (file.exists()) {
      int result = JOptionPane.showConfirmDialog(frame, "File already exists. Do you want to overwrite it?",
          "File Exists", JOptionPane.YES_NO_OPTION);
      if (result == JOptionPane.NO_OPTION) {
        return; // User chooses not to overwrite the file
      }
    }
    try {
      Files.write(Paths.get(filePath), mainEditBox.getText().getBytes());
      // Writing the text area content to the specified file path
    } catch (Exception ex) {
      ex.printStackTrace(); // Handling exceptions by printing the stack trace
    }
  }

  private void loadLinkedList() {
    if (filePath.getText().length() < 1) {
      JOptionPane.showMessageDialog(frame, "Please select a file to open.", "Error",
          JOptionPane.ERROR_MESSAGE);
    } else {
      try {
        List<String> lines = Files.readAllLines(Paths.get(filePath.getText()));
        editBox.setText(""); // Clearing the text area before loading the file content
        linkedList.clear();
        for (String line : lines) {
          linkedList.addToEnd(Integer.parseInt(line));
        }
        editBox.setText("Loaded!");
      } catch (Exception ex) {
        ex.printStackTrace(); // Handling exceptions by printing the stack trace
      }
    }
  }

  private void addLinkedList() {
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
            linkedList.addToEnd(Integer.parseInt(result));
            editBox.setText("Added!");
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

  private void removeLinkedList() {
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
            String text = linkedList.deleteNode(Integer.parseInt(result));
            editBox.setText(text);
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

  private void searchLinkedList() {
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
            boolean found = linkedList.find(Integer.parseInt(result));
            String text = result + " was " + (found ? "found in the list!" : "not found is the list!");
            editBox.setText(text);
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

  private void displayLinkedList() {
    if (editBox.getText().length() < 1) {
      JOptionPane.showMessageDialog(frame, "Please enter a number to display.", "Error",
          JOptionPane.ERROR_MESSAGE);
    } else {
      try {
        editBox.setText(linkedList.showNodes());
      } catch (Exception ex) {
        ex.printStackTrace(); // Handling exceptions by printing the stack trace
      }
    }
  }

  private void loadCircularLinkedList() {
    if (filePath.getText().length() < 1) {
      JOptionPane.showMessageDialog(frame, "Please select a file to open.", "Error",
          JOptionPane.ERROR_MESSAGE);
    } else {
      try {
        List<String> lines = Files.readAllLines(Paths.get(filePath.getText()));
        editBox.setText(""); // Clearing the text area before loading the file content
        circularLinkedList.clear();
        for (String line : lines) {
          circularLinkedList.addToEnd(Integer.parseInt(line));
        }
        editBox.setText("Loaded!");
      } catch (Exception ex) {
        ex.printStackTrace(); // Handling exceptions by printing the stack trace
      }
    }
  }

  private void addCircularLinkedList() {
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
            circularLinkedList.addToEnd(Integer.parseInt(result));
            editBox.setText("Added!");
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

  private void removeCircularLinkedList() {
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
            boolean didDelete = circularLinkedList.deleteNode(Integer.parseInt(result));
            String text = result + " was " + (didDelete ? "deleted from the list!" : "not is the list!");
            editBox.setText(text);
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

  private void searchCircularLinkedList() {
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
            boolean found = circularLinkedList.find(Integer.parseInt(result));
            String text = result + " was " + (found ? "found in the list!" : "not found is the list!");
            editBox.setText(text);
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

  private void displayCircularLinkedList() {
    if (editBox.getText().length() < 1) {
      JOptionPane.showMessageDialog(frame, "Please enter a number to display.", "Error",
          JOptionPane.ERROR_MESSAGE);
    } else {
      try {
        editBox.setText(circularLinkedList.showNodes());
      } catch (Exception ex) {
        ex.printStackTrace(); // Handling exceptions by printing the stack trace
      }
    }
  }

  private void loadStack() {
    if (filePath.getText().length() < 1) {
      JOptionPane.showMessageDialog(frame, "Please select a file to open.", "Error",
          JOptionPane.ERROR_MESSAGE);
    } else {
      try {
        List<String> lines = Files.readAllLines(Paths.get(filePath.getText()));
        editBox.setText(""); // Clearing the text area before loading the file content
        stack.purge();
        for (String line : lines) {
          stack.push(Integer.parseInt(line));
        }
        editBox.setText("Loaded!");
      } catch (Exception ex) {
        ex.printStackTrace(); // Handling exceptions by printing the stack trace
      }
    }
  }

  private void pushStack() {
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
            stack.push(Integer.parseInt(result));
            editBox.setText("Added!");
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

  private void popStack() {
    try {
      editBox.setText(stack.pop());
    } catch (Exception ex) {
      ex.printStackTrace(); // Handling exceptions by printing the stack trace
    }
  }

  private void peekStack() {
    try {
      editBox.setText(stack.peek());
    } catch (Exception ex) {
      ex.printStackTrace(); // Handling exceptions by printing the stack trace
    }
  }

  private void findStack() {
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
            boolean found = stack.find(Integer.parseInt(result));
            String text = result + " was " + (found ? "found in the list!" : "not found is the list!");
            editBox.setText(text);
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

  private void isEmptyStack() {
    try {
      editBox.setText(stack.isEmpty() ? "The stack is empty." : "The stack is not empty.");
    } catch (Exception ex) {
      ex.printStackTrace(); // Handling exceptions by printing the stack trace
    }
  }

  private void displayStack() {
    try {
      editBox.setText(stack.showNodes());
    } catch (Exception ex) {
      ex.printStackTrace(); // Handling exceptions by printing the stack trace
    }
  }

  private void loadQueue() {
    if (filePath.getText().length() < 1) {
      JOptionPane.showMessageDialog(frame, "Please select a file to open.", "Error",
          JOptionPane.ERROR_MESSAGE);
    } else {
      try {
        List<String> lines = Files.readAllLines(Paths.get(filePath.getText()));
        editBox.setText(""); // Clearing the text area before loading the file content
        queue.purge();
        for (String line : lines) {
          queue.enqueue(Integer.parseInt(line));
        }
        editBox.setText("Loaded!");
      } catch (Exception ex) {
        ex.printStackTrace(); // Handling exceptions by printing the stack trace
      }
    }
  }

  private void enqueueQueue() {
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
            queue.enqueue(Integer.parseInt(result));
            editBox.setText("Added!");
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

  private void dequeueQueue() {
    try {
      editBox.setText(queue.dequeue());
    } catch (Exception ex) {
      ex.printStackTrace(); // Handling exceptions by printing the stack trace
    }
  }

  private void findQueue() {
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
            boolean found = queue.find(Integer.parseInt(result));
            String text = result + " was " + (found ? "found in the list!" : "not found is the list!");
            editBox.setText(text);
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

  private void isEmptyQueue() {
    try {
      editBox.setText(queue.isEmpty() ? "The queue is empty." : "The queue is not empty.");
    } catch (Exception ex) {
      ex.printStackTrace(); // Handling exceptions by printing the stack trace
    }
  }

  private void displayQueue() {
    try {
      editBox.setText(queue.showNodes());
    } catch (Exception ex) {
      ex.printStackTrace(); // Handling exceptions by printing the stack trace
    }
  }

  private void loadDeque() {
    if (filePath.getText().length() < 1) {
      JOptionPane.showMessageDialog(frame, "Please select a file to open.", "Error",
          JOptionPane.ERROR_MESSAGE);
    } else {
      try {
        List<String> lines = Files.readAllLines(Paths.get(filePath.getText()));
        editBox.setText(""); // Clearing the text area before loading the file content
        deque.purge();
        for (String line : lines) {
          deque.insertBack(Integer.parseInt(line));
        }
        editBox.setText("Loaded!");
      } catch (Exception ex) {
        ex.printStackTrace(); // Handling exceptions by printing the stack trace
      }
    }
  }

  private void insertFrontDeque() {
    boolean validInput = false;

    while (!validInput) {
      JTextField inputField = new JTextField();
      Object[] message = { "Please enter a number to insert:", inputField };

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
            deque.insertFront(Integer.parseInt(result));
            editBox.setText("Added!");
            validInput = true;
          } catch (NumberFormatException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid integer.");
          }
        } else {
          JOptionPane.showMessageDialog(null, "No input provided. Please enter a number.");
        }
      } else {
        validInput = true;
      }
    }
  }

  private void insertBackDeque() {
    boolean validInput = false;

    while (!validInput) {
      JTextField inputField = new JTextField();
      Object[] message = { "Please enter a number to insert:", inputField };

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
            deque.insertBack(Integer.parseInt(result));
            editBox.setText("Added!");
            validInput = true;
          } catch (NumberFormatException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid integer.");
          }
        } else {
          JOptionPane.showMessageDialog(null, "No input provided. Please enter a number.");
        }
      } else {
        validInput = true;
      }
    }
  }

  private void removeFrontDeque() {
    try {
      editBox.setText(deque.removeFront());
    } catch (Exception ex) {
      ex.printStackTrace(); // Handling exceptions by printing the stack trace
    }
  }

  private void removeBackDeque() {
    try {
      editBox.setText(deque.removeBack());
    } catch (Exception ex) {
      ex.printStackTrace(); // Handling exceptions by printing the stack trace
    }
  }

  private void findDeque() {
    boolean validInput = false;

    while (!validInput) {
      JTextField inputField = new JTextField();
      Object[] message = { "Please enter a number to find:", inputField };

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
            boolean found = deque.find(Integer.parseInt(result));
            String text = result + " was " + (found ? "found in the list!" : "not found is the list!");
            editBox.setText(text);
            validInput = true;
          } catch (NumberFormatException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid integer.");
          }
        } else {
          JOptionPane.showMessageDialog(null, "No input provided. Please enter a number.");
        }
      } else {
        validInput = true;
      }
    }
  }

  private void isEmptyDeque() {
    try {
      editBox.setText(deque.isEmpty() ? "The deque is empty." : "The deque is not empty.");
    } catch (Exception ex) {
      ex.printStackTrace(); // Handling exceptions by printing the stack trace
    }
  }

  private void displayDeque() {
    try {
      editBox.setText(deque.showNodes());
    } catch (Exception ex) {
      ex.printStackTrace(); // Handling exceptions by printing the stack trace
    }
  }

  private void loadPriortyQueue() {
    if (filePath.getText().length() < 1) {
      JOptionPane.showMessageDialog(frame, "Please select a file to open.", "Error",
          JOptionPane.ERROR_MESSAGE);
    } else {
      try {
        List<String> lines = Files.readAllLines(Paths.get(filePath.getText()));
        editBox.setText(""); // Clearing the text area before loading the file content
        priortyQueue.purge();
        for (String line : lines) {
          priortyQueue.insert(Integer.parseInt(line));
        }
        editBox.setText("Loaded!");
      } catch (Exception ex) {
        ex.printStackTrace(); // Handling exceptions by printing the stack trace
      }
    }
  }

  private void insertPriortyQueue() {
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
            priortyQueue.insert(Integer.parseInt(result));
            editBox.setText("Added!");
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

  private void dequeuePriortyQueue() {
    try {
      editBox.setText(priortyQueue.dequeue());
    } catch (Exception ex) {
      ex.printStackTrace(); // Handling exceptions by printing the stack trace
    }
  }

  private void findPriortyQueue() {
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
            boolean found = priortyQueue.find(Integer.parseInt(result));
            String text = result + " was " + (found ? "found in the list!" : "not found is the list!");
            editBox.setText(text);
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

  private void isEmptyPriortyQueue() {
    try {
      editBox.setText(priortyQueue.isEmpty() ? "The priorty queue is empty." : "The priorty queue is not empty.");
    } catch (Exception ex) {
      ex.printStackTrace(); // Handling exceptions by printing the stack trace
    }
  }

  private void displayPriortyQueue() {
    try {
      editBox.setText(priortyQueue.showNodes());
    } catch (Exception ex) {
      ex.printStackTrace(); // Handling exceptions by printing the stack trace
    }
  }

  private void loadBinaryTree() {
    if (filePath.getText().length() < 1) {
      JOptionPane.showMessageDialog(frame, "Please select a file to open.", "Error",
          JOptionPane.ERROR_MESSAGE);
    } else {
      try {
        List<String> lines = Files.readAllLines(Paths.get(filePath.getText()));
        editBox.setText(""); // Clearing the text area before loading the file content
        binaryTree.purge();
        for (String line : lines) {
          binaryTree.insert(Integer.parseInt(line));
        }
        editBox.setText("Loaded!");
      } catch (Exception ex) {
        ex.printStackTrace(); // Handling exceptions by printing the stack trace
      }
    }
  }

  private void insertBinaryTree() {
    boolean validInput = false;

    while (!validInput) {
      JTextField inputField = new JTextField();
      Object[] message = { "Please enter a number to insert:", inputField };

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
            binaryTree.insert(Integer.parseInt(result));
            editBox.setText("Added!");
            validInput = true;
          } catch (NumberFormatException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid integer.");
          }
        } else {
          JOptionPane.showMessageDialog(null, "No input provided. Please enter a number.");
        }
      } else {
        validInput = true;
      }
    }
  }

  private void removeBinaryTree() {
    boolean validInput = false;

    while (!validInput) {
      JTextField inputField = new JTextField();
      Object[] message = { "Please enter a number to remove:", inputField };

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
            ;
            editBox.setText(binaryTree.remove(Integer.parseInt(result)));
            validInput = true;
          } catch (NumberFormatException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid integer.");
          }
        } else {
          JOptionPane.showMessageDialog(null, "No input provided. Please enter a number.");
        }
      } else {
        validInput = true;
      }
    }
  }

  private void findBinaryTree() {
    boolean validInput = false;

    while (!validInput) {
      JTextField inputField = new JTextField();
      Object[] message = { "Please enter a number to find:", inputField };

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
            boolean found = binaryTree.contains(Integer.parseInt(result));
            String text = result + " was " + (found ? "found in the binary !" : "not found is the binary !");
            editBox.setText(text);
            validInput = true;
          } catch (NumberFormatException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid integer.");
          }
        } else {
          JOptionPane.showMessageDialog(null, "No input provided. Please enter a number.");
        }
      } else {
        validInput = true;
      }
    }
  }

  private void inOrderBinaryTree() {
    try {
      editBox.setText(binaryTree.inOrder());
    } catch (Exception ex) {
      ex.printStackTrace(); // Handling exceptions by printing the stack trace
    }
  }

  private void preOrderBinaryTree() {
    try {
      editBox.setText(binaryTree.preOrder());
    } catch (Exception ex) {
      ex.printStackTrace(); // Handling exceptions by printing the stack trace
    }
  }

  private void postOrderBinaryTree() {
    try {
      editBox.setText(binaryTree.postOrder());
    } catch (Exception ex) {
      ex.printStackTrace(); // Handling exceptions by printing the stack trace
    }
  }

  private void loadBinarySearchTree() {
    if (filePath.getText().length() < 1) {
      JOptionPane.showMessageDialog(frame, "Please select a file to open.", "Error",
          JOptionPane.ERROR_MESSAGE);
    } else {
      try {
        List<String> lines = Files.readAllLines(Paths.get(filePath.getText()));
        editBox.setText(""); // Clearing the text area before loading the file content
        binarySearchTree.purge();
        for (String line : lines) {
          binarySearchTree.insert(Integer.parseInt(line));
        }
        editBox.setText("Loaded!");
      } catch (Exception ex) {
        ex.printStackTrace(); // Handling exceptions by printing the stack trace
      }
    }
  }

  private void insertBinarySearchTree() {
    boolean validInput = false;

    while (!validInput) {
      JTextField inputField = new JTextField();
      Object[] message = { "Please enter a number to insert:", inputField };

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
            binarySearchTree.insert(Integer.parseInt(result));
            editBox.setText("Added!");
            validInput = true;
          } catch (NumberFormatException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid integer.");
          }
        } else {
          JOptionPane.showMessageDialog(null, "No input provided. Please enter a number.");
        }
      } else {
        validInput = true;
      }
    }
  }

  private void removeBinarySearchTree() {
    boolean validInput = false;

    while (!validInput) {
      JTextField inputField = new JTextField();
      Object[] message = { "Please enter a number to remove:", inputField };

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
            ;
            editBox.setText(binarySearchTree.remove(Integer.parseInt(result)));
            validInput = true;
          } catch (NumberFormatException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid integer.");
          }
        } else {
          JOptionPane.showMessageDialog(null, "No input provided. Please enter a number.");
        }
      } else {
        validInput = true;
      }
    }
  }

  private void findBinarySearchTree() {
    boolean validInput = false;

    while (!validInput) {
      JTextField inputField = new JTextField();
      Object[] message = { "Please enter a number to find:", inputField };

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
            boolean found = binarySearchTree.contains(Integer.parseInt(result));
            String text = result + " was " + (found ? "found in the binary search tree!" : "not found is the binary search tree!");
            editBox.setText(text);
            validInput = true;
          } catch (NumberFormatException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid integer.");
          }
        } else {
          JOptionPane.showMessageDialog(null, "No input provided. Please enter a number.");
        }
      } else {
        validInput = true;
      }
    }
  }

  private void inOrderBinarySearchTree() {
    try {
      editBox.setText(binarySearchTree.inOrder());
    } catch (Exception ex) {
      ex.printStackTrace(); // Handling exceptions by printing the stack trace
    }
  }

  private void preOrderBinarySearchTree() {
    try {
      editBox.setText(binarySearchTree.preOrder());
    } catch (Exception ex) {
      ex.printStackTrace(); // Handling exceptions by printing the stack trace
    }
  }

  private void postOrderBinarySearchTree() {
    try {
      editBox.setText(binarySearchTree.postOrder());
    } catch (Exception ex) {
      ex.printStackTrace(); // Handling exceptions by printing the stack trace
    }
  }

}