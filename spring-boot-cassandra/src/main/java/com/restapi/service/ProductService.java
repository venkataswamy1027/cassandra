package com.restapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.converters.ProductFormToProduct;
import com.restapi.mode.form.ProductForm;
import com.restapi.model.Product;
import com.restapi.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductFormToProduct productFormToProduct;

	public List<Product> listAll() {
		List<Product> products = new ArrayList<>();
		productRepository.findAll().forEach(products::add);
		return products;
	}

	public Product getById(UUID id) {
		return productRepository.findById(id).orElse(null);
	}

	public Product saveOrUpdate(Product product) {
		productRepository.save(product);
		return product;
	}

	public void delete(UUID id) {
		productRepository.deleteById(id);
	}

	public Product saveOrUpdateProductForm(ProductForm productForm) {
		Product savedProduct = saveOrUpdate(productFormToProduct.convert(productForm));
		System.out.println("Saved Product Id: " + savedProduct.getId());
		return savedProduct;
	}

}
