package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import it.alten.game.model.enums.Direction;

public class GoCommand extends ParametrizedCommand {

    private GameController gameController;
    private LookCommand lookCommand = new LookCommand();
    @Override
    public void execute(String parameter) {
        String direction = parameter.replace("go ","");
        if (direction.equalsIgnoreCase("north")){
            getGameController().changeRoom(Direction.NORTH);
            lookCommand.execute(parameter);
        } else if (direction.equalsIgnoreCase("south")) {
            getGameController().changeRoom(Direction.SOUTH);
            lookCommand.execute(parameter);
        } else if (direction.equalsIgnoreCase("east")) {
            getGameController().changeRoom(Direction.EAST);
            lookCommand.execute(parameter);
        } else if (direction.equalsIgnoreCase("west")) {
            getGameController().changeRoom(Direction.WEST);
            lookCommand.execute(parameter);
        }
    }
}