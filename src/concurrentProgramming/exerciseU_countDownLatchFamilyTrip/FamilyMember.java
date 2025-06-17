package concurrentProgramming.exerciseU_countDownLatchFamilyTrip;

import java.util.concurrent.CountDownLatch;

public class FamilyMember implements Runnable {
    String name;
    private Vehicle vehicle;
    private CountDownLatch countDownLatch;

    public FamilyMember(String name, Vehicle vehicle, CountDownLatch countDownLatch) {
        this.name = name;
        this.vehicle = vehicle;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        this.vehicle.addSuitcase(name + "'s suitcase");
        countDownLatch.countDown();
    }
}
