package it.alten.game.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ItemInRoom extends Item{

    @ManyToOne
    @JoinColumn(name = "id_room")
    private Room room;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "requestedSlots")
    private int requestedSlots;

    public ItemInRoom(String name, String description, int requestedSlots, Room room) {
        super(name, description, requestedSlots);
        this.room = room;
    }
}
