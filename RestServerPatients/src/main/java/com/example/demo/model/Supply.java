package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
public class Supply {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private Integer quantity;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate date;
	@NonNull
	private String pathology;
	private String observation;
	@ManyToOne(targetEntity=Medicament.class)
	private Medicament medicament;
	@ManyToOne(targetEntity=Patient.class)
	private Patient patient;
	
	public Supply (Integer quantity, LocalDate date, String pathology) {
		this.quantity = quantity;
		this.date = date;
		this.pathology = pathology;
	}
}
