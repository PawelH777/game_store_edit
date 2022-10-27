package org.example.editgames.infrastructure.sender;

import org.example.editgames.infrastructure.config.RabbitmqConfig;
import org.example.editgames.infrastructure.model.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class GameSenderImpl implements GameSender {

    Logger logger = LoggerFactory.getLogger(GameSenderImpl.class);

    private final RabbitTemplate rabbitTemplate;

    public GameSenderImpl(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void sendMessageWithGameInfo(final Game game) {
        logger.info("Send info about game to " + RabbitmqConfig.topicExchangeName + " topic");
        rabbitTemplate.convertAndSend(RabbitmqConfig.topicExchangeName, "game.saved", game);
        logger.info("Info was send!");
    }
}
