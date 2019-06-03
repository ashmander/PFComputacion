package com.example.demo.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Supply;
import com.example.demo.model.UrgentCare;
import com.example.demo.repository.UrgentCareRepository;

@Service
public class UrgentCareService {
	
	@Autowired
	private UrgentCareRepository urgentCareRepository;
	
	public void urgs()  {
		UrgentCare urg1 = new UrgentCare();
	}
	
	
	public UrgentCare addSupply(UrgentCare urgentCare, Supply supply) {
		if(urgentCare.getMedicamentsSupplied()!=null) {
			urgentCare.getMedicamentsSupplied().add(supply);
		} else {
			List<Supply> medicamentsSupplied = new ArrayList<Supply>();
			medicamentsSupplied.add(supply);
			urgentCare.setMedicamentsSupplied(medicamentsSupplied);
		}
		return urgentCare;
	}
	
	public List<UrgentCare> listUrgentCares() {
		return (List<UrgentCare>) urgentCareRepository.findAll();
	}
	
	public List<UrgentCare> listUrgentCaresByDate(LocalDate dateAttention) {
		List<UrgentCare> urgentsCare = (List<UrgentCare>) urgentCareRepository.findAll();
		for(int i = 0; i < urgentsCare.size(); i++) {
			if(!urgentsCare.get(i).getDateAttention().isEqual(dateAttention)) {
				urgentsCare.remove(i);
				i=0;
			}
		}
		return urgentsCare;
	}
	
	public void saveUrgentCare(UrgentCare urgentCare)  {
		urgentCareRepository.save(urgentCare);
	}
}
