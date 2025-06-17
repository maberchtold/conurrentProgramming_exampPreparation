package concurrentProgramming.exerciseU_countDownLatchFamilyTrip;

import java.util.concurrent.CountDownLatch;

public class TestingCountDownLatch_FamilyTrip {
    public static void main(String[] args) throws InterruptedException {
        Vehicle seatAlhambra = new Vehicle();
        seatAlhambra.printVehicleContent();
        String[] family = {"Jean", "Anna", "Joseph", "Martha", "Eleonore", "Paul", "Catarina"};
        CountDownLatch countDownLatch = new CountDownLatch(family.length);

        for (String name : family)
            new Thread(new FamilyMember(name, seatAlhambra, countDownLatch)).start();
        countDownLatch.await();
        seatAlhambra.printVehicleContent();
        System.out.println("Family trip can start");
    }
}
