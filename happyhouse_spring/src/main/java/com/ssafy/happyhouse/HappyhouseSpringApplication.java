package com.ssafy.happyhouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.ssafy.happyhouse.property.FileUploadProperties;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableConfigurationProperties({
	FileUploadProperties.class
})
public class HappyhouseSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HappyhouseSpringApplication.class, args);
	}

}
