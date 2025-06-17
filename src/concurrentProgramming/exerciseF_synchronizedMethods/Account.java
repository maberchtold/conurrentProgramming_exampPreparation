package concurrentProgramming.exerciseF_synchronizedMethods;

public class Account {
    private int balance;
    public synchronized void deposit(int money) {
        balance += money;
    }

    public synchronized void withdraw(int money) {
        balance -= money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}
