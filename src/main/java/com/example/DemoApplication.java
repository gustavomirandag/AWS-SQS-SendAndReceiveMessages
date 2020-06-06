package com.example;

import com.example.cqrs.commandhandlers.ProductCommandHandler;
import com.example.cqrs.commands.AddProductToCartCommand;
import com.example.model.Product;
import com.example.service.CartService;
import com.example.util.Util;
import java.util.List;
import java.util.UUID;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner  {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
        
        @Override
        public void run(String... args) throws Exception {
            
            //Create the Services
            SqsService sqsService = new SqsService();
            CartService cartService = new CartService(sqsService);
            ProductCommandHandler commandHandler = new ProductCommandHandler(sqsService);
            
            //Create the Product
            Product product = new Product();
            product.id = UUID.randomUUID();
            product.name = "Samsung A51";
            product.price = 1700;
            product.category = "Phone";
            
            //Producer Simulation
            boolean result = cartService.addProductToCart(product);
            if (result == true)
                System.out.println("Adicionado com sucesso!");
            else
                System.out.println("Falha ao tentar adicionar produto ao carrinho!");
            
            
            //Consumer Simulation
            List<String> serializedCommands = sqsService.receiveSomething("add-product-to-cart-command-queue");
            for(String serializedCommand : serializedCommands){
                AddProductToCartCommand addProductToCartCommand = new AddProductToCartCommand();
                addProductToCartCommand = (AddProductToCartCommand) Util.Deserialize(serializedCommand, addProductToCartCommand);
                commandHandler.Handle(addProductToCartCommand);                
            }

            
            
            
            //sqsService.sendSomething("msg 1");
            //sqsService.sendSomething("msg 2");
            //sqsService.sendSomething("msg 3");
            //sqsService.sendSomething("msg 4");
            //sqsService.receiveSomething();
            //sqsService.receiveSomethingWithLongPolling();
        }

}
