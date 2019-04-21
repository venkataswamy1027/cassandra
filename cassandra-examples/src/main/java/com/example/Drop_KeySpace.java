package com.example;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class Drop_KeySpace {

	public static void main(String args[]) {

		// Query
		String query = "Drop KEYSPACE javatpoint";

		// creating Cluster object
		Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();

		// Creating Session object
		Session session = cluster.connect();

		// Executing the query
		session.execute(query);
		System.out.println("Keyspace deleted");
	}
}
