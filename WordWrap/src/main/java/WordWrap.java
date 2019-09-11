 class WordWrap {

    public static String wrap(String text, int columnNumber) {
        if(isWrappable(text, columnNumber)) {
            BreakAttempt breakAttempt = new BreakAttempt(text, columnNumber);
            if(breakAttempt.isBreakable())
                return text.substring(0, columnNumber) + "\n" + wrap(text.substring(columnNumber), columnNumber);
            return text.substring(0, breakAttempt.getBreakIndex()) + "\n" + wrap(text.substring(breakAttempt.getBreakIndex() + 1),columnNumber);
        }

        return text;
    }

    private static boolean isWrappable(String text, int columnNumber) {
        return columnNumber < text.length();
    }
}
