package concurrentProgramming.exerciseT_semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Breeder implements Runnable {
    private Semaphore[] bowlsSemaphores;
    private String name;
    private Random random = new Random();

    public Breeder(String name, Semaphore[] bowlsSemaphores) {
        this.name = name;
        this.bowlsSemaphores = bowlsSemaphores;
    }

    @Override
    public void run() {
        Semaphore semaphore;
        int bowlNumber;
        while (true) {
            // Putting food within a random bowl
            bowlNumber = random.nextInt(3);
            semaphore = bowlsSemaphores[bowlNumber];
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name + " puts food into bowl " + bowlNumber);
            semaphore.release();
        }
    }
}
