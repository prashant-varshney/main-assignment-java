package com.hashkart.inventory.service.model;

import java.util.Optional;

public enum Category {
	GROCERY, TOYS, CLOTHING, GADGETS, FOOTWEAR, BEAUTY, APPLIANCES, SPORTS;

	public static Optional<Category> get(String categoryValue) {
		for (Category category : Category.values()) {
			if (categoryValue.equalsIgnoreCase(category.toString())) {
				return Optional.of(category);
			}
		}
		return Optional.empty();

	}
}