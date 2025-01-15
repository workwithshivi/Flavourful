package com.app.flavourful.EndUserMS.config;

import com.app.flavourful.EndUserMS.constant.AppConstant;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class Notifications {

    @KafkaListener(topics = AppConstant.FLAVOURFUL_ORDER_UPDATE,groupId = "group-1")
    public void orderNotifications(String message){
        System.out.println(message);
    }
}
