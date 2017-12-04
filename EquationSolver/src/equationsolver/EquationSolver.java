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
        private JLabel guide1Label = new JLabel("Use only 2 numbers please!"); //instruction added
        private JLabel guide2Label = new JLabel("operators: +-*/%^"); // instruction added
        private JLabel guide3Label = new JLabel("Solve for X supported"); //instruction added
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
                c.add(guide3Label);
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

        String t1, op, t2, t3;

        //t1 is the first number
        //op is the operator
        //t2 is the second number
        private String process(String s) {
                t1 = "";
                t2 = "";
                op = "";
                t3 = "";
                s = SolveCheck(s); //below: if s doesn't contain any "=" sign, then return s, else t3 becomes number after "=" sign 
                separate(s); //below: divide String s into t1,t2,op
                if (isNumber(t1) && isNumber(t2)) { //below: check if t1 and t2 are numbers
                        return evaluate(t1, op, t2);
                }
                if (isNumber(t3)) { //if t3 is a number, then it is a equation to solve for x 
                        if (t1.contains("x")) {
                                return solveforx(t3, op, t2); //if t1 is x (ex: x + 2 = 3) then put in (3,+,2) 
                        } else {
                                return solveforx(t3, op, t1);// if t2 is x (ex: 2 + x = 3) then put in (3,+,2)
                        }
                } else
                        return ARROW + "Syntax error";
        }

        private String SolveCheck(String str) {
                if (str.contains("=")) { //if there is a "=", it is a equation to solve for x
                        int a = str.indexOf("="); // a is where the "=" in String s
                        t3 = str.substring(a + 1); // t3 is the number after "=" sign
                        str = str.substring(0, a); // to make "separate(s)" work, s should be just "x + 2" instead of "x + 2 = 3";
                }
                return str;
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

        private String solveforx(String term1, String op, String term2) { //solve for x with term1 is the number after the = sign;
                String result;
                char opSign = op.charAt(0);
                double a = Double.parseDouble(term1);
                double b = Double.parseDouble(term2);
                switch (opSign) {
                        case '+':
                                result = ";x = " + (a - b);
                                break;
                        case '-':
                                result = ";x = " + (a + b);
                                break;
                        case '*':
                                result = ";x = " + (a / b);
                                break;
                        case '/':
                                result = ";x = " + (a * b);
                                break;
                        default:
                                result = ARROW + "Not supported";
                                break;
                }
                return result;
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
