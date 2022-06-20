package com.hashkart.inventory.service.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Product {

	@Id
	@GeneratedValue
	private Integer id;

	private String name;
	private Double price;
	private Category category;
	private Integer quantity;
	private Double userRating;

}
