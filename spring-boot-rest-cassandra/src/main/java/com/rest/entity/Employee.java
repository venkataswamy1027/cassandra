package com.rest.entity;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;

@Table("employee")
@Data
public class Employee {

	@PrimaryKey
	private long id;

	@Column
	private String name;

	@Column
	private int age;

	@Column
	private float salary;

}
