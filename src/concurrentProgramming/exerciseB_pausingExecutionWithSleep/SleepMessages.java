package concurrentProgramming.exerciseB_pausingExecutionWithSleep;

import importPackage.Colors;

public class SleepMessages implements Runnable {
    public String[] song =
            {"Georges Brassens (1964) - Les Copains d'abord",
                    "Non, ce n'était pas le radeau",
                    "De la Méduse, ce bateau",
                    "Qu'on se le dise au fond des ports",
                    "Dise au fond des ports",
                    "Il naviguait en père peinard",
                    "Sur la grand-mare des canards",
                    "Et s'appelait les Copains d'abord",
                    "Les Copains d'abord"};

    @Override
    public void run() {
        System.out.print(Colors.ANSI_BLUE);
        for (String sentence : song) {
            try {
                Thread.sleep(1000);
                System.out.println('\t' + sentence);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
