package com.cts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.model.MenuItem;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

	@Query(value = "SELECT * FROM menuitem WHERE item_stock > 0", nativeQuery = true)
	List<MenuItem> getMenuItemBAsedOnStock();
	
}
