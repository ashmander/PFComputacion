package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Medicament;

public interface IMedicamento {

	public void save(Medicament entity);
	public void update(Medicament entity);
	public void delete(Medicament entity);
	public Medicament findById(Integer codigo);
	public List<Medicament> findAll();
	public List<Medicament> findByInventoryQuantity();
}
