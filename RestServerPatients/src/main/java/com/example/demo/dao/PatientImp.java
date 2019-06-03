package com.example.demo.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Patient;

@Repository
public class PatientImp implements IPatient{

	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	@Override
	public void save(Patient entity) {
		// TODO Auto-generated method stub
		entityManager.persist(entity);
	}

	@Override
	public void update(Patient entity) {
		// TODO Auto-generated method stub
		entityManager.merge(entity);
	}

	@Override
	public void delete(Patient entity) {
		// TODO Auto-generated method stub
		entityManager.remove(entity);
	}

	@Override
	public Patient findById(Long id) {
		// TODO Auto-generated method stub
		return entityManager.find(Patient.class, id);
	}

	@Override
	public List<Patient> findAll() {
		// TODO Auto-generated method stub
		String jpql = "Select a from Patient a order by a.id asc";
		return 	entityManager.createQuery(jpql).getResultList();
	}
	
	@Override
	public List<Patient> findByName(String name) {
		String jpql = "Select a from Patient a where a.name = '"+name+"'";
		return 	entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public List<Patient> findByLastName(String lastName) {
		// TODO Auto-generated method stub
		String jpql = "Select a from Patient a where a.lastName = '"+lastName+"'";
		return 	entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public List<Patient> findByLastMonth() {
		// TODO Auto-generated method stub
		LocalDate today =  LocalDate.now();
		LocalDate lastMonth = today.minusMonths(1);
		String jpql = "Select a.patientAttended from UrgentCare a where a.dateAttention between :lastMonth and :today group by a.patientAttended having count(a)>2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("today", today);
		query.setParameter("lastMonth", lastMonth);
		return 	entityManager.createQuery(jpql).getResultList();
	}

}
