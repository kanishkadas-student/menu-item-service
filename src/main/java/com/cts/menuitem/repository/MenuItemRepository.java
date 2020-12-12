package com.cts.menuitem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.menuitem.model.MenuItem;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

	@Query(value = "SELECT * FROM menuitem WHERE item_stock > 0", nativeQuery = true)
	List<MenuItem> getMenuItemBAsedOnStock(); // query for getting list of items in stock
	
}
