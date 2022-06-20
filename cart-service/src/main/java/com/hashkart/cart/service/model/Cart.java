package com.hashkart.cart.service.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cart {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer userId;
    @OneToMany(targetEntity=Item.class, fetch= FetchType.EAGER)
    private List<Item> itemList;

}
