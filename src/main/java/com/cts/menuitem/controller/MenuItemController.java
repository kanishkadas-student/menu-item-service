package com.cts.menuitem.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cts.menuitem.service.MenuItemService;
import com.cts.model.MenuItem;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
//@RequestMapping("/menuitems")

public class MenuItemController {

	@Autowired
	MenuItemService menuItemService;

	@GetMapping("/getAllMenuItems")
	public List<MenuItem> getAllMenuItemList() {
		log.info("Start");
		log.info("End");
		return menuItemService.getAllMenuItemList();
	}

	@GetMapping("/getMenuItemInStock")
	public List<MenuItem> getMenuItemListInStock() {
		log.info("Start");
		log.info("End");
		return menuItemService.getMenuItemListInStock();
	}

	@PostMapping("/")
	@ResponseStatus(code = HttpStatus.CREATED)
	public String addMenuItem(@RequestBody MenuItem menuItem) {
		log.info("Start");
		log.info("End");
		return menuItemService.addMenuItem(menuItem);
	}

	@DeleteMapping("/{menu_id}")
	public String deleteMenuItem(@PathVariable int menu_id) {
		log.info("Start");
		log.info("End");
		return menuItemService.deleteMenuItem(menu_id);
	}

	@GetMapping("/{menu_id}")
	public ResponseEntity<MenuItem> getMenuItem(@PathVariable int menu_id) {
		log.info("Start");
		log.info("End");
		return new ResponseEntity<MenuItem>(menuItemService.getMenuItem(menu_id), HttpStatus.OK);
	}

	@PutMapping("/")
	public String modifyMenuItem(@RequestBody MenuItem menuItem) {
		log.info("Start");
		log.info("End");
		return menuItemService.modifyMenuItem(menuItem);

	}

	@PutMapping("/update/{menu_id}")
	public boolean updateStock(@PathVariable Long menu_id, @RequestBody Integer quantity) {
		log.info("Start");
		log.info("End");
		return menuItemService.updateStock(menu_id, quantity);

	}

}
