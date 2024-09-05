

import java.awt.*;
import java.awt.event.*;

public class TodoApp extends Frame implements ActionListener {
    // Components
    TextField taskInput;
    Button addButton;
    Button removeButton;
    List taskList;

    public TodoApp() {
        // Frame settings
        setTitle("To-Do App");
        setSize(400, 300);
        setLayout(new BorderLayout(10, 10));

        // Initialize components
        taskInput = new TextField();
        addButton = new Button("Add Task");
        removeButton = new Button("Remove Selected Task");
        taskList = new List();

        // Set layout for the top panel
        Panel topPanel = new Panel(new BorderLayout(5, 5));
        topPanel.add(taskInput, BorderLayout.CENTER);
        topPanel.add(addButton, BorderLayout.EAST);

        // Add components to the frame
        add(topPanel, BorderLayout.NORTH);
        add(taskList, BorderLayout.CENTER);
        add(removeButton, BorderLayout.SOUTH);

        // Add action listeners
        addButton.addActionListener(this);
        removeButton.addActionListener(this);

        // Add window listener to close the application
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        // Make frame visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            // Add task to the list
            String task = taskInput.getText();
            if (!task.isEmpty()) {
                taskList.add(task);
                taskInput.setText("");
            }
        } else if (e.getSource() == removeButton) {
            // Remove selected task from the list
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                taskList.remove(selectedIndex);
            }
        }
    }

    public static void main(String[] args) {
        new TodoApp();
    }
}
