package e_game;

import e_game.character.Player;
import e_game.event.BattleEvent;
import e_game.event.Event;
import e_game.event.FoodEvent;
import e_game.event.TreasureEvent;

import java.util.Random;
import java.util.Scanner;

// Strategy 패턴
// 코드를 재사용 해야하는 경우
// Interface, 합성을 이용해 코드를 재사용하고 기능을 동적으로 할당
// 실행시점에 변경될 로직을 결정할 수 있다. (lazy binding, dynamic binding)
public class Run {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Player player = new Player("seing", 200, 10, 10);
        Event treasure = new TreasureEvent();
        Event food = new FoodEvent();
        Event battle = new BattleEvent();
        Event[] event = {treasure, food, battle};

        Random random = new Random();
        // 이벤트, 장비, 캐릭터(hp회복), 전투, 몬스터

        // 길이가 8인 이벤트 배열
        // 이벤트를 랜덤으로 미리 배정함
        // 해당 배열을 순회하는 동안 요소에 해당하는 이벤트 발생
        // 이벤트 중 hp가 0이면 순회 종료 game over
        // 끝까지 순회하면 clear

        Event[] events = new Event[8];
        for (int i = 0; i < events.length; i++) {
            events[i] = event[random.nextInt(event.length)];
        }
        events[events.length - 1] = battle;

        for (int i = 0; i < events.length; i++) {
            System.out.println("Day " + (i + 1));
            events[i].occurEvent(player);
            if (player.isDead()) {
                System.out.println("Game Over");
                break;
            }
            System.out.println("다음 이벤트로 넘어가려면 Enter를 누르세요");
            sc.nextLine();
        }
    }
}
