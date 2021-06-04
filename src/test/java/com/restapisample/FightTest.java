package com.restapisample;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FightTest {

    private static final String NAME = "Nombre";

    @Test
    void create_ok_character() {
        Fighter fighter = new Fighter(NAME, 6, 6, 6, 6, 6);

        assertThat(fighter.getLive()).isEqualTo(100);
    }

    @Test
    void throw_exception_when_create_character_less_skills() {
        assertThatThrownBy(() -> new Fighter(NAME, 5, 6, 6, 6, 6)).isInstanceOf(IncorrectFighterException.class);
    }

}
