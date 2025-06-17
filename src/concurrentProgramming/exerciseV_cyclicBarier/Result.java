package concurrentProgramming.exerciseV_cyclicBarier;

/**
 * @author Yvan Pannatier, Michael Schumacher, HES-SO Valais Wallis
 * This class is used to store the results of the different team.
 * It simply contains the name of the team (ie: "Team 0") and the time
 * taken by the team to finish the race.
 */
public class Result implements Comparable<Result>{
    private final int time;
    private final String team;

    public Result(String team, int time)
    {
        this.time = time;
        this.team = team;
    }

    public int getTime() {
        return time;
    }

    public String getTeam() {
        return team;
    }

    @Override
    public int compareTo(Result result) {
        return this.getTime() - result.getTime();
    }
}
