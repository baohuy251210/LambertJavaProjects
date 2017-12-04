package stringtest;

/**
 *
 * @author Cyot49chv
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StringTester extends JApplet
        implements ActionListener {

        private JTextField input = new JTextField(20);
        private JTextField computer = new JTextField(20);        
        JLabel Intro = new JLabel("Rock-Paper-Scissors!");
        JLabel inLabel = new JLabel(" Player:");
        JLabel outLabel = new JLabel("Computer:");
        JLabel resLabel = new JLabel("--------------");

        @Override
        public void init() {
                input.setFont(new Font("Monospaced", Font.BOLD, 36));
                input.setBackground(Color.white);
                input.addActionListener(this);
                input.selectAll();
                
                computer.setFont(new Font("Monospaced", Font.BOLD, 36));
                computer.setBackground(Color.white);
                computer.setEditable(false);

                Container c = getContentPane();
                this.setSize(500, 300);
                c.setLayout(new FlowLayout());
                
                Intro.setFont(new Font("Monospaced", Font.BOLD,36));
                inLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
                outLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
                resLabel.setFont(new Font("Monospaced", Font.BOLD,36));
                c.add(Intro);
                c.add(inLabel);
                c.add(input);
                c.add(outLabel);
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
                if (str.equals(r))
                        pChoice = 1;
                else if (str.equals(p))
                        pChoice = 2;
                else if (str.endsWith(s))
                        pChoice = 3;
                else 
                        return "Error!";
                cChoice = (int) (Math.random() * 3 + 1);
                switch (cChoice) {
                        case 1:
                                computer.setText(mass+r);
                                break;
                        case 2:
                                computer.setText(mass+p);
                                break;
                        case 3: 
                                computer.setText(mass+s);
                                break;
                        default:
                                break;
                }
                int n = (int) (Math.random()*7 + 2);
                for (int i = 0; i < n; i++)
                        mass = ":" + mass;
                
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