package org.example.editgames.infrastructure.sender;

import org.example.editgames.infrastructure.model.Game;

public interface GameSender {

    void sendMessageWithGameInfo(Game game);
}