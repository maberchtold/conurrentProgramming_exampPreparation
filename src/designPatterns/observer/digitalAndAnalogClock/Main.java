package designPatterns.observer.digitalAndAnalogClock;

import designPatterns.observer.digitalAndAnalogClock.clock.AnalogClock;
import designPatterns.observer.digitalAndAnalogClock.clock.DigitalClock;
import designPatterns.observer.digitalAndAnalogClock.timer.MyTimer;

public class Main {


    public static void main(String[] args) {
        MyTimer clockTimer = new MyTimer();

        new AnalogClock(clockTimer);
        new DigitalClock(clockTimer);
    }
}