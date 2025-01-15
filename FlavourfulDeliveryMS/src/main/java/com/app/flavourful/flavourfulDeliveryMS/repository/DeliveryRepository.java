package com.app.flavourful.flavourfulDeliveryMS.repository;

import com.app.flavourful.flavourfulDeliveryMS.entity.FlavourfulDelivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<FlavourfulDelivery, Long> {
}
