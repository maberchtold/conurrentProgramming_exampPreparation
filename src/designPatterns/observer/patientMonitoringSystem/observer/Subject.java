package designPatterns.observer.patientMonitoringSystem.observer;

/**
 *
 * @author scz
 */
public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
