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
public class AddProductToCartCommand extends ProductCommand{
    public AddProductToCartCommand(){
        super(null, "add-product-to-cart-command-queue");
    }
    
    public AddProductToCartCommand(Product product){
        super(product, "add-product-to-cart-command-queue");
    }
}
