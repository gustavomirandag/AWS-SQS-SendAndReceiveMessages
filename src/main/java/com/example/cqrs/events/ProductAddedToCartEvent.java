/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cqrs.events;

import com.example.model.Product;

/**
 *
 * @author Gustavo
 */
public class ProductAddedToCartEvent extends ProductEvent{
    public ProductAddedToCartEvent(){
        super(null, "product-added-to-cart-event-queue");
    }
    
    public ProductAddedToCartEvent(Product product){
        super(product, "product-added-to-cart-event-queue");
    }
}
