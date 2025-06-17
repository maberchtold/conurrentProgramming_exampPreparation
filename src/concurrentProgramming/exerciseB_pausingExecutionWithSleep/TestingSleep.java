package concurrentProgramming.exerciseB_pausingExecutionWithSleep;

// Illustrating https://docs.oracle.com/javase/tutorial/essential/concurrency/sleep.html
public class TestingSleep {
    public static void main(String[] args) {
        // Pausing the execution with sleep:
        (new Thread(new SleepMessages())).start();
    }
}
