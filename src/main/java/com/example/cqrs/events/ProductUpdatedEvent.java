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
public class ProductUpdatedEvent extends ProductEvent{
    
    public ProductUpdatedEvent(){
        super(null, "product-udpated-event-queue");
    }
    
    public ProductUpdatedEvent(Product product){
        super(product, "product-udpated-event-queue");
    }
}
