package com.samarpan.todoList.in;

import java.awt.*;
import java.awt.event.*;

public class ToDoApp extends Frame implements ActionListener {
    Button add;
    Button delete;
    TextField text;
    List taskLists;
    GridBagConstraints gbc;
    Label tasks;

    public ToDoApp() {
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(0x4B70F5));
        Font f = new Font("Arial", Font.PLAIN, 24);
        gbc = new GridBagConstraints();

        add = new Button("ADD TASK");
        delete = new Button("REMOVE TASK");
        text = new TextField(10);
        taskLists = new List();
        tasks = new Label("TASKS :");
        text.setFont(f);
        f = new Font("Arial", Font.BOLD, 18);
        taskLists.setFont(f);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 5, 10);
        gbc.ipady = 20;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        this.add(text, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.ipady = 30;
        this.add(add, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        this.add(delete, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weighty = 0;
        gbc.insets = new Insets(5, 10, 5, 10);
        tasks.setFont(f);
        gbc.ipady = 0;
        this.add(tasks, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.weighty = 1; // Adjust this to ensure proper spacing
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(1, 10, 5, 10);
        this.add(taskLists, gbc);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        add.addActionListener(this);
        delete.addActionListener(this);
    }

    public static void main(String[] args) {
        ToDoApp obj = new ToDoApp();
        obj.setTitle("ToDoList App");
        obj.setSize(600, 600);
        obj.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            if (!text.getText().isEmpty()) {
                taskLists.add(text.getText());
                text.setText("");
            }
        }
        if (e.getSource() == delete) {
            int idx = taskLists.getSelectedIndex();
            if (idx >= 0) {
                taskLists.remove(idx);
            }
        }
    }
}
