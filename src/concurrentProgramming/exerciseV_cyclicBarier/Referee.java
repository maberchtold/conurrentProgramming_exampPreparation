package concurrentProgramming.exerciseV_cyclicBarier;

import java.util.Collections;
import java.util.List;

/**
 * @author Yvan Pannatier, Michael Schumacher, HES-SO Valais Wallis
 * This class represents the referee during the "Patrouille des Glaciers" contest.
 * The class is a thread simulating the behavior of the referee during the competition by creating the
 * final ranking of the teams. It uses the time taken by each team to reach the end of the race to sort them.
 */
class Referee implements Runnable {
    private List<Result> results;

    public Referee(List<Result> results) {
        this.results = results;
    }

    @Override
    public void run() {
        System.out.println("Referee starts to establish ranking...");
        Collections.sort(results);
        System.out.println("PDG Team Ranking: ");
        for (Result r : results)
            System.out.println(r.getTeam() + " : " + r.getTime() + "h");
    }
}