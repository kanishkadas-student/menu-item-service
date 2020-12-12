package com.cts.menuitem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "menuitem")
@NoArgsConstructor
@AllArgsConstructor
public class MenuItem {

	
	// parameters generated
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="item_id")
	private Long itemId;
	
	@Size(max = 20, message = "${itemName.msg}")// size validation applied
	@NotNull // not null validation applied
	@Column(name="item_name")
	private String itemName;

	@NotNull// not null validation applied
	@Column(name="item_type")
	private String itemType;
	
	@NotNull// not null validation applied
	@Column(name="item_stock")
	private Long itemStock;
	
	@NotNull// not null validation applied
	@Min(value = 1, message = "${itemPrice.msg}")
	@Max(999)
	@Column(name="item_price")
	private Double itemPrice;

}
