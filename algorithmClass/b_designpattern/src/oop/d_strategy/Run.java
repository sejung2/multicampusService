package oop.d_strategy;

import oop.d_strategy.character.Monster;
import oop.d_strategy.character.Player;
import oop.d_strategy.item.Equipment;
import oop.d_strategy.item.code.EquipmentData;

import java.util.Random;
import java.util.Scanner;

// Strategy 패턴
// 코드를 재사용 해야하는 경우
// Interface, 합성을 이용해 코드를 재사용하고 기능을 동적으로 할당
// 실행시점에 변경될 로직을 결정할 수 있다. (lazy binding, dynamic binding)
public class Run {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Player player = new Player("seing", 200, 30, 10);
        Monster monster = new Monster("슬라임", 200, 30, 10);
        Random random = new Random();

        System.out.println("[전투이벤트]" + monster.getName() + " 등장!");
        boolean eventFlg = true;
        while (true) {
            if (player.isDead()) {
                System.out.println("[결과] LOSE");
                break;
            }

            if (monster.isDead()) {
                System.out.println("[결과] WIN");
                break;
            }

            System.out.println("\n========================");
            sc.nextLine();

            if (player.getCurrentHp() < 150) {
                System.out.println();
                EquipmentData[] datas = EquipmentData.values();
                int index = random.nextInt(0, datas.length);

                if (eventFlg) {
                    // 전략을 생성
                    // 전략을 주입, Dependency Injection, Inversion Of Controller
                    Equipment equipment = datas[index].create();
                    System.out.println(equipment.getName() + " 발견했습니다.");
                    player.equip(datas[index].create());
                    eventFlg = false;
                }
            }
            player.attack(monster);
            monster.attack(player);
            System.out.println("\n------------------------");
            System.out.println("[" + player.getName() + " HP ] : " + player.getCurrentHp());
            System.out.println("[" + monster.getName() + " HP ] : " + monster.getCurrentHp());
        }
    }
}
