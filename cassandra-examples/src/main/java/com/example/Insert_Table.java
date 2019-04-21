package com.example;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class Insert_Table {

	public static void main(String args[]) {

		// queries
		String query = "INSERT INTO emp (emp_id, emp_name, emp_city, emp_phone,  emp_sal)"

				+ " VALUES(1,'ram', 'Hyderabad', 9848022338, 50000);";

		// Creating Cluster object
		Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();

		// Creating Session object
		Session session = cluster.connect("test");

		// Executing the query
		session.execute(query);

		System.out.println("Data created");
	}

}
