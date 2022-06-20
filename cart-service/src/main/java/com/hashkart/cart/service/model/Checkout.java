package com.hashkart.cart.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Checkout{
    private Cart cart;
    private Double totalPrice;
    private Double discount;
    private Double couponDiscount;
}
