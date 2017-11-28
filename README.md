## Welcome to my Java library!!
---------------
### Completed GUI Thermometer. UPD(11/27/17)
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
###### Your program should look like this:

![Thermometer1](https://github.com/baohuy251210/LambertJavaProjects/blob/master/Thermometer/nbproject/Thermometer1.PNG)
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
