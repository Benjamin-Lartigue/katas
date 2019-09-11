import java.util.LinkedHashMap;
import java.util.Map;

public class ArabicNumerals {

    private Map<String, Integer> arabicNumerals = new LinkedHashMap<>();

    public ArabicNumerals() {
        this.arabicNumerals.put("M", 1000);
        this.arabicNumerals.put("CM", 900);
        this.arabicNumerals.put("D", 500);
        this.arabicNumerals.put("CD", 400);
        this.arabicNumerals.put("C", 100);
        this.arabicNumerals.put("XC", 90);
        this.arabicNumerals.put("L", 50);
        this.arabicNumerals.put("XL", 40);
        this.arabicNumerals.put("X", 10);
        this.arabicNumerals.put("IX", 9);
        this.arabicNumerals.put("V", 5);
        this.arabicNumerals.put("IV", 4);
        this.arabicNumerals.put("I", 1);
    }

    public int convert(String romanNumber) {
        int arabicNumber = 0;
        while (!romanNumber.isEmpty()) {
            for (Map.Entry<String, Integer> entry : arabicNumerals.entrySet()) {
                if (romanNumber.startsWith(entry.getKey())) {
                    arabicNumber += entry.getValue();
                    romanNumber = romanNumber.substring(entry.getKey().length());
                }
            }
        }
        return arabicNumber;
    }
}
