package concurrentProgramming.exerciseS1_concurrentHashMapFarm;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class Cow implements Runnable {
    private String name;
    private ConcurrentHashMap<String, String> animalStallMap;
    private Random random = new Random();

    public Cow(String name, ConcurrentHashMap<String, String> animalStallMap) {
        this.name = name;
        this.animalStallMap = animalStallMap;
    }

    @Override
    public void run() {
        while (true) {
            // Eating a random box
            String food = animalStallMap.remove("box" + random.nextInt(10));
            System.out.println(name + " ate " + (food == null ? "nothing" : food));
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
