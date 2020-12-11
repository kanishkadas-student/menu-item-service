package com.cts.menuitem.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.cts.menuitem.model.MenuItem;
import com.cts.menuitem.service.AuthService;
import com.cts.menuitem.service.MenuItemService;

@SpringBootTest
public class MenuItemControllerTests {

	@Mock
	MenuItemService menuItemService;
	@Mock
	AuthService authService;

	@Test
	void getAllMenuItemListTest() {
		MenuItemController menuItemController = new MenuItemController();
		when(authService.checkValidation(null)).thenReturn(true);
		menuItemController.setAuthService(authService);
		when(menuItemService.getAllMenuItemList()).thenReturn(null);
		menuItemController.setMenuItemService(menuItemService);
		assertEquals(HttpStatus.OK, menuItemController.getAllMenuItemList(null).getStatusCode());
	}

	@Test
	void getAllMenuItemListTest2() {
		MenuItemController menuItemController = new MenuItemController();
		when(authService.checkValidation(null)).thenReturn(false);
		menuItemController.setAuthService(authService);
		when(menuItemService.getAllMenuItemList()).thenReturn(null);
		menuItemController.setMenuItemService(menuItemService);
		assertEquals(HttpStatus.UNAUTHORIZED, menuItemController.getAllMenuItemList(null).getStatusCode());
	}

	@Test
	void getMenuItemListInStockTest() {
		MenuItemController menuItemController = new MenuItemController();
		when(authService.checkValidation(null)).thenReturn(true);
		menuItemController.setAuthService(authService);
		when(menuItemService.getMenuItemListInStock()).thenReturn(null);
		menuItemController.setMenuItemService(menuItemService);
		assertEquals(HttpStatus.OK, menuItemController.getMenuItemListInStock(null).getStatusCode());
	}

	@Test
	void getMenuItemListInStockTest2() {
		MenuItemController menuItemController = new MenuItemController();
		when(authService.checkValidation(null)).thenReturn(false);
		menuItemController.setAuthService(authService);
		when(menuItemService.getMenuItemListInStock()).thenReturn(null);
		menuItemController.setMenuItemService(menuItemService);
		assertEquals(HttpStatus.UNAUTHORIZED, menuItemController.getMenuItemListInStock(null).getStatusCode());
	}

	@Test
	void getMenuItemTest() {
		MenuItemController menuItemController = new MenuItemController();
		when(authService.checkValidation(null)).thenReturn(true);
		menuItemController.setAuthService(authService);
		MenuItem menuItem = new MenuItem(Long.valueOf(1), "Dosa", "Food", Long.valueOf(4), Double.valueOf(50));
		when(menuItemService.getMenuItem(1)).thenReturn(menuItem);
		menuItemController.setMenuItemService(menuItemService);
		assertEquals(HttpStatus.OK, menuItemController.getMenuItem(null, 1).getStatusCode());
	}

	@Test
	void getMenuItemTest2() {
		MenuItemController menuItemController = new MenuItemController();
		when(authService.checkValidation(null)).thenReturn(false);
		menuItemController.setAuthService(authService);
		MenuItem menuItem = new MenuItem(Long.valueOf(1), "Dosa", "Food", Long.valueOf(4), Double.valueOf(50));
		when(menuItemService.getMenuItem(1)).thenReturn(menuItem);
		menuItemController.setMenuItemService(menuItemService);
		assertEquals(HttpStatus.UNAUTHORIZED, menuItemController.getMenuItem(null, 1).getStatusCode());
	}

	@Test
	void addMenuItemTest() {
		MenuItemController menuItemController = new MenuItemController();
		when(authService.checkValidation(null)).thenReturn(true);
		menuItemController.setAuthService(authService);
		MenuItem menuItem = new MenuItem(Long.valueOf(1), "Dosa", "Food", Long.valueOf(4), Double.valueOf(50));
		when(menuItemService.addMenuItem(menuItem)).thenReturn(menuItem);
		menuItemController.setMenuItemService(menuItemService);
		assertEquals(HttpStatus.CREATED, menuItemController.addMenuItem(null, menuItem).getStatusCode());
	}

