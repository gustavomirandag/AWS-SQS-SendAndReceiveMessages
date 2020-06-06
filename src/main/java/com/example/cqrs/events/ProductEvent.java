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
public class ProductEvent extends DomainEvent{
    public Product product;
    
    public ProductEvent(Product product, String queueName){
        super(queueName);
        this.product = product;
    }
}
