package concurrentProgramming.exerciseX_phaserBikeTrip;

import java.util.concurrent.Phaser;

public class TestingPhaserFamilyBikeTrip {

    public static void main(String[] args) {
        String[] family = {"Father", "Mother", "Son", "Daughter_1", "Daughter_2"};
        String[] routes = {"Sierre", "Sion", "Martigny", "St-Maurice", "Aigle", "Vevey"};

        Phaser phaser = new Phaser();
        phaser.register();
        int currentPhase = -1;

        for (String member: family) {
            new FamilyMemberThread(phaser, member, routes.length);
        }

        System.out.println("The family leaves Brig for a bike trip to Vevey.");

        for(int i = 0; i < routes.length; i++)
        {
            currentPhase = phaser.getPhase();
            phaser.arriveAndAwaitAdvance();
            System.out.println("All family members arrived to " + routes[currentPhase]);
        }

        phaser.arriveAndDeregister();

        if (phaser.isTerminated()) {
            System.out.println("End of the bike trip.");
        }
    }
}
