package concurrentProgramming.exerciseM_reentrantLockVehicle;

public class TestingReantrantLockVehicle {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        User husband = new User("Romeo", vehicle);
        User wife = new User("Juliette", vehicle);
        (new Thread(husband)).start();
        (new Thread(wife)).start();
    }
}
