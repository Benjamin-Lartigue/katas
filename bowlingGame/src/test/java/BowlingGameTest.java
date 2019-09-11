import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BowlingGameTest {

    @Test
    public void it_should_return_zero_if_no_pin_touched () {
        BowlingGame game = new BowlingGame();
        for(int i =0;i<20;i++) {
            game.roll(0);
        }
        assertThat(game.score()).isEqualTo(0);
    }

    @Test
    public void it_should_return_20_if_one_pin_touched_at_each_roll() {
        BowlingGame game = new BowlingGame();
        for(int i =0;i<20;i++) {
            game.roll(1);
        }
        assertThat(game.score()).isEqualTo(20);
    }

    @Test
    public void it_should_return_12_when_a_spare_is_scored_in_first_frame_and_only_one_pin_is_touched_after() {
        BowlingGame game = new BowlingGame();
        game.roll(8);
        game.roll(2);
        game.roll(1);
        for(int i =0;i<17;i++) {
            game.roll(0);
        }
        assertThat(game.score()).isEqualTo(12);
    }

    @Test
    public void it_should_return_14_when_a_strike_is_scored_in_first_frame_and_two_pins_are_touched_in_following_frame() {
        BowlingGame game = new BowlingGame();
        game.roll(10);
        game.roll(1);
        game.roll(1);
        for(int i =0;i<16;i++) {
            game.roll(0);
        }
        assertThat(game.score()).isEqualTo(14);
    }

    @Test
    public void it_should_return_30_when_3_strikes_are_scored_in_the_last_frame() {
        BowlingGame game = new BowlingGame();
        for(int i =0;i<18;i++) {
            game.roll(0);
        }
        game.roll(10);
        game.roll(10);
        game.roll(10);
        assertThat(game.score()).isEqualTo(30);
    }

    @Test
    public void it_should_return_17_when_a_spare_and_7_are_scored_in_the_last_frame() {
        BowlingGame game = new BowlingGame();
        for(int i =0;i<18;i++) {
            game.roll(0);
        }
        game.roll(6);
        game.roll(4);
        game.roll(7);
        assertThat(game.score()).isEqualTo(17);
    }

    @Test
    public void it_should_return_300_when_there_are_only_strikes() {
        BowlingGame game = new BowlingGame();
        for(int i =0;i<12;i++) {
            game.roll(10);
        }
        assertThat(game.score()).isEqualTo(300);
    }

    @Test
    public void it_works_with_duckpin_bowling_rules() {
        BowlingGame game = new BowlingGame(3);
        game.roll(4);
        game.roll(5);
        game.roll(1);
        game.roll(2);
        game.roll(3);
        game.roll(4);
        game.roll(10);
        game.roll(7);
        game.roll(2);
        game.roll(1);
        game.roll(7);
        game.roll(3);
        game.roll(5);
        game.roll(3);
        game.roll(0);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(6);
        game.roll(4);
        game.roll(1);
        assertThat(game.score()).isEqualTo(158);
    }
}
