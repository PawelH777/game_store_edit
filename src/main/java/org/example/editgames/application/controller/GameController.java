package org.example.editgames.application.controller;

import org.example.editgames.application.model.ChangeGameStatusRequest;
import org.example.editgames.application.model.CreateGameResponse;
import org.example.editgames.application.model.GameDraftRequest;
import org.example.editgames.domain.model.GameDO;
import org.example.editgames.domain.model.GameStatus;
import org.example.editgames.domain.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GameController {

    private final GameService gameService;

    public GameController(final GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    ResponseEntity<CreateGameResponse> createGame(@RequestBody final GameDraftRequest gameDraftRequest) {
        final long newGameId = gameService.createGame(buildGame(gameDraftRequest, GameStatus.UNPUBLISHED));
        return ResponseEntity.status(200)
                .body(CreateGameResponse.builder().id(newGameId).build());
    }

    @PutMapping("/{id}")
    ResponseEntity<Object> updateGame(@PathVariable final long id, @RequestBody final GameDraftRequest gameDraftRequest) {
        gameService.updateGame(id, buildGame(gameDraftRequest, GameStatus.MODIFIED));
        return ResponseEntity.status(200).build();
    }

    @PatchMapping("/{id}")
    ResponseEntity<Object> changeGameStatus(@PathVariable final long id, @RequestBody final ChangeGameStatusRequest changeGameStatusRequest) {
        gameService.changeGameStatus(id, changeGameStatusRequest.getGameStatus());
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Object> deleteGame(@PathVariable final long id) {
        gameService.deleteGame(id);
        return ResponseEntity.status(200).build();
    }


    private GameDO buildGame(final GameDraftRequest gameDraft, final GameStatus gameStatus) {
        return GameDO.builder()
                .name(gameDraft.getName())
                .genre(gameDraft.getGenre())
                .price(gameDraft.getPrice())
                .gameStatus(gameStatus)
                .build();
    }
}
