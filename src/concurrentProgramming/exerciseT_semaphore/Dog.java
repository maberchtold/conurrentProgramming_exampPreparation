package concurrentProgramming.exerciseT_semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Dog implements Runnable {
    private String name;
    private Semaphore[] bowlsSemaphores;
    private Random random = new Random();

    public Dog(String name, Semaphore[] bowlsSemaphores) {
        this.name = name;
        this.bowlsSemaphores = bowlsSemaphores;
    }

    @Override
    public void run() {
        Semaphore semaphore;
        int bowlNumber;
        while (true) {
            // Eating in a random bowl
            bowlNumber = random.nextInt(3);
            semaphore = bowlsSemaphores[bowlNumber];
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name + " is eating in bowl " + bowlNumber);
            semaphore.release();
        }
    }
}
