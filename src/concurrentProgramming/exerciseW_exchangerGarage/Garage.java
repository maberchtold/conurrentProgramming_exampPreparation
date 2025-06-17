package concurrentProgramming.exerciseW_exchangerGarage;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ThreadLocalRandom;

public class Garage implements Runnable {
    private Car myCars[] = new Car[] {new Car("Seat Alhambra"),
            new Car("BMW Mini"),
            new Car("Tesla 3")};
    
    private Exchanger<Car> exchanger;

    public Garage(Exchanger<Car> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            int replacementCarAvailable = ThreadLocalRandom.current().nextInt(0, 2);
            Car carToRepair = exchanger.exchange(myCars[replacementCarAvailable]);
            System.out.println("Garage received the car " + carToRepair + " to repair and gave a " + myCars[replacementCarAvailable] + " as courtesy car.");
            myCars[replacementCarAvailable] = exchanger.exchange(carToRepair);
            System.out.println("Garage repaired car " + carToRepair + " and received back the courtesy car " + myCars[replacementCarAvailable]);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
