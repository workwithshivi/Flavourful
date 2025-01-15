package com.app.flavourful.flavourfulDeliveryMS.controller;

import com.app.flavourful.flavourfulDeliveryMS.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    @Autowired
    DeliveryService service;

    @PostMapping("/update")
    public ResponseEntity<?> updateDelivery(@RequestParam long orderId,@RequestParam int deliveryStatus){
        String result = service.updateDeliveryStatus(orderId, deliveryStatus);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
