package com.app.Flavourful.controller;



import com.app.Flavourful.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/operation")
public class OperationController {

    @Autowired
    AppService appService;

    @PostMapping("/update-order")
    public ResponseEntity<String> updateOrder(@RequestParam long orderId, @RequestParam int statusCode){

        return new ResponseEntity<>(appService.updateOrder(orderId,statusCode), HttpStatus.OK);
    }


//    @PostMapping("/update")
//    public ResponseEntity<?> updateLocation(){
//
//        //random latitude and longitude
//        for(int i=0;i<=100000;i++) {
//            String location = "(" + Math.round(Math.random() * 100) + "," + Math.round(Math.random() * 100) + ")";
//            this.service.updateLocation(location);
//        }
//        return new ResponseEntity<>(Map.of("message","Location Updated:"), HttpStatus.OK);
//    }
}
