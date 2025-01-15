package com.app.flavourful.EndUserMS.service.impl;

import com.app.flavourful.EndUserMS.constant.AppConstant;
import com.app.flavourful.EndUserMS.entity.OrderData;
import com.app.flavourful.EndUserMS.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;

    @Override
    public boolean createOrder(OrderData orderData) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String orderDataJSON = objectMapper.writeValueAsString(orderData);
            kafkaTemplate.send(AppConstant.FLAVOURFUL_NEW_ORDER, orderDataJSON);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    @Override
    public boolean postRatings(String ratings) {
        try {
            kafkaTemplate.send(AppConstant.FLAVOURFUL_NEW_ORDER,ratings);
            return true;
        }catch (Exception ex){
            return false;
        }
    }
}
