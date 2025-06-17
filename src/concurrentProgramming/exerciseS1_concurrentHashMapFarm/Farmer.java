package concurrentProgramming.exerciseS1_concurrentHashMapFarm;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class Farmer implements Runnable {
    private ConcurrentHashMap<String, String> animalStallMap;
    private String name;
    private Random random = new Random();

    public Farmer(String name, ConcurrentHashMap<String, String> animalStallMap) {
        this.name = name;
        this.animalStallMap = animalStallMap;
    }

    @Override
    public void run() {
        while (true) {
            // Putting food within a random box
            String foodUnits = random.nextInt(100) + " food units";
            String chosenBox = "box" + random.nextInt(10);
            animalStallMap.putIfAbsent(chosenBox, foodUnits);
            System.out.println(name + " put " + foodUnits + " into " + chosenBox);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
