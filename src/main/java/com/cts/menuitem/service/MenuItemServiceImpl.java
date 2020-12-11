package com.cts.menuitem.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class MenuItemServiceImpl implements MenuItemService{

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
		log.info("Start");
		java.util.Optional<MenuItem> item=menuItemRepository.findById(menu_id);
		if(!item.isPresent()) {
			throw new MenuItemNotFoundException("Menu Item with id "+ menu_id+" does not exist");
		}
		MenuItem item2=item.get();
		return item2;
	}

	@Override
	public String modifyMenuItem(MenuItem menuItem) {
		log.info("Start");
		long menu_id=menuItem.getItemId();
		getMenuItem(menu_id);
		menuItemRepository.save(menuItem);
		return "Menu Item Updated Successfully";

	}
	
	public boolean updateStock(long menu_id, int quantity) {
		MenuItem menuItem = getMenuItem(menu_id);
		
		menuItem.setItemStock(menuItem.getItemStock()- quantity);
		menuItemRepository.save(menuItem);
		
		return true;
	}

	
	@Override
	public String addMenuItem(MenuItem menuItem) {
		Optional<MenuItem> op=menuItemRepository.findById(menuItem.getItemId());
		if(op.isPresent()) {
			throw new MenuItemNotFoundException("MenuItem with the Id "+menuItem.getItemId()+" already exist");
		}
		menuItemRepository.save(menuItem);
		return "Menu Item Added Successfully";
	}

	@Override
	public String deleteMenuItem(long menu_id) {
		Optional<MenuItem> op=menuItemRepository.findById(menu_id);
		if(!op.isPresent()) {
			throw new MenuItemNotFoundException("MenuItem with the Id "+menu_id+" is not exist");
		}
		menuItemRepository.deleteById(menu_id);
		return "Menu Item Deleted Successfully";
	}
	
	

}
