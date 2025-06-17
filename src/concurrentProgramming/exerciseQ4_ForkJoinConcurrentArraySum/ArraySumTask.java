package concurrentProgramming.exerciseQ4_ForkJoinConcurrentArraySum;

import java.util.concurrent.*;

// ArraySumTask class to calculate the sum of elements in an array using ForkJoin
class ArraySumTask extends RecursiveTask<Long> {
    private static final int THRESHOLD = 1000; // Adjust threshold as needed
    private final long[] array;
    private final int start;
    private final int end;

    public ArraySumTask(long[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - start <= THRESHOLD) {
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else {
            int mid = start + (end - start) / 2;

            ArraySumTask leftTask = new ArraySumTask(array, start, mid);
            ArraySumTask rightTask = new ArraySumTask(array, mid, end);

            leftTask.fork();              // runs the left task in a separate thread
            long rightResult = rightTask.compute(); // runs the right task NOW in the current thread
            long leftResult = leftTask.join();      // waits for the left task to finish

            return leftResult + rightResult;
        }
    }
}