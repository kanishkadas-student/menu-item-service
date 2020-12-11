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

	@Autowired
	private MenuItemRepository menuItemRepository;

	@Override
	public List<MenuItem> getAllMenuItemList() {
		log.info("Start");
		List<MenuItem> menuItemList = menuItemRepository.findAll();
		log.debug("Menu Item List:{}", menuItemList);
		return menuItemList;
	}

	@Override
	@Transactional
	public List<MenuItem> getMenuItemListInStock() {
		log.info("Start");
		List<MenuItem> menuItemListInStock = menuItemRepository.getMenuItemBAsedOnStock();
		log.debug("Menu Item List In Stock:{}", menuItemListInStock);
		return menuItemListInStock;
	}

	@Override
	public MenuItem getMenuItem(long menu_id) {

		java.util.Optional<MenuItem> item = menuItemRepository.findById(menu_id);
		if (!item.isPresent()) {
			throw new MenuItemNotFoundException("Menu Item with id " + menu_id + " does not exist");
		}
		MenuItem item2 = item.get();
		return item2;
	}

	@Override
	public MenuItem modifyMenuItem(Long menuId, MenuItem menu) {

		Optional<MenuItem> optMenuItem = null;
		if (menuId != null)
			optMenuItem = menuItemRepository.findById(menuId);
		if (optMenuItem != null && optMenuItem.isPresent()) {
			MenuItem menuItem = optMenuItem.get();
			menuItem.setItemName(menu.getItemName());
			menuItem.setItemStock(menu.getItemStock());
			menuItem.setItemType(menu.getItemType());
			menuItem.setItemPrice(menu.getItemPrice());
			try {
				return menuItemRepository.save(menuItem);
			} catch (Exception e) {

			}
		}
		return null;

	}

	public MenuItem updateStock(long menu_id, int quantity) {
		try {
			MenuItem menuItem = getMenuItem(menu_id);

			menuItem.setItemStock(menuItem.getItemStock() - quantity);

			return menuItemRepository.save(menuItem);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public MenuItem addMenuItem(MenuItem menuItem) {
		try {
			return menuItemRepository.save(menuItem);
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public MenuItem deleteMenuItem(long menu_id) {
		Optional<MenuItem> op = menuItemRepository.findById(menu_id);
		if (!op.isPresent()) {
			throw new MenuItemNotFoundException("MenuItem with the Id " + menu_id + " is not exist");
		}
		menuItemRepository.deleteById(menu_id);
		return op.get();
	}

}
