package equationsolver;

/**
 *
 * @author HuyBTran
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EquationSolver extends JApplet
        implements ActionListener {

        private JTextField display;
        private JLabel guide1Label = new JLabel("multiple operations supported"); //instruction added
        private JLabel guide2Label = new JLabel("operators: +-*/"); // instruction added
        private JLabel guide3Label = new JLabel("Solve for X not supported"); //instruction added
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
                if (display.getSelectedText() != null)
                        return;

                String text = display.getText();
                display.setText(text + " " + process(text));
                display.selectAll();
        }
        boolean anyE;
        String t1, op, t2;
        String lowOp = "+-";
        String highOp = "*/";

        // 5 + 3 * 4 * 2 + 1 = 30
        private String process(String s) {
                varInit();

                if (anySyntaxError(s))
                        anyE = true;
                s = removeSpaces(s);
                while (anyHighOp(s) != -1) {
                        s = calcOp(s, anyHighOp(s));
                        if (anyE)
                                return ARROW + "Syntax Error!";
                }
                while (anyLowOp(s) != -1) {
                        s = calcOp(s, anyLowOp(s));
                        if (anyE) {
                                return ARROW + "Syntax Error!";
                        }
                }
                if (anyE)
                        return ARROW + "Syntax Error!";
                else
                        return "= " + s;
        }

        private int anyHighOp(String str) {
                for (int i = 0; i < str.length(); i++) {
                        if (highOp.contains(str.substring(i, i + 1)))
                                return i;
                }
                return -1;
        }

        private int anyLowOp(String str) {
                for (int i = 0; i < str.length(); i++) {
                        if (lowOp.contains(str.substring(i, i + 1)))
                                return i;
                }
                return -1;
        }

        private String removeSpaces(String str) {
                while (str.contains(" ")) {
                        String cloner = str;
                        int index = str.indexOf(" ");
                        str = cloner.substring(0, index) + cloner.substring(index + 1);
                }
                return str;
        }

        private String calcOp(String str, int p) {
                int n = str.length();
                int l = 0, r = 0;
                int index = p;
                if (p == 0 || p == n - 1) {
                        anyE = true;
                        return str;
                }
                char c = str.charAt(index - 1);
                index--;
                String left = "", right = "";
                while (Character.isDigit(c) || c == '.') {
                        left = c + left;
                        index--;
                        if (index < 0)
                                break;
                        c = str.charAt(index);
                }
                index = p;
                c = str.charAt(p + 1);
                index++;
                while (Character.isDigit(c) || c == '.') {
                        right = right + c;
                        index++;
                        if (index >= n)
                                break;
                        c = str.charAt(index);
                }
                if (isNumber(left) && isNumber(right)) {
                        String res = calculate(str, left, str.charAt(p), right, p);
                        return res;
                } else {
                        anyE = true;
                        return str;
                }
        }

        //012345678910
        //5+3*4.2*2+1
        private String calculate(String str, String term1, char op, String term2, int OpPos) {
                String result = "";
                double res = 0;
                double a = Double.parseDouble(term1);
                double b = Double.parseDouble(term2);
                switch (op) {
                        case '+':
                                res = a + b;
                                break;
                        case '-':
                                res = a - b;
                                break;
                        case '*':
                                res = a * b;
                                break;
                        case '/':
                                if (b == 0) {
                                        anyE = true;
                                        return str;
                                } else {
                                        res = a / b;
                                        break;
                                }
                }
                result = str.substring(0, OpPos - term1.length()) + res + str.substring(OpPos + term2.length() + 1);

                return result;
        }

        private boolean isNumber(String str) {
                boolean result = true;
                try {
                        Double.parseDouble(str);
                } catch (NumberFormatException e) {
                        result = false;
                }
                return result;
        }

        private void varInit() {
                t1 = "";
                t2 = "";
                op = "";
        }

        private boolean anySyntaxError(String str) {
                anyE = false;
                for (int i = 0; i < str.length(); i++) {
                        char c = str.charAt(i);
                        String cs = str.substring(i, i + 1);
                        if (!cs.equals(" ")) {
                                if (!Character.isDigit(c) && !lowOp.contains(cs) && !highOp.contains(cs) && !cs.equals(".")) {
                                        return true;
                                }
                        }
                }
                return false;
        }

}
