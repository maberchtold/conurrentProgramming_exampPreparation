package concurrentProgramming.exerciseN_reentrantReadWriteLockNews;

import java.util.Stack;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class NewsFeed {
    private Stack<News> newsFeed = new Stack<News>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock writeLock = lock.writeLock();
    private Lock readLock = lock.readLock();

    public void put(News news) {
        try {
            writeLock.lock();
            newsFeed.push(news);
        } finally {
            writeLock.unlock();
        }
    }

    public News read() {
        News news;
        try {
            readLock.lock();
            news = newsFeed.peek();
        } finally {
            readLock.unlock();
        }
        return news;
    }
}
