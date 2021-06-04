package com.restapisample;

public class Fight {

    private Fighter fighter1;

    private Fighter fighter2;

    private int turn;

    public Fight(Fighter fighter1, Fighter fighter2) {
        this.fighter1 = fighter1;
        this.fighter2 = fighter2;
        turn = 1;
    }

    public Fighter startFight() {
        boolean finish = false;
        do {
            finish = attack();
        } while(!finish);

        if (fighter1.isAlive()) {
            return fighter1;
        }
        return fighter2;
    }

    public boolean attack() {
        if (turn == 1) {
            fighter2 = fighter1.attack(fighter2);
            if (fighter2.getLive() <= 0) {
                return true;
            }
            turn = 2;
        } else {
            fighter1 = fighter2.attack(fighter1);
            if (fighter1.getLive() <= 0) {
                return true;
            }
            turn = 1;
        }

        System.out.println("turn " + turn + ": fighter 1 = " + fighter1.getLive() + ", figther 2 = " + fighter2.getLive());
        return false;
    }
}
