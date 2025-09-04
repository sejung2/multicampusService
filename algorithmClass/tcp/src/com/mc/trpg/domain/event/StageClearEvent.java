package com.mc.trpg.domain.event;

import com.mc.trpg.domain.character.Player;
import com.mc.trpg.domain.event.code.EventStatus;

import java.util.List;

public class StageClearEvent extends AbstractEvent {
    private List<Event> evnets;

    public StageClearEvent(EventStatus status, Player player, List<Event> evnets) {
        super(status, player);
        this.evnets = evnets;
    }

    @Override
    public void proceed() {
        System.out.println("스테이지 클리어를 축하드립니다.");
        for (Event event : evnets) {
            System.out.println("=========================");
            event.proceed();
        }

        status = EventStatus.PASS;
    }

    @Override
    public String desc() {
        return "스테이지 클리어 보상 이벤트 입니다.";
    }
}
