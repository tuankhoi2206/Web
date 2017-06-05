package com.yuen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//@SpringBootApplication là tương đương với việc sử dụng @Configuration,
//@EnableAutoConfiguration và @ComponentScan với các thuộc tính mặc định của chúng.
@SpringBootApplication
public class SpringGettingStartedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringGettingStartedApplication.class, args);
	}
}
