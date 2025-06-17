package concurrentProgramming.exerciseP_executorDrums;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Partition {
    public static void main(String[] args) {
        Drum bassDrum = new Drum("Bass Drum");
        Drum floortom = new Drum("Floor Tom");
        Drum snareDrum = new Drum("Snare Drum");
        Drum rackTom = new Drum("Rack Tom");
        Drum hiHat = new Drum("Hi-Hat");
        Drum crashCymbal = new Drum("Crash Cymbal");
        Drum rideCymbal = new Drum("Ride Cymbal");
        Drum splashCymbal = new Drum("Splash Cymbal");
        Drum chinaCymbal = new Drum("China Cymbal");

        ScheduledExecutorService executor
                = Executors.newScheduledThreadPool(9);

        int initialDelay = 1000;
        int quaver = 500; // croche
        int crotchet = 1000; // noire
        int minim = 2000; // blanche
        TimeUnit unit = TimeUnit.MILLISECONDS;
        executor.scheduleAtFixedRate(bassDrum, initialDelay, quaver, unit);
        executor.scheduleAtFixedRate(floortom, initialDelay, crotchet, unit);
        executor.scheduleAtFixedRate(snareDrum, initialDelay, crotchet, unit);
        executor.scheduleAtFixedRate(rackTom, initialDelay, quaver, unit);
        executor.scheduleAtFixedRate(bassDrum, initialDelay, quaver, unit);
        executor.scheduleAtFixedRate(hiHat, initialDelay, quaver, unit);
        executor.scheduleAtFixedRate(crashCymbal, initialDelay, crotchet, unit);
        executor.scheduleAtFixedRate(rideCymbal, initialDelay, quaver, unit);
        executor.scheduleAtFixedRate(splashCymbal, initialDelay, minim, unit);
        executor.scheduleAtFixedRate(chinaCymbal, initialDelay, minim, unit);

        try {
            if (executor.awaitTermination(5, TimeUnit.SECONDS))
                System.out.println("Scheduler terminated correctly");
            else
                System.out.println("Timeout elapsed before termination.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executor.shutdown();
        System.out.println("Executor has shutdown");
    }
}
