package oop.c_templatemethod;

import java.util.Scanner;

public class Run {

    // TemplateMethod 패턴: 상속을 이용
    // 다형성을 사용한 설계를 위해 인터페이스(public method)를 재사용하는 경우
    // 컴파일 시점에 변경되는 로직이 결정된다. (early binding, static binding)
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Character player = new Warrior("seing", 200, 30, 10);
        Character monster = new Monster("슬라임", 200, 30, 10);

        System.out.println("[전투이벤트]" + monster.getName() + " 등장!");
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

            player.attack(monster);
            monster.attack(player);
            System.out.println("\n------------------------");
            System.out.println("[" + player.getName() + " HP ] : " + player.getCurrentHp());
            System.out.println("[" + monster.getName() + " HP ] : " + monster.getCurrentHp());
        }
    }
}
