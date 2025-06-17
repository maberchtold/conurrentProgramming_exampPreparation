package concurrentProgramming.exerciseF_synchronizedMethods;

// Illustrating https://docs.oracle.com/javase/tutorial/essential/concurrency/syncmeth.html
public class TestingThreadInterferences {
    public static void main(String[] args) {
        // shared account object
        Account account = new Account();
        (new Thread(new Customer("Damien", account))).start();
        (new Thread(new Customer("Hélène", account))).start();
    }
}
