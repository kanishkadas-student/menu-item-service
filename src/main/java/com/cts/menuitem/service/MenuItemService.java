package com.cts.menuitem.service;

import java.util.List;

import com.cts.menuitem.model.MenuItem;

//all the services provided in menu-item 
public interface MenuItemService {
	public List<MenuItem> getMenuItemListInStock();

	public MenuItem getMenuItem(long menu_id);

	public MenuItem modifyMenuItem(Long menu_id,MenuItem menuItem);

	public List<MenuItem> getAllMenuItemList();

	public MenuItem addMenuItem(MenuItem menuItem);

	public MenuItem deleteMenuItem(long menu_id);

	public MenuItem updateStock(long menu_id, int quantity);

}
