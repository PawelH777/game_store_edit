package org.example.editgames.domain.service;

import org.example.editgames.domain.model.GameDO;
import org.example.editgames.domain.model.GameStatus;
import org.example.editgames.infrastructure.repository.GameRepositoryAdapter;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepositoryAdapter gameRepositoryAdapter;

    public GameServiceImpl(final GameRepositoryAdapter gameRepositoryAdapter) {
        this.gameRepositoryAdapter = gameRepositoryAdapter;
    }

    @Override
    public long createGame(final GameDO gameDOToBeCreated) {
        return gameRepositoryAdapter.save(gameDOToBeCreated);
    }

    @Override
    public void updateGame(final Long id, final GameDO gameDOToBeUpdated) {
        gameRepositoryAdapter.save(id, gameDOToBeUpdated);
    }

    @Override
    public void changeGameStatus(final Long id, final GameStatus newGameStatus) {
        gameRepositoryAdapter.save(id, newGameStatus);
    }

    @Override
    public void deleteGame(final long id) {
        gameRepositoryAdapter.deleteById(id);
    }
}
