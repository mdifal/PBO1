/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tugasgui;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author mdifa
 */
public class TugasGUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
 JFrame frame = new JFrame("Restaurant GUI");
 frame.setContentPane(new EventDrivenForm().getPanel1());
 frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
 frame.setResizable(false);
 frame.pack();
 Dimension screenSize =
Toolkit.getDefaultToolkit().getScreenSize();
 int x = (screenSize.width - frame.getWidth()) / 2;
 int y = (screenSize.height - frame.getHeight()) / 2;
 frame.setLocation(x, y);
 frame.setVisible(true);
 });

    }
}
