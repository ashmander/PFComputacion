package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Supply;

public interface ISupply {

	public void save(Supply entity);
	public void update(Supply entity);
	public void delete(Supply entity);
	public Supply findById(Integer codigo);
	public List<Supply> findAll();
	public List<Supply> findByQuantity(int min, int max);
}
