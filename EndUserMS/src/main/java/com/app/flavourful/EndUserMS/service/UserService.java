package com.app.flavourful.EndUserMS.service;

import com.app.flavourful.EndUserMS.entity.OrderData;

public interface UserService {

    public boolean createOrder(OrderData orderData);
    public boolean postRatings(String ratings);
}
