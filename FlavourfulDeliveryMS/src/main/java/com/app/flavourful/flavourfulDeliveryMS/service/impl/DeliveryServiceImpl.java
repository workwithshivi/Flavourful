package com.app.flavourful.flavourfulDeliveryMS.service.impl;


import com.app.flavourful.flavourfulDeliveryMS.constant.AppConstant;
import com.app.flavourful.flavourfulDeliveryMS.constant.ApplicationCodes;
import com.app.flavourful.flavourfulDeliveryMS.entity.FlavourfulDelivery;
import com.app.flavourful.flavourfulDeliveryMS.repository.DeliveryRepository;
import com.app.flavourful.flavourfulDeliveryMS.service.DeliveryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    DeliveryRepository repository;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    Logger log = LoggerFactory.getLogger(DeliveryServiceImpl.class);

    @Override
    public String updateDeliveryStatus(long orderId, int deliveryStatus) {
        log.info("OrderId: {} , Status: {}",orderId,ApplicationCodes.fromCode(deliveryStatus).name());
        Optional<FlavourfulDelivery> order = repository.findById(orderId);

        if (order.isEmpty()) {
            FlavourfulDelivery delivery = new FlavourfulDelivery();
            delivery.setOrderId(orderId);
            delivery.setDeliveryStatus(ApplicationCodes.fromCode(deliveryStatus).name());
            delivery.setReadyForPickup(LocalDateTime.now());
            repository.save(delivery);
            return "Delivery Partner Assigned";
        } else {
            FlavourfulDelivery delivery = order.get();
            delivery.setDeliveryStatus(ApplicationCodes.fromCode(deliveryStatus).name());
            if (ApplicationCodes.fromCode(deliveryStatus).name().equals(ApplicationCodes.ORDER_PICKED.name())) {
                delivery.setPickupTime(LocalDateTime.now());
            } else if (ApplicationCodes.fromCode(deliveryStatus).name().equals(ApplicationCodes.DELIVERED.name())) {
                delivery.setDeliveryTime(LocalDateTime.now());
            }
            repository.save(delivery);
            kafkaTemplate.send(AppConstant.FLAVOURFUL_ORDER_UPDATE, "Delivery Update: OrderId: " + orderId + " Status: " + ApplicationCodes.fromCode(deliveryStatus).name());
        }
        return "Delivery Updated";
    }
}
