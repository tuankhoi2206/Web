package service;

import java.util.List;

import entity.Products;

public interface ProductService {

	List<Products> listProduct();

	List<Products> findByName(String name);

	Products findById(String id);

	void editProduct(Products products);

}
