package concurrentProgramming.exerciseA_definingAndStartingAThread;

public class TestingSimpleThreads {
    public static void main(String[] args) {
        System.out.println("Hello world from the main thread !");

        // Runnable object:
        new Thread(new HelloRunnable()).start();

        // Subclass thread:
        new HelloThread().start();
    }
}
