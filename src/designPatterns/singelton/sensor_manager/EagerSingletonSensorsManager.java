package designPatterns.singelton.sensor_manager;

/**
 * @author scz
 */
public class EagerSingletonSensorsManager extends SingletonSensorManager {

    private static SingletonSensorManager instance = new EagerSingletonSensorsManager();
    
    private EagerSingletonSensorsManager() {
    	super();
    }

    public static SingletonSensorManager getInstance() {
        return instance;
    }
}
