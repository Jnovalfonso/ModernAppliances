package ManagementSystem;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import Appliances.Appliance;

public class RandomComparer {
    private Random random = new Random();

    public List<Appliance> compare(List<Appliance> unsortedList) {
        // Shuffle the list using Random object
        Collections.shuffle(unsortedList, random);
        return unsortedList;
    }
}