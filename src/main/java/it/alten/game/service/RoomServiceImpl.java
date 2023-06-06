package it.alten.game.service;

import it.alten.game.model.Player;
import it.alten.game.model.Room;
import it.alten.game.repository.RoomRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoomServiceImpl implements RoomService{

    private final RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Room save(Room room) {
        roomRepository.save(room);
        return room;
    }

    @Override
    public Room findByName(String name) {
        Optional<Room> roomOptional = roomRepository.findRoomByName(name);
        return roomOptional.orElse(null);
    }

    @Override
    public Room findById(int id) {
        Optional<Room> roomOptional = roomRepository.findById(id);
        return roomOptional.orElse(null);
    }

    @Override
    public boolean deleteById(int id) {
        try {
            roomRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public Room findRoomByPlayer(Player player) {
        return roomRepository.findRoomByPlayer(player);
    }


}
