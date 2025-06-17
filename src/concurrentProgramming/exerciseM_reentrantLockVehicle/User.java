package concurrentProgramming.exerciseM_reentrantLockVehicle;

public class User implements Runnable {
    private String name;
    private Vehicle vehicle;

    public User(String name, Vehicle vehicle) {
        this.name = name;
        this.vehicle = vehicle;
    }

    @Override
    public void run() {
        while (true) {
            vehicle.use(this.name);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
