// Code adapted from Benoît Fournier

package concurrentProgramming.exerciseS2_atomicIntegerArray;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class Operation implements Runnable{

    private AtomicIntegerArray atomicArray;
    private int[] nonAtomicArray;
    private int maxLength;

    public Operation(AtomicIntegerArray atomicArray, int[] nonAtomicArray) {
        this.atomicArray = atomicArray;
        this.nonAtomicArray = nonAtomicArray;
        this.maxLength = atomicArray.length();
    }

    @Override
    public void run() {
        // Increment the value of each index 100000 times
        for(int i = 0; i < 100000; i++){
            for(int j = 0; j < maxLength; j++) {
                atomicArray.incrementAndGet(j);
                nonAtomicArray[j]++;
            }
        }
    }
}
