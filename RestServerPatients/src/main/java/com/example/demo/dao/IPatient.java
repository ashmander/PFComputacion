package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Patient;

public interface IPatient {

	public void save(Patient entity);
	public void update(Patient entity);
	public void delete(Patient entity);
	public Patient findById(Long id);
	public List<Patient> findAll();
	public List<Patient> findByName(String name);
	public List<Patient> findByLastName(String lastName);
	public List<Patient> findByLastMonth();
}
