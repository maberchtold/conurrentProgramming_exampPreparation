package concurrentProgramming.exerciseE_threadInterference;

// Illustrating https://docs.oracle.com/javase/tutorial/essential/concurrency/interfere.html
public class TestingThreadInterferences {
    public static void main(String[] args) {
        // shared account object
        Account account = new Account();
        (new Thread(new Customer("Damien", account))).start();
        (new Thread(new Customer("Hélène", account))).start();
    }
}
