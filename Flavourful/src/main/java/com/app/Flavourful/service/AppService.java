package com.app.Flavourful.service;

import com.app.Flavourful.entity.OrderData;

public interface AppService {

    public boolean sendOrderUpdates(OrderData orderData);
    public String updateOrder(long orderId,int orderStatus);
}
