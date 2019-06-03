package com.example.demo.services;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IPatient;
import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private IPatient ipatient;
	
	public List<Patient> listPatients(String state) {
		return patientRepository.findByState(state);
	}
	
	@PostConstruct
	@Transactional
	public void defaultPatients() {
		Patient patient1 = new Patient("Andres", "Gonzalez", "Activo");
		Patient patient2 = new Patient("Andres", "Diaz", "Activo");
		Patient patient3 = new Patient("Maria", "Cuaran", "Activo");
		Patient patient4 = new Patient("Luisa", "Granada", "Activo");
		Patient patient5 = new Patient("Jhon", "Diaz", "Activo");
		patientRepository.save(patient1);
		patientRepository.save(patient2);
		patientRepository.save(patient3);
		patientRepository.save(patient4);
		patientRepository.save(patient5);
	}
}
