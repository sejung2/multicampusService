package com.mc.trpg.domain.character.code;

import com.mc.trpg.domain.character.Monster;

public enum MonsterData {

    SLIME("슬라임", 100, 10, 5),
    GOBLIN("고블린", 200, 15, 5),
    GOLEM("골램", 300, 30, 15),
    DRAGON("드래곤", 600, 100, 50);

    private String name;
    private int hp;
    private int atk;
    private int def;

    private MonsterData(String name, int hp, int atk, int def) {
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
    }

    public Monster create() {
        return new Monster(name, hp, atk, def);
    }
}
