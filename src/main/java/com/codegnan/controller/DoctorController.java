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

import com.codegnan.entity.Doctor;
import com.codegnan.entity.Visit;
import com.codegnan.entity.Visit;
import com.codegnan.exception.InvalidDoctorIdException;
import com.codegnan.service.DoctorService;
import com.codegnan.service.VisitService;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
	DoctorService doctorService;
	VisitService visitService;
	@Autowired
	public DoctorController(DoctorService doctorService,VisitService visitService) {
		this.doctorService=doctorService;
		this.visitService=visitService;
	}
	
	//To get all the values
	@GetMapping("")
	public ResponseEntity<List<Doctor>> getAllDoctors(){
		List<Doctor> doctors=doctorService.findAllDoctors();
		//We should add response code in the response of API call
		ResponseEntity<List<Doctor>> responseEntity=new ResponseEntity<List<Doctor>>(doctors, HttpStatus.OK);
		//return doctorService.findAllDoctors();
		return responseEntity;
	}
	
	//To Get specific id values
	@GetMapping("/{id}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable int id) throws InvalidDoctorIdException{
		Doctor doctor=doctorService.findDoctorById(id);
		return new ResponseEntity<Doctor>(doctor,HttpStatus.OK);
		
	}
	
	//To get visits of specific id with all details
	@GetMapping("/{id}/visits")
	public ResponseEntity<List<Visit>> getVisitByDoctor(@PathVariable int id) throws InvalidDoctorIdException{
		Doctor doctor=doctorService.findDoctorById(id);
		List<Visit> visits=visitService.findVisitsByDoctor(doctor);
		
		return new ResponseEntity<List<Visit>>(visits,HttpStatus.OK);
	}
	
	//To add data
	@PostMapping("")
	public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor) {
		Doctor savedDoctor=doctorService.hireDoctor(doctor);
		return new ResponseEntity<Doctor>(savedDoctor,HttpStatus.OK);
		
	}
	
	//Edit the data
	@PutMapping("/{id}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable int id,@RequestBody Doctor doctor) throws InvalidDoctorIdException {
		if(id!=doctor.getId()) {
			throw new InvalidDoctorIdException("ID of the doctor "+doctor.getId()+" is not matched");
		}
		doctorService.updateDoctor(doctor);
		//Doctor updatedDoctor=doctorService.editDoctor(id, doctor);
		return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
		
	}
	
	//Delete the data
	@DeleteMapping("/{id}")
    public ResponseEntity<Doctor> deleteDoctor(@PathVariable int id) throws InvalidDoctorIdException {
        Doctor deletedDoctor=doctorService.deleteDoctor(id);
        return new ResponseEntity<Doctor>(deletedDoctor, HttpStatus.OK);
    }

}
