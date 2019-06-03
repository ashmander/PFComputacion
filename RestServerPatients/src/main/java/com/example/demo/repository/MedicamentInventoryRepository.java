package com.example.demo.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.MedicamentInventory;

@Repository
public interface MedicamentInventoryRepository extends CrudRepository<MedicamentInventory, Long>{

	
}
