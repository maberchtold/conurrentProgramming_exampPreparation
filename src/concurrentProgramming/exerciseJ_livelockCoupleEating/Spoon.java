package concurrentProgramming.exerciseJ_livelockCoupleEating;

class Spoon {
    private Diner owner;

    public Diner getOwner() {
        return owner;
    }

    public Spoon(Diner d) {
        owner = d;
    }

    public synchronized void setOwner(Diner d) {
        owner = d;
    }

    public synchronized void use() {
        System.out.printf("%s has eaten!", owner.getName());
    }
}
