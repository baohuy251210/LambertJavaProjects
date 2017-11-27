package thermometer;

/**
 *
 * @author Cyot49chv <your.name at your.org>
 */
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
