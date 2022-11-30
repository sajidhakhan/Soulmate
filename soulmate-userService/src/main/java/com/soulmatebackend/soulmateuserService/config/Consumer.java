package com.soulmatebackend.soulmateuserService.config;


import com.soulmatebackend.soulmateuserService.domain.User;
import com.soulmatebackend.soulmateuserService.service.UserServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rabbitMq.UsrDTO;

@Component
public class Consumer {

    @Autowired
    private UserServiceImpl userService;

    @RabbitListener(queues = "customer_queue")
    public void getCustomerFromRabbitMQ(UsrDTO userDTO){
        try {
            User user = new User(userDTO.getEmail(), userDTO.getPassword());
            System.out.println(userDTO.getEmail());
            userService.saveUser(user);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
