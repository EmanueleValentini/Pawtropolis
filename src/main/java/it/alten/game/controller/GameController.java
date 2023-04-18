package it.alten.game.controller;

import it.alten.game.model.CommandFactory;
import it.alten.game.model.Player;
import it.alten.game.model.Room;
import it.alten.game.model.command.Command;
import it.alten.game.model.enums.Direction;

import java.util.*;

public class GameController {

    private static final int DEFAULT_STARTING_LIFE_POINTS = 42;

    private final RoomController roomController;

    private Player player;

    private boolean quit;

    private static GameController instance;

    private GameController() {
        this.roomController = RoomController.getInstance();
        this.quit = false;
    }

    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }

    public void setQuit(boolean quit) {
        this.quit = quit;
    }

    public Player getPlayer() {
        return player;
    }

    public Room changeRoom(Direction direction) {
        return RoomController.changeRoom(direction);
    }

    public void runGame() {
        CommandController commandController = new CommandController();
        CommandFactory commandFactory = new CommandFactory();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Benvenuto a Pawtropolis come ti chiami?");
        String playerName = scanner.nextLine();
        player = new Player (playerName,DEFAULT_STARTING_LIFE_POINTS);
        System.out.println("Ciao " + playerName +". Hai " + DEFAULT_STARTING_LIFE_POINTS + " Bestemmie rimaste");
        System.out.println(roomController.getCurrentRoom().roomDescription());
        while (!quit) {
            System.out.println("Che vuoi fare?");
            String command = scanner.nextLine();
            Command finale = commandFactory.createCommandFromString(command);
            finale.execute(command);
        }
    }
}
