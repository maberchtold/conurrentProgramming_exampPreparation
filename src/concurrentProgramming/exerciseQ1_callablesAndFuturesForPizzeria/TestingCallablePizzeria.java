/* @author Michael Schumacher */

package concurrentProgramming.exerciseQ1_callablesAndFuturesForPizzeria;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestingCallablePizzeria {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Create two instances of PizzaioloCallable to prepare pizzas.
        PizzaioloCallable marco= new PizzaioloCallable("Marco");
        PizzaioloCallable antonio = new PizzaioloCallable("Antonio");

        // Create an executor with a pool of 2 threads and submit the two jobs.
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // While the pizzeria is open
        while(true) {
            Future<Pizza> pizzaOrderToMarco = executor.submit(marco);
            Future<Pizza> pizzaOrdertoAntonio = executor.submit(antonio);
            System.out.println("Marco's pizza is ready: pizza " + pizzaOrderToMarco.get().hashCode());
            System.out.println("Antonio's pizza is ready: pizza " + pizzaOrdertoAntonio.get().hashCode());
        }
    }
}