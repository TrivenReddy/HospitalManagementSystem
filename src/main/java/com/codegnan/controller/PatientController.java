package com.codegnan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codegnan.entity.Patient;
import com.codegnan.entity.Visit;
import com.codegnan.exception.InvalidDateFormatException;
import com.codegnan.exception.InvalidDoctorIdException;
import com.codegnan.exception.InvalidPatientIdException;
import com.codegnan.service.PatientService;
import com.codegnan.service.VisitService;

@RestController
@RequestMapping("/patients")
public class PatientController {
	PatientService patientService;
	VisitService visitService;
	@Autowired
	public PatientController(PatientService patientService,VisitService visitService) {
		this.patientService=patientService;
		this.visitService=visitService;
		
	}
	//To get all the values
	@GetMapping("")
	public ResponseEntity<List<Patient>> getAllPatients(){
		List<Patient> patients=patientService.findAllPatients();
		ResponseEntity<List<Patient>> responseEntity=new ResponseEntity<List<Patient>>(patients, HttpStatus.OK);
		
		return responseEntity;
	}
	
	//To Get specific id values
	@GetMapping("/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable int id) throws InvalidPatientIdException{
		Patient patient=patientService.findPatientById(id);
		return new ResponseEntity<Patient>(patient,HttpStatus.OK);
	}
	
	//To get visits of specific id with all details
	@GetMapping("/{id}/visits")
	public ResponseEntity<List<Visit>> getVisitByPatient(@PathVariable int id) throws InvalidPatientIdException{
		Patient patient=patientService.findPatientById(id);
		List<Visit> visits=visitService.findVisitsByPatient(patient);
		return new ResponseEntity<List<Visit>>(visits,HttpStatus.OK);
	}
	
	//To add data 
	@PostMapping("")
	public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
		Patient savedPatient=patientService.savePatient(patient);
		return new ResponseEntity<Patient>(savedPatient,HttpStatus.OK);
		
	}
	
	//Edit the data
	@PutMapping("/{id}")
	public ResponseEntity<Patient> editPatient(@PathVariable int id,@RequestBody Patient patient) throws InvalidPatientIdException, InvalidDateFormatException {
		if(id!=patient.getId()) {
			throw new InvalidPatientIdException("ID of the patient "+patient.getId()+" is not matched");
		}
		patientService.updatePatient(patient);
		//Patient updatedPatient=patientService.editPatient(111,patient);
		return new ResponseEntity<Patient>(patient, HttpStatus.OK);
		
	}
	
	//Delete the data
	@DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable int id) throws InvalidPatientIdException {
        patientService.deletePatient(id);
        return new ResponseEntity<>("Doctor deleted successfully", HttpStatus.OK);
    }
	

}
