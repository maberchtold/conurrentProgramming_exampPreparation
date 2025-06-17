package concurrentProgramming.exerciseO_reentrantLockWithConditions_numberProducersConsumers;

public class NumberConsumer implements Runnable {
    private LockedWithConditionsStack stack;

    public NumberConsumer(LockedWithConditionsStack stack) {
        this.stack = stack;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Pop from stack: " + stack.popFromStack());
        }
    }
}
