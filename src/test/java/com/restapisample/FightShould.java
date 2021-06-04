package com.restapisample;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class FightShould {

    private static final String NAME = "F1";

    /*@Test
    void attack_in_turns() {

        Fighter fighter1 = new Fighter(NAME, 6, 6, 6, 6, 6);
        Fighter fighter2 = new Fighter(NAME, 6, 6, 6, 6, 6);

        Fight fight = new Fight(fighter1, fighter2);

        fight.startFight();
    }*/

    @Test
    void win_fighter1() {
        Fighter fighter1 = new Fighter(NAME, 10, 6, 6, 6, 2);
        Fighter fighter2 = new Fighter(NAME, 2, 6, 6, 6, 10);

        Fight fight = new Fight(fighter1, fighter2);

        Fighter winner = fight.startFight();

        Assertions.assertThat(winner).isEqualTo(fighter1);
    }
}
