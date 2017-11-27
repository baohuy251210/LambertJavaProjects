package thermometer;

/**
 *
 * @author Cyot49chv 
 */
import javax.swing.*;
import java.awt.*;
public class GUImain {

        public static void main(String[] args) {
                GUIWindow gui = new GUIWindow();
                gui.setTitle("F to C converter");
                gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gui.pack();
                gui.setVisible(true);
        }
        
}
