/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cqrs.commandhandlers;

import com.example.SqsService;
import com.example.cqrs.commands.AddProductToCartCommand;
import com.example.cqrs.commands.UpdateProductCommand;
import com.example.cqrs.events.ProductAddedToCartEvent;
import com.example.util.Util;

/**
 *
 * @author Gustavo
 */
public class ProductCommandHandler {
    
    private SqsService _sqsService;
    
    public ProductCommandHandler(SqsService sqsService){
        _sqsService = sqsService;
    }
    
    public void Handle(AddProductToCartCommand command){
        //Add product to cart
        //.....
        
        
        //After... send the event
        ProductAddedToCartEvent productAddedToCartEvent = new ProductAddedToCartEvent(command.product);
        String serializedEvent = Util.Serialize(productAddedToCartEvent);
        _sqsService.sendSomething(serializedEvent, productAddedToCartEvent.queueName);
        _sqsService.sendSomething(serializedEvent, "source-of-truth-queue");
    }
    
    public void Handle(UpdateProductCommand command){
        //Update product to cart
        //.......
        
        
        //After... send the event
        UpdateProductCommand updateProductEvent = new UpdateProductCommand(command.product);
        String serializedEvent = Util.Serialize(updateProductEvent);
        _sqsService.sendSomething(serializedEvent, updateProductEvent.queueName);
        _sqsService.sendSomething(serializedEvent, "source-of-truth-queue");
    }
}
