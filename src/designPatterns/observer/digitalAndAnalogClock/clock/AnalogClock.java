package designPatterns.observer.digitalAndAnalogClock.clock;
import designPatterns.observer.digitalAndAnalogClock.observer.Observer;
import designPatterns.observer.digitalAndAnalogClock.observer.Subject;


public class AnalogClock implements Observer {
    private int hour;
    private int minute;
    private int second;

    public AnalogClock(Subject clockTimer) {
        clockTimer.registerObserver(this);
    }

    public void update(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        display();
    }

    private void display() {
        System.out.println("ANALOG CLOCK: Hour : " + hour + " / Min : " + minute + " / Sec : " + second);
    }
}
