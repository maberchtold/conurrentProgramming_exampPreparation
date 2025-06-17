// Code adapted from Benoît Fournier

package concurrentProgramming.exerciseS2_atomicIntegerArray;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class TestConcurrentAtomic {

    public static void main(String[] args) {
        final int arrayLength = 5;
        // Create Atomic and Non-Atomic Arrays
        int[] nonAtomicArray = new int[arrayLength];

        //use: AtomicReference<String> atomicName = new AtomicReference<>("Alice"); for strings and AtomicReferenceArray for string arrays
        AtomicIntegerArray atomicArray = new AtomicIntegerArray(arrayLength);

        // Initialize values of the arrays
        for (int i = 0; i < atomicArray.length(); i++) {
            nonAtomicArray[i] = i ;
            atomicArray.set(i, i);
        }

        // Display starting values:
        System.out.println("Starting values atomic array: " + atomicArray);
        System.out.println("Starting values of non atomic array: " + Arrays.toString(nonAtomicArray));

        System.out.println("Creating 3 threads to increment the values withing those two arrays");
        // Create 3 threads that will increment the value at index 1
        Thread thread1 = new Thread(new Operation(atomicArray, nonAtomicArray));
        Thread thread2 = new Thread(new Operation(atomicArray, nonAtomicArray));
        Thread thread3 = new Thread(new Operation(atomicArray, nonAtomicArray));

        // Start threads
        thread1.start();
        thread2.start();
        thread3.start();

        // Wait for threads to finish
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Display final values
        System.out.println("Final values atomic array: " + atomicArray);
        System.out.println("Final values of non atomic array: " + Arrays.toString(nonAtomicArray));
    }

}
