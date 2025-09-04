package e_game.character;


import e_game.item.Equipment;
import e_game.item.Equipments;
import e_game.item.Slot;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;

public class Player extends Character {

    Random random = new Random();
    private Equipments equipments = new Equipments();

    public Player(String name, int hp, int atk, int def) {
        super(name, hp, atk, def);
    }

    @Override
    public void attack(Character target) {
        int damage = random.nextInt(atk, atk * 3);
        System.out.println("[" + name + "] 공격!");
        for (Equipment e : equipments.findAll()) {
            damage += e.calAttackWeight(damage);
        }

        Optional<Equipment> optional = equipments.findbySlot(Slot.WEAPON);

        optional.orElseThrow(() -> new NoSuchElementException());

        if (optional.isPresent()) {
            System.out.println(optional.get().getEffect());
        }
        target.takeDamage(damage);
    }

    @Override
    public void takeDamage(int damage) {
        // 피해량 연산
        for (Equipment e : equipments.findAll()) {
            damage += e.calAttackWeight(damage);
        }
        System.out.println("[ Damage ]: " + damage);

        this.currentHp -= damage;
        this.currentHp = Math.max(this.currentHp, 0);
    }

    public void equip(Equipment equipment) {
        equipments.equip(equipment);
    }

    public void increaseHp() {
        this.currentHp = hp;
    }
}
