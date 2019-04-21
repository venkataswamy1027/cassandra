package com.restapi.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;

@Table
@Data
public class Employee {

	@PrimaryKey
	private int id;

	private String firstName;

	private String lastName;

	private String department;

}
