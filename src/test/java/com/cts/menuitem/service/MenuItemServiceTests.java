package com.cts.menuitem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.menuitem.model.MenuItem;
import com.cts.menuitem.repository.MenuItemRepository;

@SpringBootTest
public class MenuItemServiceTests {

	@Mock
	MenuItemRepository menuItemRepository;

	@Test
	void getAllMenuItemListTest() {
		MenuItemServiceImpl menuItemServiceImpl = new MenuItemServiceImpl();

		ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
		MenuItem m1 = new MenuItem(Long.valueOf(1), "ss", "food", Long.valueOf(4), Double.valueOf(40));
		MenuItem m2 = new MenuItem(Long.valueOf(2), "sa", "food", Long.valueOf(2), Double.valueOf(80));
		menuItemList.add(m1);
		menuItemList.add(m2);

		when(menuItemRepository.findAll()).thenReturn(menuItemList);
		menuItemServiceImpl.setMenuItemRepository(menuItemRepository);
		assertEquals(2, menuItemServiceImpl.getAllMenuItemList().size());
	}

	@Test
	void getMenuItemListInStockTest() {
		MenuItemServiceImpl menuItemServiceImpl = new MenuItemServiceImpl();

		ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
		MenuItem m1 = new MenuItem(Long.valueOf(1), "ss", "food", Long.valueOf(4), Double.valueOf(40));
		MenuItem m2 = new MenuItem(Long.valueOf(2), "sa", "food", Long.valueOf(2), Double.valueOf(80));
		menuItemList.add(m1);
		menuItemList.add(m2);

		when(menuItemRepository.getMenuItemBAsedOnStock()).thenReturn(menuItemList);
		menuItemServiceImpl.setMenuItemRepository(menuItemRepository);
		assertEquals(2, menuItemServiceImpl.getMenuItemListInStock().size());
	}

	@Test
	void getMenuItemTest() {
		MenuItemServiceImpl menuItemServiceImpl = new MenuItemServiceImpl();

		MenuItem m1 = new MenuItem(Long.valueOf(1), "ss", "food", Long.valueOf(4), Double.valueOf(40));

		when(menuItemRepository.findById(Long.valueOf(1))).thenReturn(Optional.of(m1));
		menuItemServiceImpl.setMenuItemRepository(menuItemRepository);
		assertEquals("ss", menuItemServiceImpl.getMenuItem(1).getItemName());
	}

	@Test
	void modifyMenuItemTest() {
		MenuItemServiceImpl menuItemServiceImpl = new MenuItemServiceImpl();

		MenuItem m1 = new MenuItem(Long.valueOf(1), "ss", "food", Long.valueOf(4), Double.valueOf(40));

		when(menuItemRepository.save(m1)).thenReturn(m1);
		when(menuItemRepository.findById(Long.valueOf(1))).thenReturn(Optional.of(m1));
		menuItemServiceImpl.setMenuItemRepository(menuItemRepository);
		assertNull(menuItemServiceImpl.modifyMenuItem(null, m1));
	}

	@Test
	void modifyMenuItemTest2() {
		MenuItemServiceImpl menuItemServiceImpl = new MenuItemServiceImpl();

		MenuItem m1 = new MenuItem(Long.valueOf(1), "ss", "food", Long.valueOf(4), Double.valueOf(40));

		when(menuItemRepository.save(m1)).thenReturn(m1);
		when(menuItemRepository.findById(Long.valueOf(1))).thenReturn(Optional.of(m1));
		menuItemServiceImpl.setMenuItemRepository(menuItemRepository);
		assertEquals(m1, menuItemServiceImpl.modifyMenuItem(Long.valueOf(1), m1));
	}

	@Test
	void modifyMenuItemTest3() {
		MenuItemServiceImpl menuItemServiceImpl = new MenuItemServiceImpl();

		MenuItem m1 = new MenuItem(Long.valueOf(1), "ss", "food", Long.valueOf(4), Double.valueOf(40));

		when(menuItemRepository.save(m1)).thenThrow(NullPointerException.class);
		when(menuItemRepository.findById(Long.valueOf(1))).thenReturn(Optional.of(m1));
		menuItemServiceImpl.setMenuItemRepository(menuItemRepository);
		assertNull(menuItemServiceImpl.modifyMenuItem(Long.valueOf(1), m1));
	}

	@Test
	void updateStockTest() {
		MenuItemServiceImpl menuItemServiceImpl = new MenuItemServiceImpl();

		MenuItem m1 = new MenuItem(Long.valueOf(1), "ss", "food", Long.valueOf(4), Double.valueOf(40));

		when(menuItemRepository.save(m1)).thenReturn(m1);
		when(menuItemRepository.findById(Long.valueOf(1))).thenReturn(Optional.of(m1));
		menuItemServiceImpl.setMenuItemRepository(menuItemRepository);
		assertEquals(m1, menuItemServiceImpl.updateStock(1, 1));
	}

	@Test
	void addMenuItemTest() {
		MenuItemServiceImpl menuItemServiceImpl = new MenuItemServiceImpl();

		MenuItem m1 = new MenuItem(Long.valueOf(1), "ss", "food", Long.valueOf(4), Double.valueOf(40));

		when(menuItemRepository.save(m1)).thenReturn(m1);
		when(menuItemRepository.findById(Long.valueOf(2))).thenReturn(Optional.of(m1));
		menuItemServiceImpl.setMenuItemRepository(menuItemRepository);
		assertEquals(m1, menuItemServiceImpl.addMenuItem(m1));
	}

	@Test
	void addMenuItemTest2() {
		MenuItemServiceImpl menuItemServiceImpl = new MenuItemServiceImpl();

		MenuItem m1 = new MenuItem(Long.valueOf(1), "ss", "food", Long.valueOf(4), Double.valueOf(40));

		when(menuItemRepository.save(m1)).thenThrow(NullPointerException.class);
		when(menuItemRepository.findById(Long.valueOf(2))).thenReturn(Optional.of(m1));
		menuItemServiceImpl.setMenuItemRepository(menuItemRepository);
		assertNull(menuItemServiceImpl.addMenuItem(m1));
	}

	@Test
	void deleteMenuItemTest() {
		MenuItemServiceImpl menuItemServiceImpl = new MenuItemServiceImpl();

		MenuItem m1 = new MenuItem(Long.valueOf(1), "ss", "food", Long.valueOf(4), Double.valueOf(40));

		when(menuItemRepository.findById(Long.valueOf(1))).thenReturn(Optional.of(m1));
		menuItemServiceImpl.setMenuItemRepository(menuItemRepository);
		assertEquals(m1, menuItemServiceImpl.deleteMenuItem(1));
	}
}
