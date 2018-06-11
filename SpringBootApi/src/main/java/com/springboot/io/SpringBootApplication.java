package com.springboot.io;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication implements CommandLineRunner {

	@Autowired
	private ApplicationContext appContext;

	public static void main(String args[]) {
		SpringApplication.run(SpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String[] beans = appContext.getBeanDefinitionNames();
		Arrays.sort(beans);
		for (String bean : beans) {
			System.out.println(bean);
		}
	}
}
