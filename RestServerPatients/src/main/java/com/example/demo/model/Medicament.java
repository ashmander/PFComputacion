package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Medicament {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer consecutive;
	@NonNull
	private String name;
	@NonNull
	private String genericName;
	@NonNull
	private String laboratory;
	@NonNull
	private String administrationType;
	@NonNull
	private String indications;
	private String contraindications;
	@OneToMany(targetEntity=MedicamentInventory.class)
	private List<MedicamentInventory> inventories;
	@OneToMany(targetEntity=Supply.class)
	private List<Supply> supplies;
	
	public Medicament (String name, String genericName, String laboratory, String administrationType, String indications) {
		this.name = name;
		this.genericName = genericName;
		this.laboratory = laboratory;
		this.administrationType = administrationType;
		this.indications = indications;
	}
	
}
