package concurrentProgramming.exerciseP_executorDrums;

public class Drum implements Runnable {
    private String instrumentName;

    public Drum(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    @Override
    public void run() {
        System.out.println("Playing " + instrumentName);
    }
}
