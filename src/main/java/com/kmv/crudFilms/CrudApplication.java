package com.kmv.crudFilms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.ContextClosedEvent;


@SpringBootApplication
@ComponentScan(basePackages = { "com.kmv" })
public class CrudApplication {

	private static Logger logger = LoggerFactory.getLogger(CrudApplication.class);

	public static ConfigurableApplicationContext startMicroService(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(CrudApplication.class, args);
		ctx.addApplicationListener((ContextClosedEvent arg0) -> ctx.close());
		return ctx;
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = CrudApplication.startMicroService(args);
		if (ctx.isActive() && logger.isInfoEnabled()) {
			logger.info(" [crud-service] started correctly.");
		}
	}
	
}
