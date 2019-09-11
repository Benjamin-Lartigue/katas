import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RPNCalculatorShould {

    private RPNCalculator rpnCalculator;

    @Before
    public void setUp() {
        rpnCalculator = new RPNCalculator();
    }

    @Test
    public void return_the_same_digit_when_a_digit_is_sent() {
        String result = rpnCalculator.send("2");

        assertThat(result).isEqualTo("2");
    }

    @Test
    public void return_the_number_formed_by_those_digits_when_some_digits_are_sent() {
        String result = rpnCalculator.send("20");

        assertThat(result).isEqualTo("20");
    }

    @Test
    public void return_numbers_separated_by_newline_when_enter_is_sent_between_two_numbers() {
        String result = rpnCalculator.send("20 5");

        assertThat(result).isEqualTo("20 5");
    }

    @Test
    public void return_the_sum_of_the_two_previous_numbers_when_plus_sign_is_sent() {
        String result = rpnCalculator.send("20 5 +");

        assertThat(result).isEqualTo("25");
    }

    @Test
    public void return_the_subtraction_of_the_two_previous_numbers_when_minus_sign_is_sent() {
        String result = rpnCalculator.send("20 50 -");
        assertThat(result).isEqualTo("-30");
    }

    @Test
    public void return_the_multiplication_of_the_two_previous_numbers_when_multiply_sign_is_sent() {
        String result = rpnCalculator.send("20 50 *");
        assertThat(result).isEqualTo("1000");
    }

    @Test
    public void return_the_division_of_the_two_previous_numbers_when_division_sign_is_sent() {
        String result = rpnCalculator.send("20 5 /");
        assertThat(result).isEqualTo("4");
    }

    @Test
    public void return_the_computed_value_corresponding_to_the_expression() {
        String result = rpnCalculator.send("3 5 8 * 7 + *");

        assertThat(result).isEqualTo("141");
    }

}
