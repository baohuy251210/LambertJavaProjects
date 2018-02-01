package skillfood3;

import java.util.Arrays;
import javax.swing.JTextField;

/**
 *
 * @author .
 */
public class Item {

        private JTextField[] text = new JTextField[6];
        private int [] a = new int[6];
        private double[] price = {2.5, 3.5, 5.0, 2.0, 2.0, 0};
        private String[] s = new String[6];
        public Item(JTextField[] mess) {
                int n = 0;
                text = mess;
        }

        public boolean Transform() {
                
                boolean parsed = true;
                for (int i = 0; i < 6; i++) {
                        try {
                                a[i] = Integer.parseInt(text[i].getText());
                        } catch (NumberFormatException e) {
                                parsed = false;
                                break;
                        }
                }
                return parsed;
        }

        public double Calculate() {
                double res = 0; 
                for (int i = 0; i < a.length; i++) {
                        res += this.a[i]*this.price[i];
                }
                res = Math.round(res * 100.0) / 100.0;
                return res;
        }
        public String toString(){
                return Double.toString(this.Calculate());
        }

}
