package concurrentProgramming.exerciseK_guardedBlocksManagingPackagesInPostOffice;

import java.util.LinkedList;
import java.util.Queue;

public class PostOffice {
    private int capacity; // number of packages that can be stored within the postoffice

    public PostOffice(int capacity) {
        this.capacity = capacity;
    }

    private Queue<Package> queueOfPackages = new LinkedList<Package>();
    public synchronized void register(Package aPackage) {
        while (queueOfPackages.size() > capacity ) {
            try {
                //if locks are used you can write lock.wait to release the lock
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        queueOfPackages.add(aPackage);
        notifyAll();
    }

    public synchronized void takeForDelivery() {
        while (queueOfPackages.size() <= 0 ) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(queueOfPackages.remove());
        notifyAll();
    }
}
