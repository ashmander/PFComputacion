package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.stereotype.Repository;

import com.example.demo.model.MedicamentInventory;

@Repository
public class InventoryMedicamentImp implements IInventarioMedicamento{

	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager entityManager;
	
	@Override
	public void save(MedicamentInventory entity) {
		// TODO Auto-generated method stub
		entityManager.persist(entity);
	}

	@Override
	public void update(MedicamentInventory entity) {
		// TODO Auto-generated method stub
		entityManager.merge(entity);
	}

	@Override
	public void delete(MedicamentInventory entity) {
		// TODO Auto-generated method stub
		entityManager.remove(entity);
	}

	@Override
	public MedicamentInventory findById(Integer codigo) {
		// TODO Auto-generated method stub
		return entityManager.find(MedicamentInventory.class, codigo);
	}

	@Override
	public List<MedicamentInventory> findAll() {
		// TODO Auto-generated method stub
		String jpql = "Select a from MedicamentInventory a";
		return 	entityManager.createQuery(jpql).getResultList();
	}

}
