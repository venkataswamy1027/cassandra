package com.example;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class Update_Data {

	public static void main(String args[]){
	      
	      //query
	      String query = " UPDATE emp SET emp_city='Delhi' where emp_id=1";
	          
	      //Creating Cluster object
	      Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
	         
	      //Creating Session object
	      Session session = cluster.connect("test");
	         
	      //Executing the query
	      session.execute(query);

	      System.out.println("Data updated");
	   }
}
