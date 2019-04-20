package com.frc1699.ui;

import com.frc1699.csvParser.CSVParser;
import com.frc1699.main.Constants;
import com.frc1699.main.Game;
import com.frc1699.player.Player;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileSystemView;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Window {

    private final JFrame frame;
    private final Map<String, JComponent> components;

    public Window(final int width, final int height, final String name){
        components = new HashMap<>();
        frame = new JFrame(name);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setFocusable(false);
        createLayout();
        frame.setVisible(true);
    }

    //Creates layout for GUI
    private void createLayout(){
        //CSV File Selection
        addLabel("CSVSelect", "Select a CSV File:", new Rectangle(20, 20, 150, 30));
        addButton("FileBrowser", "Browse", e -> {
            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getDefaultDirectory());
            int returnValue = fileChooser.showOpenDialog(null);
            if(returnValue == JFileChooser.APPROVE_OPTION){
                File selectedFile = fileChooser.getSelectedFile();
                Constants.getInstance().setPathToCSV(selectedFile);
                ((JTextField) components.get("CSVField")).setText(selectedFile.getAbsolutePath());
            }
        }, new Rectangle(640, 20, 100, 30));
        addTextField("CSVField", new Rectangle(130, 20, 500, 30));

        //TBA key input
        addLabel("TBAKey", "Enter your TBAAuthKey:", new Rectangle(20, 60, 150, 30));
        addTextField("TBATextField", new Rectangle(170, 60, 600, 30));

        //Enter Data
        addLabel("Date", "Enter the competition year:", new Rectangle(240, 100, 180, 30));
        addTextField("DateField", new Rectangle(400, 100, 200, 30));

        //Submit Button
        addButton("Submit", "Submit", e -> {
            Constants.getInstance().setTBAAuthKey(((JTextField) components.get("TBATextField")).getText());
            Game g =  new CSVParser(Constants.getInstance().getPathToCSV().getAbsolutePath()).getGame();
            for(Player p : g.getPlayerList()){
                p.update();
                ((JTextArea) components.get("Output")).append(p.getName() + " : " + p.getScore() + "\n");
            }
            Constants.getInstance().setYear(((JTextField) components.get("DateField")).getText());
        }, new Rectangle(350, 150, 100, 30));

        //Output
        addTextArea("Output", 20, 20, new Rectangle(50, 200, 700, 350));
    }

    //Adds a button to the GUI
    private void addButton(final String name, final String text, final ActionListener action, final Rectangle bounds){
        JButton button = new JButton(text);
        button.setBounds(bounds);
        frame.add(button);
        button.addActionListener(action);
        components.put(name, button);
    }

    //Adds a label to the GUI
    private void addLabel(final String name, final String text, final Rectangle bounds){
        JLabel label = new JLabel();
        label.setText(text);
        label.setBounds(bounds);
        frame.add(label);
        components.put(name, label);
    }

    //Adds a text field to the GUI
    private void addTextField(final String name, final Rectangle bounds){
        JTextField field = new JTextField("");
        field.setBounds(bounds);
        frame.add(field);
        field.setVisible(true);
        components.put(name, field);
    }

    //Adds text area to the GUI
    private void addTextArea(final String name, final int rows, final int columns, final Rectangle bounds){
        JTextArea field = new JTextArea(rows, columns);
        field.setBounds(bounds);
        field.setEditable(false);
        frame.add(field);
        field.setVisible(true);
        components.put(name, field);
    }

    //Packs the frame
    private void pack(){
        frame.pack();
    }
}
