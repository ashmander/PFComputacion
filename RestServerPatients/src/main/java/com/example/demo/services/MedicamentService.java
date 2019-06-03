package com.example.demo.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Medicament;
import com.example.demo.model.MedicamentInventory;
import com.example.demo.repository.MedicamentRepository;

@Service
public class MedicamentService {

	@Autowired
	private MedicamentRepository medicamentRepository;
	
	@Autowired
	private MedicamentInventoryService medicamentInventoryService;
	
	public List<Medicament> listMedicaments() {
		return (List<Medicament>) medicamentRepository.findAll();
	}
	
	public List<Long> verifyQuantity(Medicament medicament, int quantity) {
		List<Long> invs = new ArrayList<Long>();
		boolean thereQuantity= false;
		int aux = quantity;
		List<MedicamentInventory> inventories = medicament.getInventories();
		for (int i = 0; i < inventories.size() && !thereQuantity; i++) {
			if(medicamentInventoryService.verifyExpirationDate(inventories.get(i).getId())) {
				if(inventories.get(i).getQuantityAvailable()>=aux) {
					thereQuantity = true;
					aux = 0;
					invs.add(inventories.get(i).getId());
				} else {
					aux -= inventories.get(i).getQuantityAvailable();
					invs.add(inventories.get(i).getId());
				}
			}
		}
		if(aux!=0) {
			invs.clear();
		}
		return invs;
	}
	
	public int delivery(Medicament medicament, int quantity) {
		List<Long> invs = verifyQuantity(medicament, quantity);
		int aux = quantity;
		for(int i = 0; i < invs.size(); i++) {
			if(i==invs.size()-1) {
				MedicamentInventory medicamentInventoryAux = medicamentInventoryService.findById(invs.get(i));
				medicamentInventoryAux.setQuantityAvailable(medicamentInventoryAux.getQuantityAvailable()-aux);
				medicamentInventoryService.saveMedicamentInventory(medicamentInventoryAux);
				aux = 0;
			} else {
				aux -= medicamentInventoryService.findById(invs.get(i)).getQuantityAvailable();
				MedicamentInventory medicamentInventoryAux = medicamentInventoryService.findById(invs.get(i));
				medicamentInventoryAux.setQuantityAvailable(0);
				medicamentInventoryService.saveMedicamentInventory(medicamentInventoryAux);
			}
		}
		return aux;
	}
	
	public void defaltMedicaments() {
		Medicament medicament1 = new Medicament("Ziagen","Abacavir", "Laboratorio Clinico", "Via oral", "Una pastilla diaria");
		Medicament medicament2 = new Medicament("Orencia","Abatacept", "Laboratorio Clinico", "Via oral", "Dos pastilla diaria");
		Medicament medicament3 = new Medicament("Reopro","Abciximab", "Laboratorio Clinico", "Via oral", "Una pastilla diaria");
		MedicamentInventory medicamentInventory1 = new MedicamentInventory(4, "Cali", LocalDate.of(2022, 4, 23));
		MedicamentInventory medicamentInventory2 = new MedicamentInventory(5, "Cali", LocalDate.of(2021, 4, 23));
		MedicamentInventory medicamentInventory3 = new MedicamentInventory(3, "Cali", LocalDate.of(2019, 4, 23));
		List<MedicamentInventory> medicamentInventories1 = new ArrayList<MedicamentInventory>();
		medicamentInventories1.add(medicamentInventory1);
		medicamentInventories1.add(medicamentInventory2);
		medicamentInventories1.add(medicamentInventory3);
		medicament1.setInventories(medicamentInventories1);
		MedicamentInventory medicamentInventory4 = new MedicamentInventory(6, "Cali", LocalDate.of(2018, 4, 23));
		MedicamentInventory medicamentInventory5 = new MedicamentInventory(2, "Cali", LocalDate.of(2020, 4, 23));
		MedicamentInventory medicamentInventory6 = new MedicamentInventory(1, "Cali", LocalDate.of(2019, 4, 23));	
		List<MedicamentInventory> medicamentInventories2 = new ArrayList<MedicamentInventory>();
		medicamentInventories2.add(medicamentInventory4);
		medicamentInventories2.add(medicamentInventory5);
		medicamentInventories2.add(medicamentInventory6);
		medicament2.setInventories(medicamentInventories2);
		MedicamentInventory medicamentInventory7 = new MedicamentInventory(5, "Cali", LocalDate.of(2018, 4, 23));
		MedicamentInventory medicamentInventory8 = new MedicamentInventory(7, "Cali", LocalDate.of(2021, 4, 23));
		MedicamentInventory medicamentInventory9 = new MedicamentInventory(4, "Cali", LocalDate.of(2019, 4, 15));
		List<MedicamentInventory> medicamentInventories3 = new ArrayList<MedicamentInventory>();
		medicamentInventories3.add(medicamentInventory7);
		medicamentInventories3.add(medicamentInventory8);
		medicamentInventories3.add(medicamentInventory9);
		medicament3.setInventories(medicamentInventories3);
		medicamentInventoryService.saveMedicamentInventory(medicamentInventory1);
		medicamentInventoryService.saveMedicamentInventory(medicamentInventory4);
		medicamentInventoryService.saveMedicamentInventory(medicamentInventory7);
		medicamentInventoryService.saveMedicamentInventory(medicamentInventory2);
		medicamentInventoryService.saveMedicamentInventory(medicamentInventory5);
		medicamentInventoryService.saveMedicamentInventory(medicamentInventory8);
		medicamentInventoryService.saveMedicamentInventory(medicamentInventory3);
		medicamentInventoryService.saveMedicamentInventory(medicamentInventory6);		
		medicamentInventoryService.saveMedicamentInventory(medicamentInventory9);
		medicamentRepository.save(medicament1);
		medicamentRepository.save(medicament2);
		medicamentRepository.save(medicament3);
		List<Medicament> medicaments = (List<Medicament>) medicamentRepository.findAll();
		List<MedicamentInventory> inventories = medicamentInventoryService.listMedicamentsInventories();
		for(int i = 0; i < inventories.size(); i++) {
			inventories.get(i).setMedicament(medicaments.get(i%3));
			medicamentInventoryService.saveMedicamentInventory(inventories.get(i));
		}
	}
	
}
