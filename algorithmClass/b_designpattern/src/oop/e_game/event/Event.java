package oop.e_game.event;

import oop.e_game.character.Player;

import java.util.Scanner;

public interface Event {
    public void occurEvent(Scanner sc, Player player);
}
