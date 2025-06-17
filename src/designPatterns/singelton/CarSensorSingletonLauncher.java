package designPatterns.singelton;



import designPatterns.singelton.sensor_manager.*;
import designPatterns.singelton.sensors.RoadConditionSensor;
import designPatterns.singelton.sensors.SpeedSensor;
import designPatterns.singelton.sensors.TemperatureSensor;

/**
 * Lab 6
 * @author scz
 */
public class CarSensorSingletonLauncher {
    
    public CarSensorSingletonLauncher() {
    }
    
    public static void main(String[] args) {
        CarSensorSingletonLauncher launcher
                = new CarSensorSingletonLauncher();
        launcher.launch();
    }
    
    public void launch() {
        //this is not thread safe
        this.test(SimpleSingletonSensorsManager.getInstance());
        //this is thread safe but not performant
        this.test(SynchSingletonSensorsManager.getInstance());
        //this is thread safe
        this.test(EagerSingletonSensorsManager.getInstance());
        //this is thread safe
        this.test(DbleCheckedLockingSingletonSensorsManager.getInstance());
    }

    private void test(SingletonSensorManager manager) {
        manager.addSensor(new TemperatureSensor());
        manager.addSensor(new SpeedSensor());
        manager.addSensor(new RoadConditionSensor());
        manager.printState();
    }
}
