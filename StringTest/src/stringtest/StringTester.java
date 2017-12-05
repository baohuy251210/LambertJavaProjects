package stringtest;

/**
 *
 * @author Cyot49chv
 */
import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class StringTester extends JApplet
        implements ActionListener {

        private JTextField input = new JTextField(20);
        private JTextField computer = new JTextField(20);        
        JLabel Intro = new JLabel("Rock-Paper-Scissors!");
        JLabel inLabel = new JLabel(" Player:");
        JLabel outLabel = new JLabel("Computer:");
        JLabel resLabel = new JLabel("--------------");
        JLabel tLabel, t1Label, t2Label;
        Image img,img1,img2;
        ImageIcon tIcon,tIcon1,tIcon2;
        Container c;
        @Override
        public void init() {
                input.setFont(new Font("Monospaced", Font.BOLD, 36));
                input.setBackground(Color.white);
                input.addActionListener(this);
                input.selectAll();
                
                computer.setFont(new Font("Monospaced", Font.BOLD, 36));
                computer.setBackground(Color.white);
                computer.setEditable(false);
                
                c = getContentPane();
                this.setSize(500, 600);
                c.setLayout(new FlowLayout());
//                img = getImage(getCodeBase(),"Title1.jpg");
//                System.out.println(getCodeBase());
//                tIcon = new ImageIcon(img);
//                ColorPanel panel = new ColorPanel(Color.red,tIcon);
                
                img = getImage(getDocumentBase(),"Title.jpg");
                img1 = getImage(getDocumentBase(),"Title1.jpg");
                img2 = getImage(getDocumentBase(),"Title1.jpg");
                tIcon = new ImageIcon(img);
                tIcon1 = new ImageIcon(img1);
                tIcon2 = new ImageIcon(img2);
                
                 tLabel = new JLabel(tIcon);
                 t1Label = new JLabel(tIcon1);
                 t2Label = new JLabel(tIcon2);
                
                Intro.setFont(new Font("Monospaced", Font.BOLD,36));
                inLabel.setFont(new Font("Monospaced", Font.BOLD, 24));
                outLabel.setFont(new Font("Monospaced", Font.BOLD, 24));
                resLabel.setFont(new Font("Monospaced", Font.BOLD,36));
                Intro.setHorizontalAlignment(SwingConstants.CENTER);
                inLabel.setHorizontalAlignment(SwingConstants.CENTER);
                outLabel.setHorizontalAlignment(SwingConstants.CENTER);
                resLabel.setHorizontalAlignment(SwingConstants.CENTER);
                c.add(tLabel);
                c.add(Intro);
                c.add(inLabel);c.add(t1Label);
                c.add(input);
                c.add(outLabel);c.add(t2Label);
                c.add(computer);
                c.add(resLabel);
                input.requestFocus();
        }
        

        @Override
        public void actionPerformed(ActionEvent e) {
                String str = input.getText();
                str = str.toLowerCase();
                resLabel.setText(process(str));
                input.selectAll();
        }
        
        String r = "rock", p = "paper", s = "scissors";
        int pChoice, cChoice;
        String mass = "";
        public String process(String str){
                boolean ffun = true;
                if (str.equals(r)){
                        pChoice = 1;
                        img1 = getImage(getDocumentBase(),"R.jpg");
                }
                else if (str.equals(p)){
                        pChoice = 2;
                        img1 = getImage(getDocumentBase(),"P.jpg");                        
                }
                else if (str.equals(s)){
                        pChoice = 3;
                        img1 = getImage(getDocumentBase(),"S.jpg");
                }
                else {
                        img1 = getImage(getDocumentBase(),"Title1.jpg");
                        img2 = getImage(getDocumentBase(),"Title1.jpg");
                        tIcon1 = new ImageIcon(img1);
                        t1Label.setIcon(tIcon1);
                        tIcon2 = new ImageIcon(img2);
                        t2Label.setIcon(tIcon2);
                        computer.setText("::::::I am not that stupid");
                        return "Error!";
                }
                tIcon1 = new ImageIcon(img1);
                t1Label.setIcon(tIcon1);
                cChoice = (int) (Math.random() * 3 + 1);
                mass = "";
                int n = (int) (Math.random()*7 + 2);
                for (int i = 0; i < n; i++)
                        mass = ":" + mass;
                switch (cChoice) {
                        case 1:
                                img2 = getImage(getDocumentBase(),"R.jpg");
                                computer.setText(mass+r);
                                break;
                        case 2:
                                img2 = getImage(getDocumentBase(),"P.jpg");
                                computer.setText(mass+p);
                                break;
                        case 3: 
                                img2 = getImage(getDocumentBase(),"S.jpg");
                                computer.setText(mass+s);
                                break;
                        default:
                                break;
                }
                tIcon2 = new ImageIcon(img2);
                t2Label.setIcon(tIcon2);
                
                int res = (cChoice - pChoice);
                switch (res){
                        case 0:
                                return "it is a TIE!";
                        case -1: case 2: 
                                return "You Win!";
                        case -2: case 1:
                                return "You Lose!";
                        default:
                                return "---------";
                }
                
        }
        
        
}