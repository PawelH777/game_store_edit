package org.example.editgames.infrastructure.config;

import org.example.editgames.infrastructure.model.GameMessage;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.DefaultJackson2JavaTypeMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RabbitmqConfig {

    public static final String topicExchangeName = "games-exchange";

    public static final String queueName = "games-queue";

    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(topicExchangeName);
    }

    @Bean
    Binding binding(final Queue queue, final TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("game.saved.#");
    }

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final var rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        final Jackson2JsonMessageConverter messageConverter = new Jackson2JsonMessageConverter();
        final DefaultJackson2JavaTypeMapper classMapper = new DefaultJackson2JavaTypeMapper();
        classMapper.setIdClassMapping(Map.of("gameMessage", GameMessage.class));
        messageConverter.setClassMapper(classMapper);
        return messageConverter;
    }

}
