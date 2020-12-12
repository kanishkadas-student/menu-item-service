package com.cts.menuitem.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MenuNotFoundExceptionTest {
	//test1 for menu item not found
	@Test
	void test() {
		MenuItemNotFoundException mi = new MenuItemNotFoundException();
		assertEquals(mi, mi);
	}
	//test2 for menu item not found
	@Test
	void test2() {
		MenuItemNotFoundException mi = new MenuItemNotFoundException("exception");
		assertEquals(mi, mi);
	}

}
