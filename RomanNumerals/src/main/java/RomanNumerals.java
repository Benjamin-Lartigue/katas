import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class RomanNumerals {

    private Map<Integer, String> romanNumerals = new LinkedHashMap<>();

    public RomanNumerals() {
        romanNumerals.put(1000, "M");
        romanNumerals.put(900, "CM");
        romanNumerals.put(500, "D");
        romanNumerals.put(400, "CD");
        romanNumerals.put(100, "C");
        romanNumerals.put(90, "XC");
        romanNumerals.put(50, "L");
        romanNumerals.put(40, "XL");
        romanNumerals.put(10, "X");
        romanNumerals.put(9, "IX");
        romanNumerals.put(5, "V");
        romanNumerals.put(4, "IV");
        romanNumerals.put(1, "I");
    }

    public String convert(int arabicNumber) {
        String romanNumber = "";
        while (arabicNumber > 0) {
            for (Entry<Integer, String> entry : romanNumerals.entrySet()) {
                if (arabicNumber >= entry.getKey()) {
                    romanNumber += entry.getValue();
                    arabicNumber -= entry.getKey();
                }
            }
        }
        return romanNumber;
    }
}
