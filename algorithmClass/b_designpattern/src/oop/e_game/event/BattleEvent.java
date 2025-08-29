package oop.e_game.event;

import oop.e_game.character.Monster;
import oop.e_game.character.Player;

import java.util.Scanner;

public class BattleEvent implements Event{
    Monster monster = new Monster("slime", 100, 10, 5);

    @Override
    public void occurEvent(Player player) {
        Scanner sc  = new Scanner(System.in);
        System.out.println("[전투이벤트]" + monster.getName() + " 발생!");
        while (true) {
            if (player.isDead()) {
                System.out.println("[결과] LOSE");
                break;
            }

            if (monster.isDead()) {
                System.out.println("[결과] WIN");
                break;
            }

            System.out.println("Enter를 눌러 진행");
            System.out.println("\n========================");
            sc.nextLine();

            player.attack(monster);
            monster.attack(player);
            System.out.println("\n------------------------");
            System.out.println("[" + player.getName() + " HP ] : " + player.getCurrentHp());
            System.out.println("[" + monster.getName() + " HP ] : " + monster.getCurrentHp());
        }
    }
}
