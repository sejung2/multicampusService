package oop.c_templatemethod;

import java.util.Random;

public class Player extends Character {


    public Player(String name, int hp, int atk, int def) {
        super(name, hp, atk, def);
    }

    @Override
    protected int calDefenseWeight(int damage) {
        return damage - (damage * damage / 100);
    }

    // Player 캐릭터의 공격 가중치는 atk / 2 ~ atk * 3
    @Override
    protected int calAttackWeight() {
        Random random = new  Random();
        return random.nextInt(atk / 2, atk * 3);
    }
}
