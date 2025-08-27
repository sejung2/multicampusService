package oop.c_templatemethod;

import java.util.Random;

public class Warrior extends Character {

    Random random = new Random();

    public Warrior(String name, int hp, int atk, int def) {
        super(name, hp, atk, def);
    }

    // Warrior 캐릭터의 방어 가중치 atk ~ atk * 4
    @Override
    protected int calDefenseWeight(int damage) {
        return random.nextInt(damage, damage * 4);
    }

    // Warrior 캐릭터의 공격 가중치 atk ~ atk * 4
    @Override
    protected int calAttackWeight() {
        return random.nextInt(atk, atk * 4);
    }
}
