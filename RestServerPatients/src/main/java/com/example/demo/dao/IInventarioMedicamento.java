package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.MedicamentInventory;

public interface IInventarioMedicamento {

	public void save(MedicamentInventory entity);
	public void update(MedicamentInventory entity);
	public void delete(MedicamentInventory entity);
	public MedicamentInventory findById(Integer codigo);
	public List<MedicamentInventory> findAll();
	
}
