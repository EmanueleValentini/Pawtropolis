package it.alten.game.model.command;

import it.alten.game.model.Item;

public class GetCommand extends ParametrizedCommand {

    @Override
    public void execute(String parameter) {
        String itemToGet = parameter.replace("get ","");
        for (Item itemInTheRoom : getRoomController().getCurrentRoom().getRoomItemList()) {
                if (itemInTheRoom.getName().equalsIgnoreCase(itemToGet)) {
                    getItem(itemInTheRoom);
                    System.out.println("Hai preso " + itemInTheRoom.getName());
                    break;
                }
        }
    }

    public void getItem(Item item) {
       if (getRoomController().getCurrentRoom().getRoomItemList().contains(item)) {
            getRoomController().getCurrentRoom().removeItemFromRoom(item);
            getGameController().getPlayer().addItemToBag(item);
       }
    }
}
