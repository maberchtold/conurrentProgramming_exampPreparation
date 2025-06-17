package concurrentProgramming.exerciseY_phaserSynchronizedRace;

import java.util.Random;
import java.util.concurrent.Phaser;

class Runner extends Thread {
    private int id;
    private Phaser phaser;
    public Runner(int id, Phaser phaser) {
        this.id = id;
        this.phaser = phaser;
        phaser.register();
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= RaceSimulation.NUM_STAGES; i++) {
                System.out.println("Runner " + id + " has started running stage " + i);

                // Simulate running process
                Random random = new Random();
                int duration = random.nextInt(5) + 1;
                Thread.sleep(duration * 1000);

                System.out.println("Runner " + id + " has finished running stage " + i);

                // Signal completion of the current stage
                phaser.arriveAndAwaitAdvance();
            }
            phaser.arriveAndDeregister();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

