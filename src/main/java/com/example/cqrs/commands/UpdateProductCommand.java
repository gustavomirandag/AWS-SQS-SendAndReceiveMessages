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
public class UpdateProductCommand extends ProductCommand{
    
    public UpdateProductCommand(){
        super(null,"update-product-command-queue");
    }
    
    public UpdateProductCommand(Product product){
        super(product, "update-product-command-queue");
    }
}
