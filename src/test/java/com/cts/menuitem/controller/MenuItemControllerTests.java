package com.cts.menuitem.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.cts.menuitem.model.MenuItem;
import com.cts.menuitem.service.MenuItemService;

@SpringBootTest
public class MenuItemControllerTests {

	@Mock
	MenuItemService menuItemService;

	@Test
	void getAllMenuItemListTest() {
		MenuItemController menuItemController = new MenuItemController();
		when(menuItemService.getAllMenuItemList()).thenReturn(null);
		menuItemController.setMenuItemService(menuItemService);
		assertNull(menuItemController.getAllMenuItemList());
	}

	@Test
	void getMenuItemListInStockTest() {
		MenuItemController menuItemController = new MenuItemController();
		when(menuItemService.getMenuItemListInStock()).thenReturn(null);
		menuItemController.setMenuItemService(menuItemService);
		assertNull(menuItemController.getMenuItemListInStock());
	}

	@Test
	void getMenuItemTest() {
		MenuItemController menuItemController = new MenuItemController();
		MenuItem menuItem = new MenuItem(Long.valueOf(1), "Dosa", "Food", Long.valueOf(4), Double.valueOf(50));
		when(menuItemService.getMenuItem(1)).thenReturn(menuItem);
		menuItemController.setMenuItemService(menuItemService);
		assertEquals(HttpStatus.OK, menuItemController.getMenuItem(1).getStatusCode());
	}

	@Test
	void addMenuItemTest() {
		MenuItemController menuItemController = new MenuItemController();
		MenuItem menuItem = new MenuItem(Long.valueOf(1), "Dosa", "Food", Long.valueOf(4), Double.valueOf(50));
		when(menuItemService.addMenuItem(menuItem)).thenReturn("Added");
		menuItemController.setMenuItemService(menuItemService);
		assertEquals("Added", menuItemController.addMenuItem(menuItem));
	}

	@Test
	void deleteMenuItemTest() {
		MenuItemController menuItemController = new MenuItemController();
		// MenuItem menuItem = new
		// MenuItem(Long.valueOf(1),"Dosa","Food",Long.valueOf(4),Double.valueOf(50));
		when(menuItemService.deleteMenuItem(1)).thenReturn("Deleted");
		menuItemController.setMenuItemService(menuItemService);
		assertEquals("Deleted", menuItemController.deleteMenuItem(1));
	}
	
	@Test
	void modifyMenuItemTest() {
		MenuItemController menuItemController = new MenuItemController();
		MenuItem menuItem = new MenuItem(Long.valueOf(1), "Dosa", "Food", Long.valueOf(4), Double.valueOf(50));
		when(menuItemService.modifyMenuItem(menuItem)).thenReturn("Updated");
		menuItemController.setMenuItemService(menuItemService);
		assertEquals("Updated", menuItemController.modifyMenuItem(menuItem));
	}

	@Test
	void updateStockTest() {
		MenuItemController menuItemController = new MenuItemController();
		when(menuItemService.updateStock(1, 1)).thenReturn(true);
		menuItemController.setMenuItemService(menuItemService);
		assertEquals(true, menuItemController.updateStock(1, 1));
	}

}
