package it.alten.game.model;

import it.alten.animal.model.Animal;
import it.alten.game.model.enums.AdjacentRooms;

import java.util.*;

public class Room {
    private String name;

    private List<Item> roomItemList;

    List<Animal> animalList;

    EnumMap<AdjacentRooms, Room> adjacentRoomsList;

    public Room(String name){

        this.name = name;
        this.roomItemList = new ArrayList<>();
        this.animalList = new ArrayList<>();
        this.adjacentRoomsList = new EnumMap<>(AdjacentRooms.class);

    }
    public Room connectRoom(Room room, AdjacentRooms direction) {

        return adjacentRoomsList.put(direction,room);
    }

    public Room unconnectRoom(Room room) {

        return adjacentRoomsList.values().remove(room)?room:null;
    }

    public Room unconnectRoom(AdjacentRooms direction) {

        return adjacentRoomsList.remove(direction);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getRoomItemList() {
        return roomItemList;
    }

    public void setRoomItemList(List<Item> roomItemList) {
        this.roomItemList = roomItemList;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }

    public EnumMap<AdjacentRooms, Room> getAdjacentRoomsList() {
        return adjacentRoomsList;
    }

    public Room getAdjacentRoom(AdjacentRooms direction) {
        return adjacentRoomsList.get(direction);
    }

    public void setAdjacentRoomsList(EnumMap<AdjacentRooms, Room> adjacentRoomsList) {
        this.adjacentRoomsList = adjacentRoomsList;
    }


    public Item removeItemFromRoom(Item item) {
        roomItemList.remove(item);
        return item;
    }

    public Animal addAnimalToRoom(Animal animal) {

        animalList.add(animal);
        return animal;
    }

    public void addItemToRoom(Item item) {
        roomItemList.add(item);
    }

    public String roomDescription() {
        String message = "Sei nella stanza " + this.getName();
        if(!this.getRoomItemList().isEmpty()){
            message += "\nCi sono questi oggetti: " + this.getRoomItemList();
        }
        if (!this.getAnimalList().isEmpty()){
            message += "\nCi sono questi npc: " + this.getAnimalList();
        }
        if (!this.getAdjacentRoomsList().isEmpty()){
            message += "\nPuoi spostarti verso: " + this.getAdjacentRoomsList();
        }

        return message;
    }

    @Override
    public String toString() {
        return name;
    }
}
