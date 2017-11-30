package equationsolver;

/**
 *
 * @author HuyBTran
 */
/**
 * This program evaluates arithmetic expressions
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EquationSolver extends JApplet
        implements ActionListener {

        private JTextField display;
        private JLabel guide1Label = new JLabel("Use only 2 numbers please!"); //instructions added
        private JLabel guide2Label = new JLabel("operators: +-*/%^"); // instructions added
        private static final String ARROW = "==> ";

        @Override
        public void init() {
                display = new JTextField(40);
                display.setFont(new Font("Monospaced", Font.BOLD, 14));
                display.setBackground(Color.white);
                display.setForeground(Color.blue);
                display.addActionListener(this);
                display.setText("0.0 + 0.0 = 0.0");
                Container c = getContentPane();
                c.setLayout(new FlowLayout());
                c.add(display);
                c.add(guide1Label);
                c.add(guide2Label);
                display.selectAll();
                display.requestFocus();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                if (display.getSelectedText() != null) {
                        return;
                }

                String text = display.getText();
                display.setText(text + " " + process(text));
                display.selectAll();
        }
        
        String t1, op, t2;
        //t1 is the first number
        //op is the operator
        //t2 is the second number
        private String process(String s) {
                t1 = "";
                t2 = "";
                op = "";
                separate(s); //below 
                if (isNumber(t1) && isNumber(t2)) { //below: check if t1 and t2 are numbers
                        return evaluate(t1, op, t2);
                } else {
                        return ARROW + "Syntax Error";
                }
        }

        private boolean isNumber(String str) { //Check if a string str is a number
                boolean result = true;
                try {
                        Double.parseDouble(str);  //Try to turn the string to a number
                } catch (Exception e) { //If cannot transform it 
                        result = false; //then it is not a number :)
                }
                return result; //Return true if it is a number
        }

        private void separate(String str) { //get t1, op, t2
                int n = str.length(); 
                String sign = "+-*/%^";  //A string contains all the operators that can be used
                for (int i = 0; i < n; i++) {
                        if (sign.indexOf(str.substring(i, i + 1)) != -1) { // If str at index i is a operator supported
                                t1 = str.substring(0, i);     // then I seperate the string and get the values :)
                                op = str.substring(i, i + 1); 
                                t2 = str.substring(i + 1);
                                break;
                        }
                }
        }

        private String evaluate(String term1, String op, String term2) {
                String result;
               
                char opSign = op.charAt(0);
                double a = Double.parseDouble(term1);
                double b = Double.parseDouble(term2);

                switch (opSign) {
                        case '+':
                                result = "= " + (a + b);
                                break;

                        case '-':
                                result = "= " + (a - b);
                                break;
                        case '*':
                                result = "= " + (a * b);
                                break;
                        case '/':
                                if (b == 0) {
                                        result = ARROW + "Invalid division";
                                } else {
                                        result = "= " + (a / b);
                                }
                                break;
                        case '%':
                                if (b == 0) {
                                        result = ARROW + "Invalid modulo";
                                } else {
                                        result = "= " + (a % b);
                                }
                                break;
                        case '^':
                                result = "= " + Math.pow(a, b);
                                break;
                        default:
                                result = ARROW + "Syntax error";
                                break;
                }
                return result;
        }
}
