package com.frc1699.tst;

import com.frc1699.ui.Window;

import java.awt.*;

public class WindowTest {

    public static void main(String[] args){
        Window window = new Window(800, 600, "Test");
        window.addLabel("Test", "Test", new Rectangle(10, 10, 100, 100));
    }
}
