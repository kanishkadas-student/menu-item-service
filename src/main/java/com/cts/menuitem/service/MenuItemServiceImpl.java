package com.cts.menuitem.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.menuitem.exception.MenuItemNotFoundException;
import com.cts.menuitem.model.MenuItem;
import com.cts.menuitem.repository.MenuItemRepository;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Setter
public class MenuItemServiceImpl implements MenuItemService {
	//implementing services 
	@Autowired
	private MenuItemRepository menuItemRepository;
	//getting list of all items implemented
	@Override
	public List<MenuItem> getAllMenuItemList() {
		log.info("Start");
		List<MenuItem> menuItemList = menuItemRepository.findAll();
		log.debug("Menu Item List:{}", menuItemList);
		return menuItemList;
	}
	//getting list of all menu items in stocks implemented
	@Override
	@Transactional
	public List<MenuItem> getMenuItemListInStock() {
		log.info("Start");
		List<MenuItem> menuItemListInStock = menuItemRepository.getMenuItemBAsedOnStock();
		log.debug("Menu Item List In Stock:{}", menuItemListInStock);
		return menuItemListInStock;
	}
	//getting menu item with specifc ID implemented
	@Override
	public MenuItem getMenuItem(long menu_id) {
		log.info("Start");
		java.util.Optional<MenuItem> item = menuItemRepository.findById(menu_id);
		if (!item.isPresent()) {
			//exception if menu item with specific ID not found
			throw new MenuItemNotFoundException("Menu Item with id " + menu_id + " does not exist");
		}
		MenuItem item2 = item.get();
		log.debug("Menu Item:{}", item2);
		return item2;
	}
	//modifying menu item with specific menu ID implemented
	@Override
	public MenuItem modifyMenuItem(Long menuId, MenuItem menu) {
		log.info("Start");
		Optional<MenuItem> optMenuItem = null;
		if (menuId != null)
			optMenuItem = menuItemRepository.findById(menuId);
		//condition if menu item is not null
		if (optMenuItem != null && optMenuItem.isPresent()) {
			MenuItem menuItem = optMenuItem.get();
			menuItem.setItemName(menu.getItemName());
			menuItem.setItemStock(menu.getItemStock());
			menuItem.setItemType(menu.getItemType());
			menuItem.setItemPrice(menu.getItemPrice());
			//exception if menu item is null
			try {
				return menuItemRepository.save(menuItem);
			} catch (Exception e) {

			}
		}
		
		return null;

	}
	//updating the menu item list with specific menu ID
	public MenuItem updateStock(long menu_id, int quantity) {
		log.info("Start");
		try {
			MenuItem menuItem = getMenuItem(menu_id);

			menuItem.setItemStock(menuItem.getItemStock() - quantity);

			return menuItemRepository.save(menuItem);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	//adding menu item to the list implemented
	@Override
	public MenuItem addMenuItem(MenuItem menuItem) {
		log.info("Start");
		try {
			return menuItemRepository.save(menuItem);
		} catch (Exception e) {
		}
		return null;
	}
	//deleting menu item implemented
	@Override
	public MenuItem deleteMenuItem(long menu_id) {
		log.info("Start");
		Optional<MenuItem> op = menuItemRepository.findById(menu_id);
		if (!op.isPresent()) {
			throw new MenuItemNotFoundException("MenuItem with the Id " + menu_id + " is not exist");
		}
		menuItemRepository.deleteById(menu_id);
		return op.get();
	}

}
