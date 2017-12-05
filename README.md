## Welcome to my Java library!!
---------------
### Rock — Paper - Scissors against Computer. UPD(12/5/17).

Good news, It is up after 2 hours struggling, I couldn't add images, and 2 hours later, I figured out that I cloned my project and put images in the clone one, not the one i was using :'< :'< :'<

[Project on Github](https://github.com/baohuy251210/LambertJavaProjects/tree/master/StringTest)

[StringTester.java](https://github.com/baohuy251210/LambertJavaProjects/blob/master/StringTest/src/stringtest/StringTester.java)

-LoL the name is just 4 fun.

Code: 
```java
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
```

-----------------
### MultipleExpressionsEquationSolver. UPD(12/5/17).

See in the folders. It's 2:40AM and I am exhausted to put code on here. 
UPD(12/5/17): Program code posted; Braces are not supported yet. I'm working on it.
Program is JApplet based, so look for EquationSolver below for instructions how to run it.

[Project on Github](https://github.com/baohuy251210/LambertJavaProjects/tree/master/MultipleExpressionsEquationSolver)

[MultipleExpressionEquationSolver.java (Github)](https://github.com/baohuy251210/LambertJavaProjects/blob/master/MultipleExpressionsEquationSolver/src/equationsolver/MultiExpressionsEquationSolver.java)

Code:
```java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MultiExpressionsEquationSolver extends JApplet
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
```
------------

### Simple Equation Solver with 2 numbers only. UPD(11/30/17).

This is an Applet program. Create a new Project, create a new .java file in your project (not the main java file), paste the code in and 
run that file using Shift-F6. (Run file individually)
UPD(11/30/17): Solve for X supported. Code with explanations

Explanations in comments.

[EquationSolver.java (Github)](https://github.com/baohuy251210/LambertJavaProjects/blob/master/EquationSolver/src/equationsolver/EquationSolver.java)

Code:
```java
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
                if (s.indexOf("=") != -1){ //if there is a "=", it is a equation to solve for x
                        int a = s.indexOf("="); // a is where the "=" in String s
                        t3 = s.substring(a+1); // t3 is the number after "=" sign
                        s = s.substring(0,a); // to make "separate(s)" work, s should be just "x + 2" instead of "x + 2 = 3";
                }
                separate(s); //below: divide String s into t1,t2,op
                if (isNumber(t1) && isNumber(t2)) { //below: check if t1 and t2 are numbers
                        return evaluate(t1, op, t2);
                }
                if (isNumber(t3)){ //if t3 is a number, then it is a equation to solve for x 
                        if (t1.contains("x")) 
                                return solveforx(t3,op,t2); //if t1 is x (ex: x + 2 = 3) then put in (3,+,2) 
                        else 
                                return solveforx(t3,op,t1);// if t2 is x (ex: 2 + x = 3) then put in (3,+,2)
                }
                else {
                        return ARROW + "Syntax error";
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

        private String solveforx(String term1, String op, String term2){ //solve for x with term1 is the number after the = sign;
                String result; 
                char opSign = op.charAt(0);
                double a = Double.parseDouble(term1);
                double b = Double.parseDouble(term2);
                switch (opSign){
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
```
---------------
### Completed GUI Thermometer. UPD(11/27/17)

![Image of GUI Thermometer](https://github.com/baohuy251210/LambertJavaProjects/blob/master/Thermometer/nbproject/Thermometer1.PNG)


The program is divided into 3 java files in one package
package thermometer;
put all .java files into one package and type like ```package thermometer```.

[Thermometer.java!](https://github.com/baohuy251210/LambertJavaProjects/blob/master/Thermometer/src/thermometer/Thermometer.java)  (Thermometer Class)
```java
public class Thermometer {
        private double degreesC;
        public void setCelsius(double degrees){
                degreesC = degrees;
        }
        public void setFahrenheit(double degrees){
                degreesC = (degrees - 32.0) * 5.0/ 9.0;
        }
        public double getCelsius(){
                return degreesC;
        }
        public double getFahrenheit(){
                return degreesC * 9.0 / 5.0 + 32.0;
        }
}
```

[GUIWindow.java!](https://github.com/baohuy251210/LambertJavaProjects/blob/master/Thermometer/src/thermometer/GUIWindow.java) (GUI making details)
```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIWindow extends JFrame {

        private Thermometer thermo = new Thermometer();

        private JLabel fLabel = new JLabel("Degrees Fahrenheit");
        private JLabel cLabel = new JLabel("Degrees Celsius");

        private JTextField fField = new JTextField("32.0");
        private JTextField cField = new JTextField("0.0");

        private JButton convertButton = new JButton("Convert>>>>");
        private JButton revertButton = new JButton("<<<<Convert");

        public GUIWindow() {
                JPanel mainPanel = new JPanel(new GridLayout(2, 2, 12, 6));
                mainPanel.add(fLabel);
                mainPanel.add(cLabel);
                mainPanel.add(fField);
                mainPanel.add(cField);
                JPanel buttonPanel = new JPanel();
                buttonPanel.add(convertButton);
                buttonPanel.add(revertButton);
                Container container = getContentPane();
                container.add(mainPanel, BorderLayout.CENTER);
                container.add(buttonPanel, BorderLayout.SOUTH);
                revertButton.addActionListener(new CelsiusListener());
                convertButton.addActionListener(new FahrenheitListener());
        }

        private class FahrenheitListener implements ActionListener {

                @Override
                public void actionPerformed(ActionEvent e) {
                        try {
                                String input = fField.getText();
                                double fah = Double.parseDouble(input);
                                thermo.setFahrenheit(fah);
                                double celsius = thermo.getCelsius();
                                String result = String.format("%.3f", celsius);//String Format
                                cField.setText(result);
                        } catch (Exception e1) {
                                CallError("Bad number format!");
                        }
                }
        }

        private class CelsiusListener implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent e) {
                        try {
                                String input = cField.getText();
                                double cel = Double.parseDouble(input);
                                thermo.setCelsius(cel);
                                double fahrenheit = thermo.getFahrenheit();
                                String result = String.format("%.3f", fahrenheit);//String Format
                                fField.setText(result);
                        } catch (Exception e1) {
                                CallError("Bad number format!");
                        }
                }
        }

        void CallError(Object line) {
                JOptionPane.showMessageDialog(GUIWindow.this, line, "Temperature Converter", JOptionPane.ERROR_MESSAGE);
        }
}
```

[GUImain.java!](https://github.com/baohuy251210/LambertJavaProjects/blob/master/Thermometer/src/thermometer/GUImain.java) (Compile File)
```java
import javax.swing.*;
import java.awt.*;
public class GUImain {

        public static void main(String[] args) {
                GUIWindow gui = new GUIWindow();
                gui.setTitle("Temperature Converter");
                gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gui.pack();
                gui.setVisible(true);
        }
        
}
```

----------
### File Input and Output. UPD(11/26/17)
The program below use my .txt files as input and output files.
It will read 2 integers from the input and print out the larger integer to output until there's nothing left to read.
```
throws IOException
```
is included because the file will not read from standard output of the program.

Code:
```java
import java.io.*;
import java.util.*;
public class File {
        /**
         * @param args the command line arguments
         * @throws java.io.IOException
         */
        public static void main(String[] args) throws IOException {
                File input = new File("C:\\JavaText\\testin.txt");
                File output= new File("C:\\JavaText\\testou.txt");
                PrintWriter write = new PrintWriter(output);
                Scanner read = new Scanner(input);
                while (read.hasNext()){
                        int firstInt = read.nextInt();
                        int secInt = read.nextInt();
                        write.println(max(firstInt, secInt));
                }
                write.close();
        }
        static int max(int a, int b){
                return Math.max(a, b);
        }
        
}
```
[View code on Github!](https://github.com/baohuy251210/LambertJavaProjects/blob/master/Fil%C3%A9/src/FileInOut/FileInOut.java)
#### Example Testcase:
##### Test 1
testin.txt
```
3 4 
4 6
10 123
3 2
15 61
100 1000
```
testout.txt
```
4
6
123
3
61
1000
```
---
---
## Decimal to Hexadecimal. UPD(11/26/17)
Using .txt files as input and output. This program change the value from Decimal base to Hexadecimal base 
Explain: 
The code use a String locate = "0123456789ABCDEF", which contains all the characters in hexadecimal base.
Each turn, the program checks if it's gone through the entire integer (decimal base) or not. Then, by using ```dec%16```, it puts in the result string the character at ```dec%16```. 
Best way is to try it.
Code:
```java
import java.util.*;
import java.io.*;
public class DectoHex {

        /**
         * @param args the command line arguments
         * @throws java.io.IOException
         */
        public static void main(String[] args) throws IOException {
                File input = new File("C:\\JavaText\\testin.txt");
                File output = new File("C:\\JavaText\\testou.txt");
                Scanner read = new Scanner(input);
                PrintWriter cout = new PrintWriter(output);     
                 
                int dec = read.nextInt();
                String locate = "0123456789ABCDEF";
                String res = "";
                while (dec > 0){
                        res = locate.charAt(dec%16) + res;
                        dec /= 16;
                }
                cout.print(res);
                cout.close();
        }
        
}
```
[View code on Github!](https://github.com/baohuy251210/LambertJavaProjects/blob/master/DectoHex/src/dectohex/DectoHex.java)
#### Example testcases:
##### Test 1:
testin.txt
```
8
```
testout.txt
```
8
```
##### Test 2:
testin.txt
```
110
```
testout.txt
```
6E
```
----
