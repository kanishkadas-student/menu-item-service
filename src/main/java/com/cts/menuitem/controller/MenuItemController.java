package com.cts.menuitem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.menuitem.model.MenuItem;
import com.cts.menuitem.service.AuthService;
import com.cts.menuitem.service.MenuItemService;

import lombok.Setter;

@RestController
@Setter
public class MenuItemController {

	@Autowired
	MenuItemService menuItemService;
	@Autowired
	AuthService authService;

	@GetMapping("/getAllMenuItems")
	public ResponseEntity<List<MenuItem>> getAllMenuItemList(@RequestHeader("Authorization") String token) {
		if (authService.checkValidation(token))
			return new ResponseEntity<List<MenuItem>>(menuItemService.getAllMenuItemList(), HttpStatus.OK);
		else
			return new ResponseEntity<List<MenuItem>>(new ArrayList<MenuItem>(), HttpStatus.UNAUTHORIZED);

	}

	@GetMapping("/getMenuItemInStock")
	public ResponseEntity<List<MenuItem>> getMenuItemListInStock(@RequestHeader("Authorization") String token) {
		if (authService.checkValidation(token))
			return new ResponseEntity<List<MenuItem>>(menuItemService.getMenuItemListInStock(), HttpStatus.OK);
		else
			return new ResponseEntity<List<MenuItem>>(new ArrayList<MenuItem>(), HttpStatus.UNAUTHORIZED);

	}

	@GetMapping("/{menu_id}")
	public ResponseEntity<MenuItem> getMenuItem(@RequestHeader("Authorization") String token,
			@PathVariable long menu_id) {
		if (authService.checkValidation(token))
			return new ResponseEntity<MenuItem>(menuItemService.getMenuItem(menu_id), HttpStatus.OK);
		else
			return new ResponseEntity<MenuItem>(new MenuItem(), HttpStatus.UNAUTHORIZED);

	}

	@PostMapping("/add")
	public ResponseEntity<MenuItem> addMenuItem(@RequestHeader("Authorization") String token,
			@RequestBody MenuItem menuItem) {

		if (authService.checkValidation(token))
			return new ResponseEntity<MenuItem>(menuItemService.addMenuItem(menuItem), HttpStatus.CREATED);
		else
			return new ResponseEntity<MenuItem>(new MenuItem(), HttpStatus.UNAUTHORIZED);

	}

	@DeleteMapping("/{menu_id}")
	public ResponseEntity<MenuItem> deleteMenuItem(@RequestHeader("Authorization") String token,
			@PathVariable long menu_id) {
		if (authService.checkValidation(token))
			return new ResponseEntity<MenuItem>(menuItemService.deleteMenuItem(menu_id), HttpStatus.OK);
		else
			return new ResponseEntity<MenuItem>(new MenuItem(), HttpStatus.UNAUTHORIZED);

	}

	@PutMapping("/{menu_id}")
	public ResponseEntity<MenuItem> modifyMenuItem(@RequestHeader("Authorization") String token,
			@PathVariable Long menu_id, @RequestBody MenuItem menuItem) {
		if (authService.checkValidation(token))
			return new ResponseEntity<MenuItem>(menuItemService.modifyMenuItem(menu_id, menuItem), HttpStatus.OK);
		else
			return new ResponseEntity<MenuItem>(new MenuItem(), HttpStatus.UNAUTHORIZED);

	}

	@PutMapping("/update/{menu_id}")
	public ResponseEntity<MenuItem> updateStock(@RequestHeader("Authorization") String token,
			@PathVariable long menu_id, @RequestBody int quantity) {

		if (authService.checkValidation(token))
			return new ResponseEntity<MenuItem>(menuItemService.updateStock(menu_id, quantity), HttpStatus.OK);
		else
			return new ResponseEntity<MenuItem>(new MenuItem(), HttpStatus.UNAUTHORIZED);

	}

}
