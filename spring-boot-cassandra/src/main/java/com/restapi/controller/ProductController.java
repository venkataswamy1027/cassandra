package com.restapi.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.restapi.converters.ProductToProductForm;
import com.restapi.mode.form.ProductForm;
import com.restapi.model.Product;
import com.restapi.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductToProductForm productToProductForm;

	@RequestMapping("/")
	public String redirToList() {
		System.out.println("redirToList method executed.");
		return "redirect:/product/list";
	}

	@RequestMapping({ "/product/list", "/product" })
	public String listProducts(Model model) {
		System.out.println("listProducts method executed.");
		model.addAttribute("products", productService.listAll());
		return "product/list";
	}

	@RequestMapping("/product/show/{id}")
	public String getProduct(@PathVariable String id, Model model) {
		System.out.println("getProduct method executed.");
		model.addAttribute("product", productService.getById(UUID.fromString(id)));
		return "product/show";
	}

	@RequestMapping("product/edit/{id}")
	public String edit(@PathVariable String id, Model model) {
		System.out.println("edit method executed.");
		Product product = productService.getById(UUID.fromString(id));
		ProductForm productForm = productToProductForm.convert(product);
		model.addAttribute("productForm", productForm);
		return "product/productform";
	}

	@RequestMapping("/product/new")
	public String newProduct(Model model) {
		System.out.println("newProduct method executed.");
		model.addAttribute("productForm", new ProductForm());
		return "product/productform";
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public String saveOrUpdateProduct(@Valid ProductForm productForm, BindingResult bindingResult) {
		System.out.println("saveOrUpdateProduct method executed.");

		if (bindingResult.hasErrors()) {
			return "product/productform";
		}
		Product savedProduct = productService.saveOrUpdateProductForm(productForm);
		return "redirect:/product/show/" + savedProduct.getId();
	}

	@RequestMapping("/product/delete/{id}")
	public String delete(@PathVariable String id) {
		System.out.println("delete method executed.");
		productService.delete(UUID.fromString(id));
		return "redirect:/product/list";
	}

}
