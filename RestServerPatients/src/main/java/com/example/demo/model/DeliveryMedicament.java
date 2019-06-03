package com.example.demo.model;

import lombok.Data;

@Data
public class DeliveryMedicament {
	
	private Patient patient;
	private Medicament medicament;
	private Integer quantity;
}
