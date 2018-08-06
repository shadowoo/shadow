package com.guava.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheApplicationTests {

	@Test
	public void contextLoads() throws NoSuchFieldException, IllegalAccessException {
		System.out.println("ces");

		String s ="hello";
		rs(s);
		System.out.println(s);
	}

	private void rs(String s) throws IllegalAccessException, NoSuchFieldException {
		Field field = String.class.getDeclaredField("value");
		field.setAccessible(true);
		field.set(s,"world".toCharArray());
	}


}
