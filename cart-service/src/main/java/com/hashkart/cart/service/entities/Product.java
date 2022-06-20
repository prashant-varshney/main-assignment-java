package com.hashkart.cart.service.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

    private Integer id;
    private String name;
    private Double price;
    private Integer quantity;
    private Double userRating;
}
