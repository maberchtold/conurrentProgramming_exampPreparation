package designPatterns.singelton.sensor_manager;

/**
 * @author scz
 */
public class SynchSingletonSensorsManager extends SingletonSensorManager {

    private static SingletonSensorManager instance;
    
    private SynchSingletonSensorsManager() {
    	super();
    }

    public static synchronized SingletonSensorManager getInstance() {
        if (instance == null) {
            instance = new SynchSingletonSensorsManager();
        }
        return instance;
    }
}
