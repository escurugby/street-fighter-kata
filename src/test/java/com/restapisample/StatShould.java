package com.restapisample;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StatShould {

    @Test
    void throw_exception_when_skill_is_less_than_1() {
        Assertions.assertThatThrownBy(() -> new Stat(0)).isInstanceOf(IncorrectStatException.class);
    }

    @Test
    void throw_exception_when_skill_is_more_than_10() {
        Assertions.assertThatThrownBy(() -> new Stat(11)).isInstanceOf(IncorrectStatException.class);
    }
}
