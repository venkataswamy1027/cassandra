package com.restapi.repository;

import org.springframework.data.cassandra.core.mapping.MapId;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.restapi.model.Employee;

@Repository
public interface EmployeeRepository extends CassandraRepository<Employee, MapId> {

}
