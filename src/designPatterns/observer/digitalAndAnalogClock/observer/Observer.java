package designPatterns.observer.digitalAndAnalogClock.observer;

public interface Observer {
    void update(int hour, int minute, int second);
}
