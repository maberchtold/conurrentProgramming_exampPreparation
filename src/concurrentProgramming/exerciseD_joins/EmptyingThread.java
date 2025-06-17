package concurrentProgramming.exerciseD_joins;

import java.util.Stack;

public class EmptyingThread extends Thread {
    private Stack<Integer> sourceStack;
    private Stack<Integer> targetStack;
    private Thread otherThread;

    public EmptyingThread(Stack<Integer> sourceStack, Stack<Integer> targetStack) {
        this.sourceStack = sourceStack;
        this.targetStack = targetStack;
    }

    @Override
    public void run() {
        while (!sourceStack.isEmpty()) {
            System.out.println("Number popped from source stack and pushed to target stack: "
                    + targetStack.push(sourceStack.pop()));
        }
    }
}
