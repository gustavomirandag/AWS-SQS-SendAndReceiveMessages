package com.example;

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
            SqsService service = new SqsService();
            service.sendSomething("msg 1");
            //service.sendSomething("msg 2");
            //service.sendSomething("msg 3");
            //service.sendSomething("msg 4");
            service.receiveSomething();
            //service.receiveSomethingWithLongPolling();
        }

}
