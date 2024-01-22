package com.chamith.springtdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringTddApplicationTests {

	@Autowired
	private SpringTddApplication springTddApplication;

	@Test
	public void testNumber(){
		int number = 1 ;
		String numberReturned = springTddApplication.play(number);
		Assert.assertEquals("1",numberReturned);
	}

	@Test
	public void testFizz(){
		int number = 3;
		String numberReturned = springTddApplication.play(number);
		Assert.assertEquals("Fizz" , numberReturned);
	}

	@Test
	public void testFizzDivisibleBy3(){
		int number = 6;
		String numberReturned = springTddApplication.play(number);
		Assert.assertEquals("Fizz" , numberReturned);
	}

	@Test
	public void testBuzz(){
		int number = 5;
		String numberReturned = springTddApplication.play(number);
		Assert.assertEquals("Buzz" , numberReturned);
	}

}
