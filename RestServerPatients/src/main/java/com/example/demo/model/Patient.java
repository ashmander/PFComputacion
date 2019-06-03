package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
public class Patient {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NonNull
	private String name;
	@NonNull
	private String lastName;
	private String academicDependence;
	private String academicProgram;
	@NonNull
	private String state;
	@OneToMany(targetEntity=Supply.class)
	private List<Supply> supplies;
	@OneToMany(targetEntity=UrgentCare.class)
	private List<UrgentCare> attentions;
	
	public Patient(String name, String lastName, String state) {
		this.name = name;
		this.lastName = lastName;
		this.state = state;
	}
}
