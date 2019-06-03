package com.example.demo.dao;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.model.Supply;
import com.example.demo.model.UrgentCare;

public interface IUrgentCare {

	public void save(UrgentCare entity);
	public void update(UrgentCare entity);
	public void delete(UrgentCare entity);
	public UrgentCare findById(Integer codigo);
	public List<UrgentCare> findAll();
	public List<UrgentCare> findByRange(LocalDate startDate, LocalDate endDate);
}
