package concurrentProgramming.exerciseG_synchronizedStatements;

public class BankEmployee implements Runnable {
    private String name;
    private Account account;

    public BankEmployee(String name, Account account) {
        this.name = name;
        this.account = account;
    }

    @Override
    public void run() {
        while (true) {
            account.deposit((int)(Math.random()*(1000)));
            System.out.println("Bank employee " + name + " deposited money on the account, resulting in " + account);
            account.withdraw((int)(Math.random()*(1000)));
            System.out.println("Bank employee " + name + " withdraw money from the account, resulting in " + account);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
