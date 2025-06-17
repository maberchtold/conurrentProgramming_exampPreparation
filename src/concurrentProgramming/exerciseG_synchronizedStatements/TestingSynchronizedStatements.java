package concurrentProgramming.exerciseG_synchronizedStatements;

// Illustrating https://docs.oracle.com/javase/tutorial/essential/concurrency/locksync.html

public class TestingSynchronizedStatements {
    public static void main(String[] args) {
        // shared account object
        Account account = new Account();
        (new Thread(new BankEmployee("Mrs Fournier", account))).start();
        (new Thread(new BankEmployee("Mr Schmidhalter", account))).start();
    }
}
