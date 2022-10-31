package org.example.editgames.infrastructure.sender;

import org.example.editgames.infrastructure.model.EventType;
import org.example.editgames.infrastructure.model.Game;

public interface GameQueueSender {

    void sendMessageWithGameInfo(Game game, EventType eventType);
}
