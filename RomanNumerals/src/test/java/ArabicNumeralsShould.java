import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArabicNumeralsShould {
    @Test
    public void convert_I_into_1() {
        assertThat(new ArabicNumerals().convert("I")).isEqualTo(1);
    }

    @Test
    public void convert_II_into_2() {
        assertThat(new ArabicNumerals().convert("II")).isEqualTo(2);
    }

    @Test
    public void convert_III_into_3() {
        assertThat(new ArabicNumerals().convert("III")).isEqualTo(3);
    }

    @Test
    public void convert_IV_into_4() {
        assertThat(new ArabicNumerals().convert("IV")).isEqualTo(4);
    }

    @Test
    public void convert_V_into_5() {
        assertThat(new ArabicNumerals().convert("V")).isEqualTo(5);
    }

    @Test
    public void convert_MCMIII_into_1903() {
        assertThat(new ArabicNumerals().convert("MCMIII")).isEqualTo(1903);
    }
}
