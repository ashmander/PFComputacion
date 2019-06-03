package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Medicament;

@Repository
public interface MedicamentRepository extends CrudRepository<Medicament, Integer>{
	
	public Medicament findByConsecutive(Integer consecutive);
	
}
