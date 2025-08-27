package oop.e_game.event;

public enum EventData {

    EVENT_TREASURE("보물상자 발견 이벤트", new TreasureEvent()),
    EVENT_FOOD("음식 발견 이벤트", new FoodEvent()),
    EVENT_BATTLE("전투 이벤트", new BattleEvent());

    String name;
    Event event;


    EventData(String name, Event event) {
        this.name = name;
        this.event = event;
    }
}
