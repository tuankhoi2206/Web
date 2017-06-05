package dao;

import java.util.List;

import entity.Products;

public interface ProductDAO {

	List<Products> listProduct();

	List<Products> findByName(String name);

	Products findById(String id);

	void editProduct(Products products);

}
