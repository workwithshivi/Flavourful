package com.app.flavourful.EndUserMS.controller;


import com.app.flavourful.EndUserMS.entity.OrderData;
import com.app.flavourful.EndUserMS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("createOrder")
    public ResponseEntity<?> createOrder(@RequestBody OrderData orderData) {
        String orderDetails = "1 Samosa";

        boolean result = userService.createOrder(orderData);
        if (result) {
            return new ResponseEntity<>(Map.of("Message", "Order Created"), HttpStatus.OK);
        }
        return new ResponseEntity<>(Map.of("Message", "Order Failed"), HttpStatus.EXPECTATION_FAILED);
    }

    @PostMapping("orderRatings")
    public ResponseEntity<?> postOrderRatings(String ratings) {
        return null;
    }
}
