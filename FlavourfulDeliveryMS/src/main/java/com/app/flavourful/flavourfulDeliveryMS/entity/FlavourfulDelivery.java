package com.app.flavourful.flavourfulDeliveryMS.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

import java.time.LocalDateTime;

@Entity
public class FlavourfulDelivery {

    @Id
    private long orderId;
    private String deliveryStatus;
    private LocalDateTime readyForPickup;
    @Column(nullable = false)
    private LocalDateTime pickupTime;
    @Column(nullable = false)
    private LocalDateTime deliveryTime;

    @PrePersist
    public void prePersist() {
        if (pickupTime == null) {
            pickupTime = LocalDateTime.from(LocalDateTime.of(0, 1, 1, 0, 0, 0)); // Initial value set to 00:00:00
        }
        if (deliveryTime == null) {
            deliveryTime = LocalDateTime.from(LocalDateTime.of(0, 1, 1, 0, 0, 0)); // Initial value set to 00:00:00
        }
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public LocalDateTime getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(LocalDateTime pickupTime) {
        this.pickupTime = pickupTime;
    }

    public LocalDateTime getReadyForPickup() {
        return readyForPickup;
    }

    public void setReadyForPickup(LocalDateTime readyForPickup) {
        this.readyForPickup = readyForPickup;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}
