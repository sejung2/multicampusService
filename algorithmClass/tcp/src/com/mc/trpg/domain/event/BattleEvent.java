package com.mc.trpg.domain.event;

import com.mc.trpg.domain.character.Monster;
import com.mc.trpg.domain.character.Player;
import com.mc.trpg.domain.event.code.EventStatus;

import java.util.Scanner;

public class BattleEvent extends AbstractEvent {
    private Monster monster;

    public BattleEvent(EventStatus status, Player player, Monster monster) {
        super(status, player);
        this.monster = monster;
    }

    @Override
    public void proceed() {

        Scanner sc = new Scanner(System.in);

        while (true) {
            if (player.isDead()) {
                System.out.println("\n======================================");
                System.out.println("[결과] LOSE");
                status = EventStatus.FAIL;
                break;
            }

            if (monster.isDead()) {
                System.out.println("\n======================================");
                System.out.println("[결과] WIN");
                status = EventStatus.PASS;
                break;
            }

            System.out.println("\n======================================");

            player.attack(monster);
            monster.attack(player);
            System.out.println("------------------------------------");
            System.out.println("[" + player.getName() + " HP ] : " + player.getCurrentHp());
            System.out.println("[" + monster.getName() + " HP ] : " + monster.getCurrentHp());
            sc.nextLine();
        }
    }

    @Override
    public String desc() {
        return "몬스터와 전투를 진행하는 이벤트 입니다.";
    }

    public String getMonsterName() {
        return this.monster.getName();
    }

}
