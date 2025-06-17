package concurrentProgramming.exerciseH2_bridgeCrossingWithoutDeadlock;

public class Road {
    private String position;

    public Road(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return position + " road";
    }
}
