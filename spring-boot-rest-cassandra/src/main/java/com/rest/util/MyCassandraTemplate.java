package com.rest.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Component;

@Component
public class MyCassandraTemplate {

	@Autowired
	private CassandraOperations cassandraOperations;

	public MyCassandraTemplate() {
		System.out.println("MyCassandraTemplate()");
	}

	public void create(Object entity) {
		cassandraOperations.insert(entity);
	}

	public void update(Object entity) {
		cassandraOperations.update(entity);
	}

	public <T> T findById(Object id, Class<T> claz) {
		return cassandraOperations.selectOneById(id, claz);
	}

	public <T> void deleteById(Object id, Class<T> claz) {
		cassandraOperations.deleteById(id, claz);
	}

	public <T> List<T> findAll(Class<T> claz) {
		return (List<T>) cassandraOperations.select("select * from employee", claz);
	}
}
