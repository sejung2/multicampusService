package oop.e_game.event;

public enum EventData {

    EVENT_TREASURE(new TreasureEvent()),
    EVENT_FOOD(new FoodEvent()),
    EVENT_BATTLE( new BattleEvent());

    Event event;


    EventData(Event event) {
        this.event = event;
    }

}
