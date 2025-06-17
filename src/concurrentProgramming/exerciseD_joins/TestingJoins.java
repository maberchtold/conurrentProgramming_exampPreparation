package concurrentProgramming.exerciseD_joins;

// Illustrating https://docs.oracle.com/javase/tutorial/essential/concurrency/join.html

import java.util.Stack;

public class TestingJoins {
    public static void main(String[] args) {
        Stack<Integer> sourceStack = new Stack<Integer>();
        Stack<Integer> targetStack = new Stack<Integer>();

        // Populating the first sourceStack
        for (int i = 1; i <= 10; i++) {
            sourceStack.push(i);
        }

        Thread emptyingThread = new EmptyingThread(sourceStack, targetStack);
        Thread fillingThread = new FillingThread(sourceStack, targetStack, emptyingThread);
        emptyingThread.start();
        fillingThread.start();
    }
}
