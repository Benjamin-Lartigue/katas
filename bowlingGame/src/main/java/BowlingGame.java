import java.util.ArrayList;
import java.util.List;

class BowlingGame {

    private static final int FRAMES_PER_GAME = 10;
    private static final int LAST_FRAME_INDEX = FRAMES_PER_GAME - 1;

    private List<Frame> frames = new ArrayList<>();
    private Frame currentFrame;
    private final int rollsPerFrame;

    BowlingGame() {
        this(2);
    }

    BowlingGame(int rollsPerFrame) {
        this.rollsPerFrame = rollsPerFrame;
        newFrame();
    }

    private void newFrame() {
        currentFrame = new Frame(rollsPerFrame);
        frames.add(currentFrame);
    }

    void roll(int rolledPins) {
        currentFrame.addRoll(rolledPins);
        if (!isLastFrame() && currentFrame.isFinished()) {
            newFrame();
        }
    }

    private boolean isLastFrame() {
        return frames.size() == FRAMES_PER_GAME;
    }

    int score() {
        int score = 0;
        for (int frameIndex = 0; frameIndex < FRAMES_PER_GAME - 1; frameIndex++) {
            Frame frame = frames.get(frameIndex);
            score += frame.getRolledPins();
            if (frame.isStrike()) {
                score += getNextRolledPins(frameIndex + 1, 2);
            } else if (frame.isSpare()) {
                score += getNextRolledPins(frameIndex + 1, 1);
            }
        }
        score += frames.get(LAST_FRAME_INDEX).getRolledPins();
        return score;
    }

    private int getNextRolledPins(int frameIndex, int nbRolls) {
        Frame frame = frames.get(frameIndex);
        if (frame.getNbRolls() >= nbRolls) {
            return frame.getFirstRolledPins(nbRolls);
        }
        return frame.getRolledPins() + getNextRolledPins(frameIndex + 1, nbRolls - frame.getNbRolls());
    }

}


