package com.example.demo.services;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.MedicamentInventory;
import com.example.demo.repository.MedicamentInventoryRepository;

@Service
public class MedicamentInventoryService {

	@Autowired
	private MedicamentInventoryRepository medicamentInventoryRepository;
	
	public MedicamentInventory findById(long id) {
		return medicamentInventoryRepository.findById(id).get();
	}
	
	public void saveMedicamentInventory(MedicamentInventory medicamentInventory) {
		medicamentInventoryRepository.save(medicamentInventory);
	}
	
	public List<MedicamentInventory> listMedicamentsInventories() {
		return (List<MedicamentInventory>) medicamentInventoryRepository.findAll();
	}
	
	public List<MedicamentInventory> listMedicamentsInventoriesByDate(LocalDate expirationDate) {
		List<MedicamentInventory> inventories = (List<MedicamentInventory>) medicamentInventoryRepository.findAll();
		for(int i = 0; i < inventories.size(); i++) {
			if(expirationDate.isEqual(inventories.get(i).getExpirationDate()) || expirationDate.isAfter(inventories.get(i).getExpirationDate())) {
				inventories.remove(i);
				i=0;
			}
		}
		return inventories;
	}
	
	public void deleteInventory(long id) {
		medicamentInventoryRepository.deleteById(id);
	}
	
	public boolean verifyExpirationDate(long id) {
		boolean isExpired = false;
		if(medicamentInventoryRepository.findById(id).get().getExpirationDate().isEqual(LocalDate.now()) || medicamentInventoryRepository.findById(id).get().getExpirationDate().isAfter(LocalDate.now())) {
			isExpired = true;
		}
		return isExpired;
	}
}
