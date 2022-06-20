package com.hashkart.cart.service.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Data
public class Item {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer productId;
    private Integer quantity;
}
