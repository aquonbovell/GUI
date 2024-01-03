import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.border.Border;
import javax.swing.filechooser.FileFilter;

public class GUI extends JFrame {
  final private Font font = new Font("Apple Casual", Font.BOLD, 12);
  // Declaring private member variables
  private String title;
  private int width;
  private int height;
  public JMenuBar menuBar;
  public JMenu linearADTs;
  public JMenu hierarchicalADTs;
  public JTextField filePath;
  private JLabel fileLabel;
  public JTextArea editBox;
  private LinearADTHandler linearADTHandler;
  private HierarchicalADTHandler hierarchicalADTHandler;

  // Constructor to initialize the GUI with specified title, width, and height
  public GUI(String title, int width, int height) {
    this.title = title;
    this.width = width;
    this.height = height;

  }

  // Method to initialize the GUI
  public void init() {
    // Setting menu bar properties
    menuBar = new JMenuBar();
    menuBar.setLayout(new WrapLayout(WrapLayout.LEFT, 0, 0));
    menuBar.add(createFileOptions());
    linearADTHandler = new LinearADTHandler(this);
    hierarchicalADTHandler = new HierarchicalADTHandler(this);
    menuBar.add(linearADTHandler.createLinearADTOptions());
    menuBar.add(hierarchicalADTHandler.createHierarchicalADTOptions());
    setJMenuBar(menuBar);

    // Setting main panel attributes
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout(0, 5));
    add(mainPanel);

    // Setting file panel attributes
    JPanel filePanel = new JPanel();
    filePanel.setLayout(new BorderLayout(5, 0));
    filePanel.setBorder(
        new Border() {
          @Override
          public void paintBorder(java.awt.Component c, java.awt.Graphics g, int x, int y, int width, int height) {

          }

          @Override
          public boolean isBorderOpaque() {
            return true;
          }

          @Override
          public java.awt.Insets getBorderInsets(java.awt.Component c) {
            return new java.awt.Insets(0, 5, 0, 5);
          }

        });
    fileLabel = new JLabel("File Path:");
    filePath = new JTextField(20);
    fileLabel.setFont(font);
    filePath.setFont(font);
    filePanel.add(fileLabel, BorderLayout.WEST);
    filePanel.add(filePath, 1);

    // Setting edit panel attributes
    JPanel editPanel = new JPanel();
    editPanel.setLayout(new BorderLayout(0, 5));
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBorder(
        new Border() {
          @Override
          public void paintBorder(java.awt.Component c, java.awt.Graphics g, int x, int y, int width, int height) {
            g.setColor(java.awt.Color.LIGHT_GRAY);
            g.drawRect(x + 4, y, width - 9, height - 5);
          }

          @Override
          public boolean isBorderOpaque() {
            return true;
          }

          @Override
          public java.awt.Insets getBorderInsets(java.awt.Component c) {
            return new java.awt.Insets(1, 5, 5, 5);
          }

        });
    editBox = new JTextArea();
    editBox.setLineWrap(true);
    editBox.setWrapStyleWord(true);
    editBox.setTabSize(1);
    editBox.setFont(font);
    scrollPane.setViewportView(editBox);
    editPanel.add(new JLabel("  Display:"), BorderLayout.NORTH);
    editPanel.add(scrollPane, BorderLayout.CENTER);

    // Adding panels to the main panel
    mainPanel.add(filePanel, BorderLayout.NORTH);
    mainPanel.add(editPanel, BorderLayout.CENTER);

    // Setting frame attributes
    setTitle(title);
    setMinimumSize(new Dimension(width, height));
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
    setVisible(true);
  }

  // Method to create file options in the menu
  private JMenu createFileOptions() {
    JMenu file = new JMenu("File");
    JMenuItem open = new JMenuItem("Open");
    JMenuItem display = new JMenuItem("Display");
    JMenuItem save = new JMenuItem("Save");
    JMenuItem saveAs = new JMenuItem("Save As");
    JMenuItem exit = new JMenuItem("Exit");
    file.setFont(font);
    open.setFont(font);
    display.setFont(font);
    save.setFont(font);
    saveAs.setFont(font);
    exit.setFont(font);
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

  // Method to handle file opening
  private void openFile() {
    JFileChooser fileChooser = new JFileChooser("./");
    // Creating file filters for different file types
    FileFilter[] filters = createFileFilters(".txt", "Text Files (*.txt)",
        ".csv", "CSV Files (*.csv)", ".dat",
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
    FileFilter[] filters = createFileFilters(".txt", "Text Files (*.txt)",
        ".csv", "CSV Files (*.csv)", ".dat",
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
          extension = fileFilter.substring(fileFilter.indexOf("*") + 1,
              fileFilter.indexOf(")"));
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
      JOptionPane.showMessageDialog(this, "Please select a file to open.",
          "Error",
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
      JOptionPane.showMessageDialog(this, "Please select a file to save to.",
          "Error",
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
      int result = JOptionPane.showConfirmDialog(this, "File already exists. Do you want to overwrite it?",
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
}