	@Test
	void addMenuItemTest2() {
		MenuItemController menuItemController = new MenuItemController();
		when(authService.checkValidation(null)).thenReturn(false);
		menuItemController.setAuthService(authService);
		MenuItem menuItem = new MenuItem(Long.valueOf(1), "Dosa", "Food", Long.valueOf(4), Double.valueOf(50));
		when(menuItemService.addMenuItem(menuItem)).thenReturn(menuItem);
		menuItemController.setMenuItemService(menuItemService);
		assertEquals(HttpStatus.UNAUTHORIZED, menuItemController.addMenuItem(null, menuItem).getStatusCode());
	}

	@Test
	void deleteMenuItemTest() {
		MenuItemController menuItemController = new MenuItemController();
		when(authService.checkValidation(null)).thenReturn(true);
		menuItemController.setAuthService(authService);
		MenuItem mi = new MenuItem();
		when(menuItemService.deleteMenuItem(1)).thenReturn(mi);
		menuItemController.setMenuItemService(menuItemService);
		assertEquals(HttpStatus.OK, menuItemController.deleteMenuItem(null, 1).getStatusCode());
	}

	@Test
	void deleteMenuItemTest2() {
		MenuItemController menuItemController = new MenuItemController();
		when(authService.checkValidation(null)).thenReturn(false);
		menuItemController.setAuthService(authService);
		MenuItem mi = new MenuItem();
		when(menuItemService.deleteMenuItem(1)).thenReturn(mi);
		menuItemController.setMenuItemService(menuItemService);
		assertEquals(HttpStatus.UNAUTHORIZED, menuItemController.deleteMenuItem(null, 1).getStatusCode());
	}

	@Test
	void modifyMenuItemTest() {
		MenuItemController menuItemController = new MenuItemController();
		when(authService.checkValidation(null)).thenReturn(true);
		menuItemController.setAuthService(authService);
		MenuItem menuItem = new MenuItem(Long.valueOf(1), "Dosa", "Food", Long.valueOf(4), Double.valueOf(50));
		when(menuItemService.modifyMenuItem(null, menuItem)).thenReturn(menuItem);
		menuItemController.setMenuItemService(menuItemService);
		assertEquals(HttpStatus.OK, menuItemController.modifyMenuItem(null, null, menuItem).getStatusCode());
	}

	@Test
	void modifyMenuItemTest2() {
		MenuItemController menuItemController = new MenuItemController();
		when(authService.checkValidation(null)).thenReturn(false);
		menuItemController.setAuthService(authService);
		MenuItem menuItem = new MenuItem(Long.valueOf(1), "Dosa", "Food", Long.valueOf(4), Double.valueOf(50));
		when(menuItemService.modifyMenuItem(null, menuItem)).thenReturn(menuItem);
		menuItemController.setMenuItemService(menuItemService);
		assertEquals(HttpStatus.UNAUTHORIZED, menuItemController.modifyMenuItem(null, null, menuItem).getStatusCode());
	}

	@Test
	void updateStockTest() {
		MenuItemController menuItemController = new MenuItemController();
		when(authService.checkValidation(null)).thenReturn(true);
		menuItemController.setAuthService(authService);
		MenuItem mi = new MenuItem();
		when(menuItemService.updateStock(1, 1)).thenReturn(mi);
		menuItemController.setMenuItemService(menuItemService);
		System.out.println(menuItemController.updateStock(null, 1, 1).getStatusCode());
		assertEquals(HttpStatus.OK, menuItemController.updateStock(null, 1, 1).getStatusCode());
	}

	@Test
	void updateStockTest2() {
		MenuItemController menuItemController = new MenuItemController();
		when(authService.checkValidation(null)).thenReturn(false);
		menuItemController.setAuthService(authService);
		MenuItem mi = new MenuItem();
		when(menuItemService.updateStock(1, 1)).thenReturn(mi);
		menuItemController.setMenuItemService(menuItemService);
		System.out.println(menuItemController.updateStock(null, 1, 1).getStatusCode());
		assertEquals(HttpStatus.UNAUTHORIZED, menuItemController.updateStock(null, 1, 1).getStatusCode());
	}

}
