package org.example.editgames.infrastructure.sender;

import org.example.editgames.infrastructure.config.RabbitmqConfig;
import org.example.editgames.infrastructure.model.Game;
import org.example.editgames.infrastructure.model.GameMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class GameQueueSenderImpl implements GameQueueSender {

    Logger logger = LoggerFactory.getLogger(GameQueueSenderImpl.class);

    private final RabbitTemplate rabbitTemplate;

    public GameQueueSenderImpl(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void sendMessageWithGameInfo(final Game game) {
        final GameMessage gameMessage = GameMessage.builder()
                .id(game.getId())
                .name(game.getName())
                .genre(game.getGenre())
                .price(game.getPrice())
                .status(game.getGameStatus())
                .build();

        logger.info("Send info about game to " + RabbitmqConfig.topicExchangeName + " topic");
        rabbitTemplate.convertAndSend(RabbitmqConfig.topicExchangeName, "game.saved." + game.getId(), gameMessage);
        logger.info("Info was send!");
    }
}
