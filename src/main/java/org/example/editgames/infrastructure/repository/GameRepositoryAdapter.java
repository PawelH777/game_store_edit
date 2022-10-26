package org.example.editgames.infrastructure.repository;

import org.example.editgames.domain.model.GameDO;
import org.example.editgames.domain.model.GameStatus;

public interface GameRepositoryAdapter {

    long save(GameDO gameDO);

    void save(long id, GameDO gameDO);

    void save(long id, GameStatus gameStatus);
}
