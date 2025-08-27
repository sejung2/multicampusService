package oop.e_game.event;

import oop.e_game.character.Player;

import java.util.Scanner;

public class FoodEvent implements Event{

    @Override
    public void occurEvent(Scanner sc, Player player) {
        System.out.println("[먹거리 이벤트] 발생!!!");
        System.out.println("체력을 회복합니다");
        player.increaseHp();
    }
}
