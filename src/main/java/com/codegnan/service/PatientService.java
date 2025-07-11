package com.codegnan.service;

import java.util.List;
import java.util.Optional;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codegnan.entity.Doctor;
import com.codegnan.entity.Patient;
import com.codegnan.exception.InvalidDateFormatException;
import com.codegnan.exception.InvalidDoctorIdException;
import com.codegnan.exception.InvalidPatientIdException;

import com.codegnan.repo.PatientRepo;
@Service
public class PatientService {
	private PatientRepo patientRepo;
	
	//@Autowired
	public PatientService(PatientRepo patientRepo) {
		super();
		this.patientRepo=patientRepo;
		
	}
	public Patient savePatient(Patient patient) {
		return patientRepo.save(patient);
	}
	
	//FINDBYID
	public Patient findPatientById(int id) throws InvalidPatientIdException{
		Optional<Patient> optPatient=patientRepo.findById(id);
		if(optPatient.isEmpty()) {
			throw new InvalidPatientIdException("Patient id: "+id+ " not found");
			
		}
		return optPatient.get();
		
	}
	
	//FINDALL
	public List<Patient> findAllPatients(){
		return patientRepo.findAll();
		}
	
	//UPDATE
	public Patient updatePatient(Patient patient) throws InvalidPatientIdException {
		findPatientById(patient.getId());
		return patientRepo.save(patient);
	}
//	public Patient editPatient(int id,Patient patientDetails) throws InvalidPatientIdException, InvalidDateFormatException{
//		Optional<Patient> optionalPatient=patientRepo.findById(id);
//		if(!optionalPatient.isPresent()) {
//			throw new InvalidPatientIdException("Patient id: "+id+" not found");
//		}
//		Patient existingPatient=optionalPatient.get();
//		existingPatient.setName(patientDetails.getName());
//		existingPatient.setEmail(patientDetails.getEmail());
//		existingPatient.setMobile(patientDetails.getMobile());
//		existingPatient.setGender(patientDetails.getGender());
//		existingPatient.setRegDate(patientDetails.getRegDate());
//		existingPatient.setAge(patientDetails.getAge());
//		
//		
//		return patientRepo.save(existingPatient);
//		
//	}
	
	//DELETE
	public Patient deletePatient(int id) throws InvalidPatientIdException {
		Patient patient = findPatientById(id); 
		patientRepo.deleteById(id);
		return patient;
	}
//	public void deletePatient(int id) throws InvalidPatientIdException{
//		Optional<Patient> optionalPatient=patientRepo.findById(id);
//		if(!optionalPatient.isPresent()) {
//			throw new InvalidPatientIdException("Patient id not found: "+id);
//		}
//		patientRepo.deleteById(id);
//	}
	
	

}
