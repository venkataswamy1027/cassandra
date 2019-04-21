package com.restapi.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.restapi.mode.form.ProductForm;
import com.restapi.model.Product;

@Component
public class ProductToProductForm implements Converter<Product, ProductForm> {
	@Override
	public ProductForm convert(Product product) {
		ProductForm productForm = new ProductForm();
		productForm.setId(product.getId());
		productForm.setDescription(product.getDescription());
		productForm.setPrice(product.getPrice());
		return productForm;
	}
}
