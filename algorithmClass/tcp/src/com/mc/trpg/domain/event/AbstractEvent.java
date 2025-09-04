package com.mc.trpg.event;

import com.mc.trpg.character.Player;

public abstract class AbstractEvent implements Event {

    private EventStatus status;
    private Player player;

    public AbstractEvent(EventStatus status, Player player) {
        this.status = status;
        this.player = player;
    }

    @Override
    public void proceed() {

    }

    @Override
    public EventStatus status() {
        return null;
    }

    @Override
    public String desc() {
        return "";
    }
}
