package com.webapp.websocketApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class WebsocketAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebsocketAppApplication.class, args);
	}

}
