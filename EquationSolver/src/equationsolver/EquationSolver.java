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
import java.util.StringTokenizer;

public class EquationSolver extends JApplet
        implements ActionListener {

        private JTextField display;
        private static final String ARROW = "==> ";

        public void init() {
                display = new JTextField(40);
                display.setFont(new Font("Monospaced", Font.BOLD, 14));
                display.setBackground(Color.white);
                display.setForeground(Color.blue);
                display.addActionListener(this);
                display.setText("Equation Solver by s/o");
                Container c = getContentPane();
                c.setLayout(new FlowLayout());
                c.add(display);

// Select the whole display text:
                display.selectAll();

// Prepare for typing:
                display.requestFocus();
        }

        public void actionPerformed(ActionEvent e) {
// Skip if display has any selected text:
                if (display.getSelectedText() != null) {
                        return;
                }

                String text = display.getText();
                display.setText(text + " " + process(text));
                display.selectAll();
        }

        private String process(String s) {
                separate(s);
                if (isNumber(t1) && isNumber(t2)){
                        return evaluate(t1,op,t2);
                }
                else return ARROW + "Syntax Error" + t1;
        }

        private boolean isNumber(String str) {
                boolean result = true;
                try {
                        Double.parseDouble(str);
                } catch (Exception e) {
                        result = false;
                }
                return result;
        }
        //
        String t1, op, t2;

        private void separate(String str) {
                int n = str.length();
                for (int i = 0; i < n; i++) {
                        if (!Character.isDigit(str.charAt(i)) && !(str.substring(i, i + 1)).equals(".")) {
                                t1 = str.substring(0, i);
                                op = str.substring(i, i + 1);
                                t2 = str.substring(i + 1);
                        }
                }
        }

        /**
         * Evaluates an arithmetic expression in the form "a +/- b" and returns
         * the result in the form "= c" or an error message.
         */
        private String evaluate(String term1, String op, String term2) {
                String result;

                if (op.length() != 1) {
                        return ARROW + "Syntax error";
                }

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
                        default:
                                result = ARROW + opSign + "is Invalid operation";
                                break;
                }
                return result;
        }
}
