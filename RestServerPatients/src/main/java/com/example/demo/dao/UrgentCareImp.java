package com.example.demo.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Supply;
import com.example.demo.model.UrgentCare;

@Repository
public class UrgentCareImp implements IUrgentCare{

	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager entityManager;
	
	@Override
	public void save(UrgentCare entity) {
		// TODO Auto-generated method stub
		entityManager.persist(entity);
	}

	@Override
	public void update(UrgentCare entity) {
		// TODO Auto-generated method stub
		entityManager.merge(entity);
	}

	@Override
	public void delete(UrgentCare entity) {
		// TODO Auto-generated method stub
		entityManager.remove(entity);
	}

	@Override
	public UrgentCare findById(Integer codigo) {
		// TODO Auto-generated method stub
		return entityManager.find(UrgentCare.class, codigo);
	}

	@Override
	public List<UrgentCare> findAll() {
		// TODO Auto-generated method stub
		String jpql = "Select a from UrgentCare a";
		return 	entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public List<UrgentCare> findByRange(LocalDate startDate, LocalDate endDate) {
		// TODO Auto-generated method stub
		String jpql = "Select a from UrgentCare a where a.dateAttention between :startDate  and :endDate";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("startDate", startDate);
		query.setParameter("endDate", endDate);
		return 	query.getResultList();
	}

	
	
	
}
