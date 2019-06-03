package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
public class UrgentCare {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer consecutive;
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dateAttention;
	@NotNull
	@DateTimeFormat(pattern="HH:mm")
	private LocalTime timeAttention;
	@NotBlank
	private String generalDescription;
	@NotBlank
	private String procedure;
	@NotBlank
	private String isDispatched;
	private String remissionPlace;
	@NotBlank
	private String observations;
	
	@ManyToOne(targetEntity=Patient.class)
	private Patient patientAttended;
	@OneToMany(targetEntity=Supply.class)
	private List<Supply> medicamentsSupplied;
}
