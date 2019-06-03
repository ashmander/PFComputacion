package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Supply;

@Repository
public class SupplyImp implements ISupply{

	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager entityManager;
	
	@Override
	public void save(Supply entity) {
		// TODO Auto-generated method stub
		entityManager.persist(entity);
	}

	@Override
	public void update(Supply entity) {
		// TODO Auto-generated method stub
		entityManager.merge(entity);
	}

	@Override
	public void delete(Supply entity) {
		// TODO Auto-generated method stub
		entityManager.remove(entity);
	}

	@Override
	public Supply findById(Integer codigo) {
		// TODO Auto-generated method stub
		return entityManager.find(Supply.class,codigo);
	}

	@Override
	public List<Supply> findAll() {
		// TODO Auto-generated method stub
		String jpql = "Select a from Supply a";
		return 	entityManager.createQuery(jpql).getResultList();
	}
	
	@Override
	public List<Supply> findByQuantity(int min, int max) {
		// TODO Auto-generated method stub
		String jpql = "Select a from Supply a where a.quantity between :min  and :max";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("min", min);
		query.setParameter("max", max);
		return 	query.getResultList();
	}

}
