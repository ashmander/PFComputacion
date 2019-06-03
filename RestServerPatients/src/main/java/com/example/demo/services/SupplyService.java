package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Supply;
import com.example.demo.repository.SupplyRepository;

@Service
public class SupplyService {

	@Autowired
	private SupplyRepository supplyRepository;
	
	public void saveSupply(Supply supply) {
		supplyRepository.save(supply);
	}
}
