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
public class ColorPan extends JPanel{
    public ColorPan(Color backColor){
            setBackground(backColor);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.black);
//        g.fillRect(45, 20, 100, 50);
//        g.drawLine(20, 20, 100, 100);
//        g.drawOval(50, 50, 150, 150);
        g.drawLine(50, 50, 100, 100);
        g.drawLine(100, 100, 200, 200);
    }
}
