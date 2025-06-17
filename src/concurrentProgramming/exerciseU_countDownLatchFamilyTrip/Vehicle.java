package concurrentProgramming.exerciseU_countDownLatchFamilyTrip;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    private List<String> suitcases = new ArrayList<String>();

    public void addSuitcase(String suitcase) {
        suitcases.add(suitcase);
    }

    public void printVehicleContent() {
        System.out.println("Vehicle content: " + suitcases);
    }
}
