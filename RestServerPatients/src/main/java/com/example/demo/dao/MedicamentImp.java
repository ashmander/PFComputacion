package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Medicament;

@Repository
public class MedicamentImp implements IMedicamento{

	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager entityManager;
	
	@Override
	public void save(Medicament entity) {
		// TODO Auto-generated method stub
		entityManager.persist(entity);
	}

	@Override
	public void update(Medicament entity) {
		// TODO Auto-generated method stub
		entityManager.merge(entity);
	}

	@Override
	public void delete(Medicament entity) {
		// TODO Auto-generated method stub
		entityManager.remove(entity);
	}

	@Override
	public Medicament findById(Integer codigo) {
		// TODO Auto-generated method stub
		return entityManager.find(Medicament.class, codigo);
	}

	@Override
	public List<Medicament> findAll() {
		// TODO Auto-generated method stub
		String jpql = "Select a from Medicament a";
		return 	entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public List<Medicament> findByInventoryQuantity() {
		// TODO Auto-generated method stub
		String jpql = "Select a from Medicament a, MedicamentInventory b where b.quantityAvailable < 10 and a.consecutive =  b.medicament.consecutive";
		return 	entityManager.createQuery(jpql).getResultList();
	}

}
