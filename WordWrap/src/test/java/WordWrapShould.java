import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WordWrapShould {

    public static final String long_string = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In ultricies facilisis hendrerit. Ut sit amet turpis in nibh pretium ullamcorper. Donec semper vel dolor in ultricies. In gravida maximus nibh, vitae cursus metus. Donec a lorem gravida, mollis quam sit amet, bibendum lorem. Nam quis sapien vel ligula iaculis feugiat. Aenean cursus mi ligula, at condimentum nisl dignissim eget. Integer tincidunt lacinia lectus vulputate tincidunt. Morbi pharetra in sapien sit amet porttitor. Phasellus tempor elit nulla, sit amet egestas nisi interdum a. Nunc sed lacus in purus pharetra condimentum vitae non elit. Quisque ligula risus, imperdiet vitae facilisis vitae, consequat nec purus. Cras ut porttitor arcu, vitae sodales magna. Praesent sagittis, eros quis laoreet fringilla, arcu orci faucibus sem, nec lacinia magna enim quis orci. ";

    public static final String expected = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In ultricies facilisis\n" +
            "hendrerit. Ut sit amet turpis in nibh pretium ullamcorper. Donec semper vel\n" +
            "dolor in ultricies. In gravida maximus nibh, vitae cursus metus. Donec a lorem\n" +
            "gravida, mollis quam sit amet, bibendum lorem. Nam quis sapien vel ligula\n" +
            "iaculis feugiat. Aenean cursus mi ligula, at condimentum nisl dignissim eget.\n" +
            "Integer tincidunt lacinia lectus vulputate tincidunt. Morbi pharetra in sapien\n" +
            "sit amet porttitor. Phasellus tempor elit nulla, sit amet egestas nisi interdum\n" +
            "a. Nunc sed lacus in purus pharetra condimentum vitae non elit. Quisque ligula\n" +
            "risus, imperdiet vitae facilisis vitae, consequat nec purus. Cras ut porttitor\n" +
            "arcu, vitae sodales magna. Praesent sagittis, eros quis laoreet fringilla, arcu\n" +
            "orci faucibus sem, nec lacinia magna enim quis orci. ";

    @Test
    public void return_input_string_when_column_number_is_larger_than_input_length () {
        assertThat(WordWrap.wrap("abcde", 80)).isEqualTo("abcde");
    }

    @Test
    public void wrap_input_string_when_column_number_is_less_than_input_length () {
        assertThat(WordWrap.wrap("ab cd", 2)).isEqualTo("ab\ncd");
    }


    @Test
    public void wrap_input_string_at_space () {
        assertThat(WordWrap.wrap("a bc", 2)).isEqualTo("a\nbc");
    }

    @Test
    public void break_a_word_when_it_is_longer_than_column_number () {
        assertThat(WordWrap.wrap("abc", 2)).isEqualTo("ab\nc");
    }


    @Test
    public void wrap_input_string_at_last_space_before_column_number() {
        assertThat(WordWrap.wrap("a b c", 3)).isEqualTo("a b\nc");
    }

    @Test
    public void wrap_input_string_multiple_times() {
        assertThat(WordWrap.wrap("a b c", 2)).isEqualTo("a\nb\nc");
    }

    @Test
    public void integration() {
        assertThat(WordWrap.wrap(long_string, 80)).isEqualTo(expected);
    }
}
