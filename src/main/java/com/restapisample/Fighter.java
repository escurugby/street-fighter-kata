package com.restapisample;

import java.util.Objects;
import java.util.Random;

public class Fighter {

    private String name;

    private Stat str;
    private Stat dex;
    private Stat luck;
    private Stat vit;
    private Stat def;

    private int live;

    public Fighter(String name, int str, int dex, int luck, int vit, int def) {

        if (str+dex+luck+vit+def != 30) {
            throw new IncorrectFighterException();
        }

        this.name = name;
        this.str = new Stat(str);
        this.dex = new Stat(dex);
        this.luck = new Stat(luck);
        this.vit = new Stat(vit);
        this.def = new Stat(def);
        this.live = 100;
    }

    public int getLive() {
        return live;
    }

    public void setLive(int live) {
        this.live = live;
    }

    public Fighter attack(Fighter rival) {
        int damage = getDamage();
        System.out.println("Damage = " + damage);
        rival.setLive(rival.getLive() - damage);
        return rival;
    }

    public int getDamage() {
        int strDamage = getRandomBetween(1, 5);
        return strDamage * getStr().getValue();
    }

    private int getRandomBetween(int low, int high) {
        Random r = new Random();
        return r.nextInt(high-low) + low;
    }

    public boolean isAlive() {
        return getLive() > 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fighter fighter = (Fighter) o;
        return name.equals(fighter.name) &&
                str.equals(fighter.str) &&
                dex.equals(fighter.dex) &&
                luck.equals(fighter.luck) &&
                vit.equals(fighter.vit) &&
                def.equals(fighter.def);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, str, dex, luck, vit, def);
    }

    public String getName() {
        return name;
    }

    public Stat getStr() {
        return str;
    }

    public Stat getDex() {
        return dex;
    }

    public Stat getLuck() {
        return luck;
    }

    public Stat getVit() {
        return vit;
    }

    public Stat getDef() {
        return def;
    }
}
