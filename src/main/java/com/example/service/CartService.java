/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.service;

import com.example.SqsService;
import com.example.cqrs.commands.AddProductToCartCommand;
import com.example.cqrs.commands.UpdateProductCommand;
import com.example.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gustavo
 */
public class CartService {
    
    private SqsService _sqsService;
    
    public CartService(SqsService sqsService){
        _sqsService = sqsService;
    }
    
    public boolean addProductToCart(Product product){
        //Create the Command
        AddProductToCartCommand addProductToCartCommand = 
                new AddProductToCartCommand(product);
        
        //Serialize the Command
        ObjectMapper mapper = new ObjectMapper();
        String serializedCommand = "";
        try {
            serializedCommand = mapper.writeValueAsString(addProductToCartCommand);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(CartService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Send the Command to SQS
        String result = _sqsService.sendSomething(serializedCommand, addProductToCartCommand.queueName);
        
        if (result != null)
            return true;
        return false;
        
    }
    
        public boolean updateProduct(Product product){
        //Create the Command
        UpdateProductCommand updateProductCommand = 
                new UpdateProductCommand(product);
        
        //Serialize the Command
        ObjectMapper mapper = new ObjectMapper();
        String serializedCommand = "";
        try {
            serializedCommand = mapper.writeValueAsString(updateProductCommand);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(CartService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Send the Command to SQS
        String result = _sqsService.sendSomething(serializedCommand, updateProductCommand.queueName);
        
        if (result != null)
            return true;
        return false;
        
    }
}
