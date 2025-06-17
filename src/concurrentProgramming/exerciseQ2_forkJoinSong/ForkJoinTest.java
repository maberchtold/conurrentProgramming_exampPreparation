package concurrentProgramming.exerciseQ2_forkJoinSong;

// Inspired by https://www.baeldung.com/java-fork-join

import java.util.concurrent.ForkJoinPool;

public class ForkJoinTest {
    public static void main(String[] args) {
        String song = "Georges Brassens (1964) - Les Copains d'abord"
                + "Non, ce n'était pas le radeau"
                + "De la Méduse, ce bateau"
                + "Qu'on se le dise au fond des ports"
                + "Dise au fond des ports"
                + "Il naviguait en père peinard"
                + "Sur la grand-mare des canards"
                + "Et s'appelait les Copains d'abord"
                + "Les Copains d'abord";

        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of available processors: " + processors);
        ForkJoinPool pool = new ForkJoinPool(processors);

        long startTime = System.currentTimeMillis();
        pool.invoke(new CustomRecursiveAction(song));
        long endTime = System.currentTimeMillis();

        System.out.println("Fork/Join tasks took "
                + (endTime - startTime)
                + " milliseconds.");
    }
}
