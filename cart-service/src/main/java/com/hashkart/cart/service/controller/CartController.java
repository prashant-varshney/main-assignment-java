package com.hashkart.cart.service.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hashkart.cart.service.entities.AddItemRequest;
import com.hashkart.cart.service.model.Checkout;
import com.hashkart.cart.service.services.CartServices;

@RestController
@RequestMapping("/cart")
public class CartController {
	private static Logger logger = LoggerFactory.getLogger(CartController.class);

    @Autowired
    CartServices cartServices;

    @GetMapping("/all")
    public ResponseEntity<Object> getAllCart() {
    	logger.info("getCartProducts {}", this.getClass().getName());
        return new ResponseEntity<>(cartServices.getAllCarts(), HttpStatus.OK);
    }

    @PostMapping("/addItem")
    public ResponseEntity<Object> addItemToCart(@RequestBody AddItemRequest addItemRequest) {
    	logger.info("Add Product to Cart {}", this.getClass().getName());
        cartServices.addItem(addItemRequest.getUserId(), addItemRequest.getProductId(), addItemRequest.getQuantity());
        return ResponseEntity.ok("Added");
    }

    @GetMapping("/checkout")
    public ResponseEntity<Object> checkoutCart(@RequestParam(value = "userId", required = true)  Integer userId, @RequestParam(value = "coupon", required = false)  String coupon){
    	logger.info("Checkout cart {}", this.getClass().getName());
        Optional<Checkout> checkout = cartServices.checkout(userId,coupon);
        return checkout.<ResponseEntity<Object>>map(value ->
                new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() ->
                new ResponseEntity<>("No cart for the given customer", HttpStatus.NO_CONTENT));
    }
}




