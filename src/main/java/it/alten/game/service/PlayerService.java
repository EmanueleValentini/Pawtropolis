package it.alten.game.service;

import it.alten.game.model.Player;
import it.alten.game.model.Room;
import it.alten.game.model.dto.PlayerDto;
import org.springframework.stereotype.Service;


@Service
public interface PlayerService {

    Player save (PlayerDto playerDto);

    Room findPlayerCurrentRoom (int id);

    boolean updateCurrentRoomById (int id, Player player);
}