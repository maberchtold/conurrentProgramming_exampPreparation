package concurrentProgramming.exerciseD_joins;

import java.util.Stack;

public class FillingThread extends Thread {
    private Stack<Integer> sourceStack;

    private Stack<Integer> targetStack;

    private Thread otherThread;
    public FillingThread(Stack<Integer> sourceStack, Stack<Integer> targetStack, Thread otherThread) {
        this.sourceStack = sourceStack;
        this.targetStack = targetStack;
        this.otherThread = otherThread;
    }

    @Override
    public void run() {
        try {
            otherThread.join();
            System.out.println("--- Starting Filling back ---");
            while (!targetStack.isEmpty()) {
                System.out.println("From target stack to source stack " + sourceStack.push(targetStack.pop()));
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
