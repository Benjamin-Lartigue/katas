import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RomanNumeralsShould {

    @Test
    public void convert_1_into_I() {
        assertThat(new RomanNumerals().convert(1)).isEqualTo("I");
    }

    @Test
    public void convert_2_into_II() {
        assertThat(new RomanNumerals().convert(2)).isEqualTo("II");
    }

    @Test
    public void convert_3_into_III() {
        assertThat(new RomanNumerals().convert(3)).isEqualTo("III");
    }

    @Test
    public void convert_4_into_IV() {
        assertThat(new RomanNumerals().convert(4)).isEqualTo("IV");
    }

    @Test
    public void convert_5_into_V() {
        assertThat(new RomanNumerals().convert(5)).isEqualTo("V");
    }

    @Test
    public void convert_6_into_VI() {
        assertThat(new RomanNumerals().convert(6)).isEqualTo("VI");
    }

    @Test
    public void convert_8_into_VIII() {
        assertThat(new RomanNumerals().convert(8)).isEqualTo("VIII");
    }

    @Test
    public void convert_1903_into_MCMIII() {
        assertThat(new RomanNumerals().convert(1903)).isEqualTo("MCMIII");
    }

}
