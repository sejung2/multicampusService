package com.mc.trpg.event;

public interface Event {

    void proceed();
    EventStatus status();
    String desc();
}
