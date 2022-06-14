package com.aladhas.ALrestaurant;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AlRestaurantApplication {

	public static void main(String[] args) {
		
//		new File(MenuController.uploadDirectory).mkdir();
		
		SpringApplication.run(AlRestaurantApplication.class, args);
	}

}
