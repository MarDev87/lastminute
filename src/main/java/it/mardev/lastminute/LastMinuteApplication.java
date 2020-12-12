package it.mardev.lastminute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LastMinuteApplication {

	public static ConfigurableApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(LastMinuteApplication.class, args);
	}
	
}
