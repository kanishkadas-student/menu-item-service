package com.cts.menuitem.service;

import java.util.List;

import com.cts.model.MenuItem;


public interface MenuItemService {
	public List<MenuItem> getMenuItemListInStock();

	public MenuItem getMenuItem(long menu_id);

	public String modifyMenuItem(MenuItem menuItem);

	public List<MenuItem> getAllMenuItemList();

	public String addMenuItem(MenuItem menuItem);

	public String deleteMenuItem(long menu_id);
	
	public boolean updateStock(long menu_id, int quantity);

}
