package concurrentProgramming.exerciseM_reentrantLockVehicle;

import java.util.concurrent.locks.ReentrantLock;

public class Vehicle {
    private ReentrantLock reservationLock = new ReentrantLock();
    int counter = 0;

    public void use(String name) {
        reservationLock.lock();
        try {
            // Critical section here
            System.out.println(name + " is using the vehicle");
        } finally {
            System.out.println(name + " is releasing the vehicle");
            reservationLock.unlock();
        }
    }
}