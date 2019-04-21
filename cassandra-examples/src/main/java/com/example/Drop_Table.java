package com.example;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class Drop_Table {

	public static void main(String args[]) {

		// Query
		String query = "DROP TABLE emp;";
		Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();

		// Creating Session object
		Session session = cluster.connect("test");

		// Executing the query
		session.execute(query);

		System.out.println("Table dropped");
	}
}
