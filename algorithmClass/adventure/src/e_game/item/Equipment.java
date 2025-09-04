package e_game.item;


import java.util.Random;

public class Equipment implements DamageWeight {

    private String name;
    private int atk;
    private int def;
    private Slot slot;
    private String effect;

    public String getEffect() {
        return effect;
    }

    public Slot getSlot() {
        return slot;
    }

    private Random random = new Random();

    public Equipment(String name, int atk, int def, Slot slot, String effect) {
        this.name = name;
        this.atk = atk;
        this.def = def;
        this.slot = slot;
        this.effect = effect;
    }

    @Override
    public int calAttackWeight(int damage) {
        return random.nextInt(damage + atk, damage + atk * 2);
    }

    public String getName() {
        return name;
    }

    @Override
    public int callDefenseWeight(int damage) {
        return damage - (damage * def / 100);
    }
}
