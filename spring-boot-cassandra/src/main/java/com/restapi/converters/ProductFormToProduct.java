package com.restapi.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.restapi.mode.form.ProductForm;
import com.restapi.model.Product;

@Component
public class ProductFormToProduct implements Converter<ProductForm, Product> {

	@Override
	public Product convert(ProductForm productForm) {
		Product product = new Product();
		if (productForm.getId() != null && !StringUtils.isEmpty(productForm.getId())) {
			product.setId(productForm.getId());
		}
		product.setDescription(productForm.getDescription());
		product.setPrice(productForm.getPrice());
		return product;
	}

}
