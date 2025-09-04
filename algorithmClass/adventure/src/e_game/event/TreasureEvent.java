package e_game.event;

import e_game.character.Player;
import e_game.item.Equipment;
import e_game.item.code.EquipmentData;

import java.util.Random;
import java.util.Scanner;

public class TreasureEvent implements Event {

    private Random random = new Random();

    @Override
    public void occurEvent(Player player) {
        Scanner sc = new Scanner(System.in);
        System.out.println("[보물상자] 발견!!");
        EquipmentData[] datas = EquipmentData.values();
        int index = random.nextInt(0, datas.length);
        Equipment equipment = datas[index].create();

        System.out.println(equipment.getName() + " 발견했습니다. 장착하시겠습니까? (y/n)");
        String answer = sc.nextLine();
        if (answer.toLowerCase().equals("y")) {
            player.equip(datas[index].create());
            System.out.println("장착을 완료했습니다.");
        } else if (answer.toLowerCase().equals("n")) {
            return;
        }
    }
}