package com.chamith.springtdd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringTddApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTddApplication.class, args);
	}

    public String play(int number) {
		if(number % 3 == 0){
			return "Fizz" ;
		}else if(number % 5 ==0 ){
			return "Buzz" ;
		}
		else{
			return String.valueOf(number);
		}
    }
}
