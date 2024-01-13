package strategiePickers;

import strategies.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class StrategieRandomPicker {
    public Strategie getRandomLinearMappedStrategie() {
        Random random = new Random();
        int amount = random.nextInt(15)+1;
        return new LinearMapped(amount);
    }
    public Strategie getRandomCustomMappedStrategie() {
        ArrayList<Integer> random = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            random.add(i);
        }
        Collections.shuffle(random);
        return new CustomMapped(random);
    }
    public Strategie getRandomDefensiveStrategie() {
        Random random = new Random();
        boolean bool = random.nextBoolean();
        return new Defensive(bool);
    }
    public Strategie getRandomOffensiveStrategie() {
        Random random = new Random();
        boolean bool = random.nextBoolean();
        return new Offensive(bool);
    }

    public Strategie getRandomizedStrategie() {
        return new Randomized();
    }

    public Strategie getRandomStrategie() {
        Random random = new Random();
        int strategie = random.nextInt(5);
        switch (strategie) {
            case 0:
                return getRandomLinearMappedStrategie();
            case 1:
                return getRandomCustomMappedStrategie();
            case 2:
                return getRandomDefensiveStrategie();
            case 3:
                return getRandomOffensiveStrategie();
            case 4:
                return getRandomizedStrategie();
            default:
                return getRandomStrategie();
        }
    }
}
