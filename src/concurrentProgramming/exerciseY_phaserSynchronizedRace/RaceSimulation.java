package concurrentProgramming.exerciseY_phaserSynchronizedRace;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class RaceSimulation {
    public static final int NUM_RUNNERS = 4;
    public static final int NUM_STAGES = 3;

    public static void main(String[] args) {
        System.out.println("Welcome to the Synchronized Race!");

        try {
            // Prompt the user for inputs
            int numRunners = NUM_RUNNERS;
            int numStages = NUM_STAGES;

            // Create a phaser
            Phaser phaser = new Phaser();
            phaser.register();

            // Create and start the runner threads
            ExecutorService executor = Executors.newFixedThreadPool(NUM_RUNNERS);

            for (int i = 1; i <= numRunners; i++) {
                executor.execute(new Runner(i, phaser));
            }

            // Wait for all runners to complete the race
            for (int i = 1; i <= numStages; i++) {
                System.out.println("Stage " + i + " started...");
                phaser.arriveAndAwaitAdvance();
                System.out.println("All runners finished stage " + i);
            }
            phaser.arriveAndDeregister();
            executor.shutdown();
            System.out.println("All runners have completed the race!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

