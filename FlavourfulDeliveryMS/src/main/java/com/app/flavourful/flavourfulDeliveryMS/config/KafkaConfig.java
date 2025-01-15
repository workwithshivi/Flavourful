package com.app.flavourful.flavourfulDeliveryMS.config;

import com.app.flavourful.flavourfulDeliveryMS.constant.AppConstant;
import com.app.flavourful.flavourfulDeliveryMS.service.DeliveryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConfig {

    @Autowired
    DeliveryService deliveryService;

    @KafkaListener(topics = AppConstant.FLAVOURFUL_DELIVERY_UPDATE,groupId = "group-1")
    public void getOrderNotification(String deliveryData) throws JsonProcessingException {
        String[] res = deliveryData.split(":");
        deliveryService.updateDeliveryStatus(Long.parseLong(res[0]),Integer.parseInt(res[1]));
    }
}
