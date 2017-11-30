## Welcome to my Java library!!
---------------
### Simple Equation Solver with 2 numbers only. UPD(11/29/17).

This is Applet program. Create a new Project, create a new .java file in your project (not the main java file), paste the code in and 
Run that file using Shift-F6.

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
