public class BreakAttempt {

    private final int breakIndex;

    public BreakAttempt(String text, int columnNumber) {
        breakIndex = text.substring(0, columnNumber + 1).lastIndexOf(' ');
    }

    public boolean isBreakable() {
        return breakIndex == -1;
    }

    public int getBreakIndex() {
        return breakIndex;
    }
}