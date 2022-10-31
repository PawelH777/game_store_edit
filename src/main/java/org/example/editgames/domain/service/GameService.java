package org.example.editgames.domain.service;

import org.example.editgames.domain.model.GameDO;
import org.example.editgames.domain.model.GameStatus;


public interface GameService {

    long createGame(GameDO gameDOToBeCreated);

    void updateGame(Long id, GameDO gameDOToBeUpdated);

    void changeGameStatus(Long id, GameStatus newGameStatus);

    void deleteGame(long id);
}
