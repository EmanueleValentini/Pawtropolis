package it.alten.game.controller;

import it.alten.game.model.Item;
import it.alten.game.model.enums.AdjacentRooms;

public class CommandController {

    private String command;

    private final RoomController roomController;

    private final GameController gameController;

    private String item;

    public CommandController(GameController gameController) {
        this.roomController = new RoomController();
        this.gameController = gameController;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void look() {
        System.out.println(roomController.getCurrentRoom().roomDescription() + "\n");
    }

    public void dropItem(Item item) {
        if (gameController.getPlayer().getAllItemsInBag().contains(item)) {
            gameController.getPlayer().removeItemFromBag(item);
            roomController.getCurrentRoom().addItemToRoom(item);
        }
    }

    public void getItem(Item item) {
        if (roomController.getCurrentRoom().getRoomItemList().contains(item)) {
            roomController.getCurrentRoom().removeItemFromRoom(item);
            gameController.getPlayer().addItemToBag(item);
        }
    }

    public void wrongCommand() {System.out.println("Scrivi bene i comandi");}

    public void commandProcessing(String command) {

        if (command.equalsIgnoreCase("go north")) {
            if (gameController.changeRoom(AdjacentRooms.NORTH) == null) {
                System.out.println("Coglione non c'è una porta su quel lato");
            } else {
                gameController.changeRoom(AdjacentRooms.NORTH);
                look();
            }

        } else if (command.equalsIgnoreCase("go south")) {
            if (gameController.changeRoom(AdjacentRooms.SOUTH) == null) {
                System.out.println("Coglione non c'è una porta su quel lato");
            } else {
                gameController.changeRoom(AdjacentRooms.SOUTH);
                look();
            }

        } else if (command.equalsIgnoreCase("go east")) {
            if (gameController.changeRoom(AdjacentRooms.EAST) == null) {
                System.out.println("Coglione non c'è una porta su quel lato");
            } else {
                gameController.changeRoom(AdjacentRooms.EAST);
                look();
            }

        } else if (command.equalsIgnoreCase("go west")) {
            if (gameController.changeRoom(AdjacentRooms.WEST) == null) {
                System.out.println("Coglione non c'è una porta su quel lato");
            } else {
                gameController.changeRoom(AdjacentRooms.WEST);
                look();
            }
<<<<<<< HEAD
       } else if (command.equalsIgnoreCase("look")) {
           look();
       } else if (command.equalsIgnoreCase("bag")) {
           if (gameController.getPlayer().getAllItemsInBag().isEmpty()) {
               System.out.println("Non hai un cazzo");
           } else {
               System.out.println(gameController.getPlayer().getAllItemsInBag());
           }
       } else if (command.toLowerCase().startsWith("drop")) {
           String itemToDrop = command.substring(4).trim();
           if (itemToDrop.isBlank()) {
               wrongCommand();
           } else {
               for (Item itemInTheBag : gameController.getPlayer().getAllItemsInBag()) {
                   if (itemInTheBag.getName().equalsIgnoreCase(itemToDrop)) {
                       dropItem(itemInTheBag);
                       System.out.println("Hai droppato " + itemInTheBag.getName());
                       break;
                   } else {
                       System.out.println("Sei n'cojone nun ce l'hai!");
                   }
               }
           }
       } else if (command.toLowerCase().startsWith("get")) {
           String itemToGet = command.substring(3).trim();
           if (itemToGet.isBlank()) {
               wrongCommand();
           } else {
               for (Item itemInTheRoom : roomController.getCurrentRoom().getRoomItemList()) {
                   if (itemInTheRoom.getName().equalsIgnoreCase(itemToGet)) {
                       getItem(itemInTheRoom);
                       System.out.println("Hai preso " + itemInTheRoom.getName());
                       break;
                   } else {
                       System.out.println("E dove lo hai visto!?");
                   }
               }
           }
       } else if (command.equalsIgnoreCase("quit")) {
           gameController.setQuit(true);
       } else {
           System.out.println("Nun ho capito, ripeti!");
=======

        } else if (command.equalsIgnoreCase("look")) {
            look();
        } else if (command.equalsIgnoreCase("bag")) {
            if (gameController.getPlayer().getAllItemsInBag().isEmpty()) {
                System.out.println("Non hai un cazzo");
            } else {
                System.out.println(gameController.getPlayer().getAllItemsInBag());
            }
        } else if (command.substring(0, 3).equalsIgnoreCase("drop")) {
             if (command.equalsIgnoreCase("drop " + item)) {
                for (Item itemInTheBag : gameController.getPlayer().getAllItemsInBag()) {
                    if (itemInTheBag.getName().equalsIgnoreCase(item)) {
                        dropItem(itemInTheBag);
                        System.out.println("Hai droppato " + itemInTheBag.getName());
                    } else {
                        System.out.println("Sei n'cojone nun ce l'hai!");
                    }
                }
            }
        } else if (command.substring(0,2).equalsIgnoreCase("get")) {
            if (command.equalsIgnoreCase("get" + item)) {
                for (Item itemInTheRoom : roomController.getCurrentRoom().getRoomItemList()) {
                    if (itemInTheRoom.getName().equalsIgnoreCase(item)) {
                        getItem(itemInTheRoom);
                        System.out.println("Hai gettato " + itemInTheRoom.getName());
                    } else {
                        System.out.println("E da ndo cazzo li piji?");
                    }
                }
            }
        } else if (command.equalsIgnoreCase("quit")) {
            gameController.setQuit(true);
>>>>>>> parent of 3cd1fad (Game controller 100% working, DAJE ROMA DAJE)
        }
    }
}
