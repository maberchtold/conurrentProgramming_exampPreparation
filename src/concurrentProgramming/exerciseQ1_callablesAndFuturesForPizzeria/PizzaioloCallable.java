/* @author Michael Schumacher */

package concurrentProgramming.exerciseQ1_callablesAndFuturesForPizzeria;

import java.util.concurrent.Callable;

public class PizzaioloCallable implements Callable {
    private String name;

    public PizzaioloCallable(String name) {
        this.name = name;
    }

    @Override
    public Pizza call() throws Exception {
        System.out.println("Thread " + name + " started by the executor");
        Thread.sleep((long) Math.random()*1000);
        Pizza pizza = new Pizza();
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        System.out.println("Thread " + name + " pizza finished.");
        return pizza;
    }
}