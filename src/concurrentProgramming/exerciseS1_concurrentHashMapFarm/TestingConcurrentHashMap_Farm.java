package concurrentProgramming.exerciseS1_concurrentHashMapFarm;

import java.util.concurrent.ConcurrentHashMap;

public class TestingConcurrentHashMap_Farm {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> animalStallMap = new ConcurrentHashMap<>();

        new Thread(new Farmer("Verena", animalStallMap)).start();
        new Thread(new Farmer("Pierre", animalStallMap)).start();

        for (int i = 1; i < 10; i++)
            new Thread(new Cow("Cow" + i, animalStallMap)).start();
    }
}
