/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiwindow;

/**
 *
 * @author baohuy251210
 */
import javax.swing.*;
import java.awt.*;
public class GUIWindow {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame GUI = new JFrame();
        CreateGUI(600, 600, GUI, "GUI Prog");
        ColorPan panel = new ColorPan(Color.white);
        Container pane = GUI.getContentPane();
        pane.add(panel);   
    }

    public static void CreateGUI(int x, int y, JFrame GUI, String name) {
        GUI.setTitle(name);
        GUI.setSize(x, y);
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI.setVisible(true);
    }
    
}
