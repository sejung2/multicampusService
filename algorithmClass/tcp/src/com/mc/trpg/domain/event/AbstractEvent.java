package com.mc.trpg.domain.event;

import com.mc.trpg.domain.character.Player;
import com.mc.trpg.domain.event.code.EventStatus;

public abstract class AbstractEvent implements Event {

    protected EventStatus status;
    protected Player player;

    public AbstractEvent(EventStatus status, Player player) {
        this.status = status;
        this.player = player;
    }

    @Override
    public EventStatus status() {
        return status;
    }

}
