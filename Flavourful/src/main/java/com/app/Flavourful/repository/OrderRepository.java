package com.app.Flavourful.repository;

import com.app.Flavourful.entity.OrderData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<OrderData,Long> {

    @Modifying
    @Query("UPDATE OrderData o SET o.orderStatus = :orderStatus WHERE o.orderId = :orderId")
    int updateOrderStatusByOrderId(@Param("orderStatus") String orderStatus, @Param("orderId") long orderId);
}
