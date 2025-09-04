package com.mc.trpg.domain.event;

import com.mc.trpg.domain.event.code.EventStatus;

public interface Event {

    void proceed();
    EventStatus status();
    String desc();
}
