package concurrentProgramming.exerciseO_reentrantLockWithConditions_numberProducersConsumers;

public class NumberProducer implements Runnable {
    private LockedWithConditionsStack stack;

    public NumberProducer(LockedWithConditionsStack stack) {
        this.stack = stack;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Push to stack " + i);
            stack.pushToStack(i);
        }
    }
}
