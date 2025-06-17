package concurrentProgramming.exerciseA_definingAndStartingAThread;

import importPackage.Colors;

/* The best solution to create a thread is to create a class
    that implements the interface Runnable.
 */
public class HelloRunnable implements Runnable {

    @Override
    public void run() {
        System.out.print(Colors.ANSI_RED);
        System.out.println('\t' + "Hello from a Runnable object!");
    }
}
