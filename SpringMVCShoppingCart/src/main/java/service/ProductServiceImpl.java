package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.ProductDAO;
import entity.Products;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	public List<Products> listProduct() {
		return productDAO.listProduct();
	}

	public List<Products> findByName(String name) {
		return productDAO.findByName(name);
	}

	public void editProduct(Products products) {
		productDAO.editProduct(products);
	}

	public Products findById(String id) {
		return productDAO.findById(id);
	}

}
