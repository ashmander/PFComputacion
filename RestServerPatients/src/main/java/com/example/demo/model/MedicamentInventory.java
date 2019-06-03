package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MedicamentInventory {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NonNull
	private Integer quantityAvailable;
	@NonNull
	private String loaction;
	@NonNull
	private LocalDate expirationDate;
	@ManyToOne(targetEntity=Medicament.class, cascade = {CascadeType.MERGE})
	private Medicament medicament;
	
	
	public MedicamentInventory (Integer quantityAvailable, String location, LocalDate expirationDate) {
		this.quantityAvailable = quantityAvailable;
		this.loaction = location;
		this.expirationDate = expirationDate;
	}
}
