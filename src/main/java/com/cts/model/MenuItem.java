package com.cts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "menuitem")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MenuItem {

	public MenuItem(String itemName, String itemType, Long itemStock, Double itemPrice) {
		super();
		this.itemName = itemName;
		this.itemType = itemType;
		this.itemStock = itemStock;
		this.itemPrice = itemPrice;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="item_id")
	private Long itemId;

	@Column(name="item_name")
	private String itemName;

	@Column(name="item_type")
	private String itemType;

	@Column(name="item_stock")
	private Long itemStock;

	@Column(name="item_price")
	private Double itemPrice;

}
