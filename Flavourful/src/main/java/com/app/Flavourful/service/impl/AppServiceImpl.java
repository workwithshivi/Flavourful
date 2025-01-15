package com.app.Flavourful.service.impl;


import com.app.Flavourful.constant.AppConstant;
import com.app.Flavourful.constant.ApplicationCodes;
import com.app.Flavourful.entity.OrderData;
import com.app.Flavourful.repository.OrderRepository;
import com.app.Flavourful.service.AppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class AppServiceImpl implements AppService {
    Logger log = LoggerFactory.getLogger(AppService.class);
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    OrderRepository repository;

    @Override
    @Transactional
    public boolean sendOrderUpdates(OrderData orderData) {
        orderData.setOrderStatus(ApplicationCodes.NEW_ORDER.name());
        repository.save(orderData);
        kafkaTemplate.send(AppConstant.FLAVOURFUL_ORDER_UPDATE, orderData.getOrderId() + ": " + ApplicationCodes.RECEIVED);
        return true;
    }

    @Override
    @Transactional
    public String updateOrder(long orderId, int orderStatus) {
        log.info("Updating status for Order Id: {}", orderId);
        String message = null;
        int result = repository.updateOrderStatusByOrderId(ApplicationCodes.fromCode(orderStatus).name(), orderId);
        if (result > 0) {
            message = "Order with id" + orderId + ", Status: " + ApplicationCodes.fromCode(orderStatus);
            kafkaTemplate.send(AppConstant.FLAVOURFUL_ORDER_UPDATE, "Order with id" + orderId + ", Status: " + ApplicationCodes.fromCode(orderStatus));
        }
        if(orderStatus==4){
            kafkaTemplate.send(AppConstant.FLAVOURFUL_DELIVERY_UPDATE,   orderId + ":" + orderStatus);
        }
        return message;
    }

}
