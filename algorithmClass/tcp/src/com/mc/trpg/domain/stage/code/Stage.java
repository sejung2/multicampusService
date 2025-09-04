package com.mc.trpg.domain.stage.code;

import com.mc.trpg.domain.character.Monster;
import com.mc.trpg.domain.character.Player;
import com.mc.trpg.domain.character.code.MonsterData;
import com.mc.trpg.domain.event.*;
import com.mc.trpg.domain.event.code.EventStatus;
import com.mc.trpg.domain.event.scenario.EventScenario;
import com.mc.trpg.domain.item.Equipment;
import com.mc.trpg.domain.item.code.EquipmentData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Stage {
    private StageCode code;
    private Player player;
    private List<EquipmentData> equipmentDatas;
    private EquipmentData reward;
    private List<MonsterData> monsterDatas;
    private MonsterData bossData;
    private List<Event> events;

    public Stage(StageCode code, Player player, StageEquipmentData equip
            , StageMonsterData monster) {
        super();
        this.code = code;
        this.player = player;
        this.equipmentDatas = equip.list();
        this.reward = equip.reward();
        this.monsterDatas = monster.list();
        this.bossData = monster.boss();
        this.events = createEvents();
    }

    private List<Event> createEvents() {

        Random random = new Random();
        List<Event> events = new ArrayList<Event>();

        for (int i = 0; i < 7; i++) {
            int randomIdx = random.nextInt(0, 8);
            if(randomIdx == 0) {
                events.add(new FoodEvent(EventStatus.PENDING, player));
                continue;
            }

            if(randomIdx < 6) {
                int equipIdx = random.nextInt(0, equipmentDatas.size());
                Equipment equipment = equipmentDatas.get(equipIdx).create();
                events.add(new EquipmentEvent(EventStatus.PENDING, player, equipment));
                continue;
            }

            int monsterIdx = random.nextInt(0, monsterDatas.size());
            Monster monster = monsterDatas.get(monsterIdx).create();
            events.add(new BattleEvent(EventStatus.PENDING, player, monster));

        }

        events.add(new BattleEvent(EventStatus.PENDING, player, bossData.create()));
        events.add(new StageClearEvent(EventStatus.PENDING, player,
                List.of(new FoodEvent(EventStatus.PENDING, player),
                        new EquipmentEvent(EventStatus.PENDING, player, reward.create()))));
        return events;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        for (int i = 0, day = 1; i < events.size()-1; i++, day++) {
            System.out.println("\n========== " + day + "일 ==========");

            Event event = events.get(i);
            EventScenario scenario = new EventScenario(this, event);
            scenario.start();

            if(event.status().equals(EventStatus.FAIL)) {
                System.out.println("스테이지 클리어에 실패했습니다.");
                return;
            }
            if(event.status().equals(EventStatus.RETRY)) {
                System.out.println("시간을 하루 뒤로 되돌립니다.");
                i--;
            }
            sc.nextLine();
        }

        events.getLast().proceed();
    }

    public StageCode code() {
        return this.code;
    }
}
