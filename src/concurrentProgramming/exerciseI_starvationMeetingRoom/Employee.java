package concurrentProgramming.exerciseI_starvationMeetingRoom;

public class Employee extends Thread {
    private String name;
    private String room;
    private int exageratedTimeUsageFactor;

    public Employee(String name, String room, int exageratedTimeUsageFactor) {
        this.name = name;
        this.room = room;
        this.exageratedTimeUsageFactor = exageratedTimeUsageFactor;
    }

    public void useRoom(int time){
        synchronized (room) {
            System.out.println(name + " uses room for " + time + " seconds.");

            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void run() {
        System.out.println(name + " thread started.");
        while (true) {
            useRoom(100*exageratedTimeUsageFactor);
        }
    }
}
