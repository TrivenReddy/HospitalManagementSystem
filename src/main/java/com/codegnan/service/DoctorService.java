package com.codegnan.service;

import java.util.List;
import java.util.Optional;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codegnan.entity.Doctor;

import com.codegnan.exception.InvalidDoctorIdException;
import com.codegnan.repo.DoctorRepo;

@Service
public class DoctorService {
	private DoctorRepo doctorRepo;
    //@Autowired
	public DoctorService(DoctorRepo doctorRepo) {
		super();
		this.doctorRepo = doctorRepo;
	}

	public Doctor hireDoctor(Doctor doctor) {
		return doctorRepo.save(doctor);
	}
	
	//FINDBYID
	public Doctor findDoctorById(int id) throws InvalidDoctorIdException{
		Optional<Doctor> optDoctor=doctorRepo.findById(id);
		if(optDoctor.isEmpty()) {
			throw new InvalidDoctorIdException("Doctor Id: "+id+" is not found");
			
		}
		return optDoctor.get();
		
	}
	//FINDALL
	public List<Doctor> findAllDoctors(){
		return doctorRepo.findAll();
	}
	
	
	//UPDATE
	public Doctor updateDoctor(Doctor doctor) throws InvalidDoctorIdException {
		findDoctorById(doctor.getId());
		return doctorRepo.save(doctor);
	}
//		public Doctor editDoctor(int id,Doctor doctorDetails) throws InvalidDoctorIdException{
//			Optional<Doctor> optionalDoctor=doctorRepo.findById(id);
//			if(!optionalDoctor.isPresent()) {
//				throw new InvalidDoctorIdException("Doctor id: "+id+" not found");
//			}
//			Doctor existingDoctor=optionalDoctor.get();
//			existingDoctor.setName(doctorDetails.getName());
//			existingDoctor.setEmail(doctorDetails.getEmail());
//			existingDoctor.setMobile(doctorDetails.getMobile());
//			existingDoctor.setGender(doctorDetails.getGender());
//			existingDoctor.setSpecialization(doctorDetails.getSpecialization());
//			existingDoctor.setExperience(doctorDetails.getExperience());
//			existingDoctor.setDegrees(doctorDetails.getDegrees());
//			existingDoctor.setSalary(doctorDetails.getSalary());
//			
//			return doctorRepo.save(existingDoctor);
//			
//		}
	//DELETE
	public Doctor deleteDoctor(int id) throws InvalidDoctorIdException {
		Doctor doctor = findDoctorById(id);
		doctorRepo.deleteById(id);
		return doctor;
	}
//		public void deleteDoctor(int id) throws InvalidDoctorIdException{
//			Optional<Doctor> optionalDoctor=doctorRepo.findById(id);
//			if(!optionalDoctor.isPresent()) {
//				throw new InvalidDoctorIdException("Id is not present: "+id);
//			}	
//			Delete the student
//			doctorRepo.deleteById(id);
//		}

		

		

}
