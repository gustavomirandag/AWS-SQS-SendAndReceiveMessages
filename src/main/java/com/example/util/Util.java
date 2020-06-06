/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.util;

import com.example.service.CartService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gustavo
 */
public class Util {
    public static String Serialize(Object obj){
        //Serialize the Command
        ObjectMapper mapper = new ObjectMapper();
        String serializedCommand = "";
        try {
            serializedCommand = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(CartService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return serializedCommand;
    }
    
    public static Object Deserialize(String serializedCommand, Object obj){
        //Serialize the Command
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(serializedCommand, obj.getClass());
        } catch (JsonProcessingException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
