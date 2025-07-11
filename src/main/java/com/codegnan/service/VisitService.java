package com.codegnan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codegnan.entity.Doctor;
import com.codegnan.entity.Patient;
import com.codegnan.entity.Visit;
import com.codegnan.exception.InvalidVisitIdException;
import com.codegnan.repo.VisitRepo;

@Service
public class VisitService {
	private VisitRepo visitRepo;

	public VisitService(VisitRepo visitRepo) {
		super();
		this.visitRepo = visitRepo;
	}
	
	public Visit saveVisit(Visit visit) {
		return visitRepo.save(visit);
	}
	
	public List<Visit> findVisitsByPatient(Patient patient){
		return visitRepo.findAllByPatient(patient);
	}
	
	public List<Visit> findVisitsByDoctor(Doctor doctor){
		return visitRepo.findAllByDoctor(doctor);
	}
	
	public List<Visit> findVisits(){
		return visitRepo.findAll();
	}
	
	public Visit findVisitById(int id) throws InvalidVisitIdException {
		Optional<Visit> optVisit = visitRepo.findById(id);
		if( optVisit.isEmpty() ) {
			throw new InvalidVisitIdException("Visit ID "+id+" is not valid");
		}
		return optVisit.get();
	}
	
	public Visit editVisit(Visit visit) throws InvalidVisitIdException {
		findVisitById(visit.getId());
		return visitRepo.save(visit);
	}
	
	public Visit deleteVisit(int id) throws InvalidVisitIdException {
		Visit visit = findVisitById(id);
		visitRepo.deleteById(id);
		return visit;
	}
	
	//FINDBYID
//	public PatientVisit findPatientVisitById(int id) throws PatientVisitNotFoundException{
//		Optional<PatientVisit> optPatientVisit=patientVisitRepo.findById(id);
//		if(!optPatientVisit.isPresent()) {
//			throw new PatientVisitNotFoundException("Patient Visit Not Found"+id);
//			
//		}
//		return optPatientVisit.get();
//	}
	
	//FINDALL
//	public List<PatientVisit> getAllVisit(){
//		return patientVisitRepo.findAll();
//	}
	
	//DELETE
//	public void deletePatientVisit(int id) throws PatientVisitNotFoundException{
//		Optional<PatientVisit> optionalPatientVisit=patientVisitRepo.findById(id);
//		if(!optionalPatientVisit.isPresent()) {
//			throw new PatientVisitNotFoundException("Patient Visit Not Found with this id: "+id);
//			
//		}
//		patientVisitRepo.deleteById(id);
//	}
}
