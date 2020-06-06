/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cqrs.commands;

import com.example.model.Product;

/**
 *
 * @author Gustavo
 */
public class ProductCommand extends Command{
    public Product product;
    
    public ProductCommand(Product product, String queueName){
        super(queueName);
        this.product = product;
    }
}
