package concurrentProgramming.exerciseQ4_ForkJoinConcurrentArraySum;

import java.util.Random;
import java.util.concurrent.*;

public class ConcurrentArraySum {
    public static void main(String[] args) {
        int arraySize = 100000000; // Change this to desired array size
        long[] array = new long[arraySize];

        Random random = new Random();
        // Initialize array with values (e.g., using random numbers)
        for (int i = 0; i < arraySize; i++) {
            array[i] = random.nextInt(1000); // Write a random int number below 1000
        }

        ForkJoinPool pool = new ForkJoinPool();
        ArraySumTask task = new ArraySumTask(array, 0, array.length);
        long totalSum = pool.invoke(task);

        System.out.println("Array Size: " + arraySize);
        System.out.println("Concurrent Sum: " + totalSum);
    }
}
