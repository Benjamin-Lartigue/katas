import java.util.ArrayList;
import java.util.List;

class Frame {
    private final int rollsPerFrame;
    private List<Integer> rolls = new ArrayList<>();

    Frame(int rollsPerFrame) {
        this.rollsPerFrame = rollsPerFrame;
    }

    void addRoll(int rolledPins) {
        rolls.add(rolledPins);
    }

    int getNbRolls() {
        return rolls.size();
    }

    boolean isStrike() {
        return rolls.get(0) == 10;
    }

    boolean isSpare() {
        return rolls.size() >= 2 && rolls.get(0) + rolls.get(1) == 10;
    }

    int getRolledPins() {
        return rolls.stream().mapToInt(Integer::intValue).sum();
    }

    int getFirstRolledPins(int nbRolls) {
        return rolls.stream().limit(nbRolls).mapToInt(Integer::intValue).sum();
    }

    boolean isFinished() {
        return isStrike() || isSpare() || getNbRolls() == rollsPerFrame;
    }
}
