package concurrentProgramming.exerciseX_phaserBikeTrip;

import java.util.Random;
import java.util.concurrent.Phaser;

public class FamilyMemberThread implements Runnable {

    private Phaser phaser;
    private String name;
    private int steps;

    public FamilyMemberThread(Phaser phaser, String name, int steps) {
        this.phaser = phaser;
        this.name = name;
        this.steps = steps;

        phaser.register();
        new Thread(this).start();
    }

    @Override
    public void run() {
        for(int i = 0; i < steps; i++)
        {
            System.out.println(name + ": Step " + (i+1) + " Started");

            if (i == steps-1) {
                phaser.arriveAndDeregister();
            } else {
                phaser.arriveAndAwaitAdvance();
            }

            Random random = new Random();
            int time = random.nextInt(5) + 1; // range 1-5
            try {
                Thread.sleep(time * 1000);
            }
            catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
