package dao;

import java.util.List;

import entities.Products;

public interface ProductsDao {

	void insert(Products obj);

	void update(Products obj);

	void deleteById(Integer id);

	Products findById(Integer id);

	List<Products> findAll();

}
