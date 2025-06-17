package concurrentProgramming.exerciseO_reentrantLockWithConditions_numberProducersConsumers;

// Modified from: https://www.baeldung.com/java-concurrent-locks

import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockedWithConditionsStack {
    private Stack<Integer> stack = new Stack<Integer>();
    private int CAPACITY = 5;

    ReentrantLock lock = new ReentrantLock();
    Condition stackEmptyCondition = lock.newCondition();
    Condition stackFullCondition = lock.newCondition();

    public LockedWithConditionsStack(int CAPACITY) {
        this.CAPACITY = CAPACITY;
    }

    public void pushToStack(Integer item) {
        try {
            lock.lock();
            while (stack.size() == CAPACITY) {
                stackFullCondition.await();
            }
            stack.push(item);
            stackEmptyCondition.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public Integer popFromStack() {
        try {
            lock.lock();
            while (stack.size() == 0) {
                stackEmptyCondition.await();
            }
            return stack.pop();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            stackFullCondition.signalAll();
            lock.unlock();
        }
    }
}
