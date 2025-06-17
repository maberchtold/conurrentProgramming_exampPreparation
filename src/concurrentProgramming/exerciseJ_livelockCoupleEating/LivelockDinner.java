package concurrentProgramming.exerciseJ_livelockCoupleEating;

// Modified from: https://stackoverflow.com/questions/1036364/good-example-of-livelock

public class LivelockDinner {

    public static void main(String[] args) {
        final Diner husband = new Diner("Bob");
        final Diner wife = new Diner("Alice");

        final Spoon spoon = new Spoon(husband);

        new Thread(new Runnable() {
            public void run() {
                husband.eatWith(spoon, wife);
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                wife.eatWith(spoon, husband);
            }
        }).start();
    }
}
