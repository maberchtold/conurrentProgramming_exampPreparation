package designPatterns.singelton.sensors;

/**
 * @author scz
 */
public class TemperatureSensor implements ISensor {
    
    private static final String DESC = "Temperature sensor is running...";
    
    public TemperatureSensor() {
    }

    public String getDescription() {
        return DESC;
    }

    public String toString() {
        return this.getDescription();
    }
}
