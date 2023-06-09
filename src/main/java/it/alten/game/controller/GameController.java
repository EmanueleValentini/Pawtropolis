package it.alten.game.controller;

import it.alten.game.model.CommandFactory;
import it.alten.game.model.Player;
import it.alten.game.model.Room;
import it.alten.game.model.command.Command;
import it.alten.game.model.enums.Direction;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;


@Getter
@Controller
public class GameController {
    private final RoomController roomController;

    private static final int DEFAULT_STARTING_LIFE_POINTS = 42;

    private Player player;

    private boolean quit;

    private final CommandFactory commandFactory;

    @Autowired
    private GameController() {
        this.roomController = RoomController.getInstance();
        this.commandFactory = CommandFactory.getInstance();
        this.quit = false;
    }

    private static GameController instance = new GameController();

    public static GameController getInstance() {
        return instance;
    }

    public void setQuit(boolean quit) {
        this.quit = quit;
    }

    public Room changeRoom(Direction direction) {
        return RoomController.changeRoom(direction);
    }

    public void runGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Benvenuto a Pawtropolis come ti chiami?");
        String playerName = scanner.nextLine();
        player = new Player (playerName,DEFAULT_STARTING_LIFE_POINTS);
        System.out.println("Ciao " + playerName +". Hai " + DEFAULT_STARTING_LIFE_POINTS + " Bestemmie rimaste");
        System.out.println(roomController.getCurrentRoom().roomDescription());
        while (!quit) {
            System.out.println("Che vuoi fare?");
            String input = scanner.nextLine();
            Command command = commandFactory.createCommandFromString(input);
            command.execute();
        }
    }
}
