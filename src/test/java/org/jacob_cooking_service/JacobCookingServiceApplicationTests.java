package org.jacob_cooking_service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JacobCookingServiceApplicationTests {

	@Test
	public void contextLoads() {
		String test1 = "hello.com/w54";
		String test2 = "w33";

		test1 = "hello.com/" + test2;
		System.out.println(test1);
	}

}
