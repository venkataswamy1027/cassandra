package com.restapi.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.restapi.model.Product;

public interface ProductRepository extends CrudRepository<Product, UUID> {

}
