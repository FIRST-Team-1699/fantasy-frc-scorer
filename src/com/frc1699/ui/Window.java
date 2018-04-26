package com.frc1699.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Window {

    private final JFrame frame;
    private final Map<String, JComponent> components;

    public Window(final int width, final int height, final String name){
        components = new HashMap<>();
        frame = new JFrame(name);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setFocusable(false);
    }

    public void addButton(final String name, final String text, final ActionListener action, final Rectangle bounds){
        JButton button = new JButton(text);
        button.setBounds(bounds);
        frame.add(button);
        button.addActionListener(action);
        components.put(name, button);
    }

    public void addLabel(final String name, final String text, final Rectangle bounds){
        JLabel label = new JLabel();
        label.setText(text);
        label.setBounds(bounds);
        frame.add(label);
        components.put(name, label);
    }

    public void addTextField(final String name, final Rectangle bounds){
        JTextField field = new JTextField();
        field.setBounds(bounds);
        field.setVisible(true);
        frame.add(field);
        components.put(name, field);
    }

    public void pack(){
        frame.pack();
    }

    public JFrame getFrame(){
        return frame;
    }
}
