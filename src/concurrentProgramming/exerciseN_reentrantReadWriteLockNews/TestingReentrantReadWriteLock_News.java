package concurrentProgramming.exerciseN_reentrantReadWriteLockNews;

public class TestingReentrantReadWriteLock_News {
    public static void main(String[] args) {
        NewsFeed newsFeed = new NewsFeed();
        newsFeed.put(new News("START OF NEWS"));

        // Create one writing thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<200;i++) {
                    newsFeed.put(new News("News " + i));
                }
            }
        }).start();

        // Create several reading threads
        for (int i=0; i<20;i++) {
            new Thread((new Runnable() {
                @Override
                public void run() {
                    for (int i=0;i<20;i++) {
                        News news = newsFeed.read();
                        if (news != null) {
                            System.out.println("News read : "
                                    + newsFeed.read());
                        }
                    }
                }
            })).start();
        }
    }
}
