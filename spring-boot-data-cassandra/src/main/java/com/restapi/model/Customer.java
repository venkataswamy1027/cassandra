package com.restapi.model;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Table
@Data
@AllArgsConstructor
public class Customer {
	
	@PrimaryKey
	private UUID id;
	private String firstName;
	private String lastName;
	
}
