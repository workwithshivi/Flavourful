package com.app.Flavourful.config;

import com.app.Flavourful.constant.AppConstant;
import com.app.Flavourful.entity.OrderData;
import com.app.Flavourful.service.AppService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConfig {

    @Autowired
    AppService appService;

    @KafkaListener(topics = AppConstant.FLAVOURFUL_NEW_ORDER,groupId = "group-1")
    public void getOrderNotification(String orderDataJSON) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        OrderData orderData = objectMapper.readValue(orderDataJSON, OrderData.class);
        System.out.println(orderData);
        appService.sendOrderUpdates(orderData);
    }
}
