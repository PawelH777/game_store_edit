package org.example.editgames.infrastructure.repository;

import org.example.editgames.domain.model.GameDO;
import org.example.editgames.domain.model.GameStatus;
import org.example.editgames.infrastructure.model.Game;
import org.example.editgames.infrastructure.sender.GameSender;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GameRepositoryAdapterImpl implements GameRepositoryAdapter {

    private final GameRepository gameRepository;

    private final GameSender gameSender;

    public GameRepositoryAdapterImpl(final GameRepository crudRepository, final GameSender gameSender) {
        this.gameRepository = crudRepository;
        this.gameSender = gameSender;
    }

    @Override
    public long save(final GameDO gameDO) {
        final Game game = Game.builder()
                .name(gameDO.getName())
                .genre(gameDO.getGenre())
                .gameStatus(gameDO.getGameStatus())
                .build();

        final Game savedGame = gameRepository.save(game);
        return savedGame.getId();
    }

    @Override
    public void save(final long id, final GameDO gameDO) {
        final Game game = Game.builder()
                .id(id)
                .name(gameDO.getName())
                .genre(gameDO.getGenre())
                .gameStatus(gameDO.getGameStatus())
                .build();

        gameRepository.save(game);
    }

    @Override
    public void save(final long id, final GameStatus gameStatus) {
        final Optional<Game> oldGameOptional = gameRepository.findById(id);

        oldGameOptional.ifPresent(oldGame -> {
            final Game game = Game.builder()
                    .id(id)
                    .name(oldGame.getName())
                    .genre(oldGame.getGenre())
                    .gameStatus(gameStatus)
                    .build();

            final Game updatedGame = gameRepository.save(game);
            gameSender.sendMessageWithGameInfo(updatedGame);
        });
    }
}
