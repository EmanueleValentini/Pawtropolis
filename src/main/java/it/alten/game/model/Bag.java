package it.alten.game.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class Bag {
    private List<Item> inventory;
    private int availableSlots;
    private static final int MAX_SLOTS = 10;
    private final int maxSlots;

    public Bag() {
        this.maxSlots = MAX_SLOTS;
        this.availableSlots = maxSlots;
        this.inventory = new ArrayList<>(maxSlots);
    }



    public void addItem(Item item) {
        if (!isFull()) {
            inventory.add(item);
        } else {
            System.out.println("Hai la borsa piena coglione");
        }

    }

    public void removeItem(Item item) {
        if (!inventory.contains(item)) {
            System.out.println("Bro ma sei cieco, non ce l'hai sto coso");
        } else {
            inventory.remove(item);
        }

    }

    public boolean isFull() {
        return availableSlots == 0;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bag bag = (Bag) o;
        return availableSlots == bag.availableSlots && maxSlots == bag.maxSlots && Objects.equals(inventory, bag.inventory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventory, availableSlots, maxSlots);
    }


}
