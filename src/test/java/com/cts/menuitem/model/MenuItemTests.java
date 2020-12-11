package com.cts.menuitem.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.menuitem.model.MenuItem;

@SpringBootTest
public class MenuItemTests {

	@Test
	void toStringTest() {
		MenuItem menuItem = new MenuItem();

		assertEquals(menuItem.toString(), menuItem.toString());
	}
	
	@Test
	void menuItemIdTest() {
		MenuItem menuItem = new MenuItem();
		menuItem.setItemId(Long.valueOf(1));
		assertEquals(Long.valueOf(1), menuItem.getItemId());
	}
	
	@Test
	void menuItemIdTest2() {
		MenuItem menuItem = new MenuItem();
		menuItem.setItemId(null);
		assertNull(menuItem.getItemId());
	}
	
	@Test
	void menuItemNameTest() {
		MenuItem menuItem = new MenuItem();
		menuItem.setItemName("Dosa");
		assertEquals("Dosa", menuItem.getItemName());
	}
	
	@Test
	void menuItemPriceTest() {
		MenuItem menuItem = new MenuItem();
		menuItem.setItemPrice(Double.valueOf(50));;
		assertEquals(50, menuItem.getItemPrice());
	}
	
	@Test
	void menuItemTypeTest() {
		MenuItem menuItem = new MenuItem();
		menuItem.setItemType("South Indian");;
		assertEquals("South Indian", menuItem.getItemType());
	}
	
	@Test
	void menuItemStockTest() {
		MenuItem menuItem = new MenuItem();
		menuItem.setItemStock(Long.valueOf(5));;
		assertEquals(Long.valueOf(5), menuItem.getItemStock());
	}

	@Test
	void constructorTest() {
		MenuItem menuItem = new MenuItem(Long.valueOf(1),"Dosa","Food",Long.valueOf(4),Double.valueOf(50));

		assertEquals("Dosa", menuItem.getItemName());
	}

	
}
