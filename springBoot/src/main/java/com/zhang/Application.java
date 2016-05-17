package com.zhang;

import com.zhang.config.AuthorSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Application {

	@Autowired
	private AuthorSettings authorSettings;

	@RequestMapping("/")
	public  String index(){
		return "author name is " + authorSettings.getName() + " and author age is " + authorSettings.getAge();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
