package it.alten.game.service;

import it.alten.game.model.Bag;
import it.alten.game.model.dto.BagDto;
import org.springframework.stereotype.Service;

@Service
public interface BagService {

    Bag save (BagDto bagDto);
}
