package designPatterns.observer.digitalAndAnalogClock.timer;

public interface ClockTimer {
    int getHour();
    int getMinute();
    int getSecond();
    void tick();
}