package com.hashkart.cart.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hashkart.cart.service.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
}
