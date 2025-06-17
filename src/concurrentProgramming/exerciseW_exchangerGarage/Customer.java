package concurrentProgramming.exerciseW_exchangerGarage;

import java.util.concurrent.Exchanger;

public class Customer implements Runnable {
    private String name;
    private Car car;

    public Customer(String name, Car car, Exchanger<Car> exchanger) {
        this.name = name;
        this.car = car;
        this.exchanger = exchanger;
    }

    private Exchanger<Car> exchanger;

    @Override
    public void run() {
        try {
            Car replacementCar = exchanger.exchange(car);
            System.out.println(name + " gave his car" + car + " for repair, and received a " + replacementCar + " as replacement car during the repair day.");
            car = exchanger.exchange(replacementCar);
            System.out.println(name + " gave back the replacement car " + replacementCar + " and got back his car " + car);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
