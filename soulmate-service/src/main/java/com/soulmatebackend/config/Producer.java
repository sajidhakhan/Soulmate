package com.soulmatebackend.config;


import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rabbitMq.UserDTO;

@Component
public class Producer {

    private RabbitTemplate rabbitTemplate;
    private DirectExchange exchange;

    @Autowired
    public Producer(RabbitTemplate rabbitTemplate, DirectExchange exchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.exchange = exchange;
    }

    public void sendMessageToRabbitTemplate(UserDTO userDTO){
        rabbitTemplate.convertAndSend(exchange.getName(),"customer_routing",userDTO);
    }
}
