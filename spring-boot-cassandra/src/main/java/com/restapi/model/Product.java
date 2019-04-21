package com.restapi.model;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.datastax.driver.core.DataType;

@Table("products")
public class Product {
	
	@PrimaryKey
	@CassandraType(type = DataType.Name.UUID)
	private UUID id;
	private String description;
	private double price;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Product() {
		id = UUID.randomUUID();
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", description=" + description + ", price=" + price + "]";
	}

}
