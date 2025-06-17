package concurrentProgramming.exerciseA_definingAndStartingAThread;

import importPackage.Colors;

/* You can also extend the Thread class.
    However, this is not the best way to do create a Thread class,
    because this solution is not flexible
    and does not allow this class to extend another one.
 */
public class HelloThread extends Thread {
    @Override
    public void run() {
        System.out.print(Colors.ANSI_GREEN);
        System.out.println('\t' + "Hello from a class extending a Thread!");
    }
}
