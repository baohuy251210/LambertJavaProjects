package thermometer;

/**
 *
 * @author Cyot49chv
 */
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
