package concurrentProgramming.exerciseG_synchronizedStatements;

public class Account {
    private int balance;
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    //DANGEROUS BECAUSE BOTH USE THE SAME VARIABLE
    public void deposit(int money) {
        synchronized(lock1) {
            balance += money;
        }
    }

    public void withdraw(int money) {
        synchronized(lock2) {
            balance -= money;
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}
