package com.codegnan;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.codegnan.entity.Doctor;
import com.codegnan.entity.Patient;
import com.codegnan.entity.Visit;
import com.codegnan.exception.InvalidDateFormatException;

import com.codegnan.service.DoctorService;
import com.codegnan.service.PatientService;
import com.codegnan.service.VisitService;

@SpringBootApplication
public class HospitalManagementApplication {

	public static void main(String[] args) {
		
		
		ApplicationContext ctxt = SpringApplication.run(HospitalManagementApplication.class, args);
		
		/*Doctor doctor = new Doctor("Doc_01", "doc1@gmail.com", "9999999999", "M", "Dermitology", 25, "MS", 450000);
		
		DoctorService doctorService = ctxt.getBean(DoctorService.class);
		PatientService patientService = ctxt.getBean(PatientService.class);
		VisitService visitService = ctxt.getBean(VisitService.class);
		Doctor hiredDoctor = doctorService.hireDoctor(doctor);
		try {
		
		Patient patient1 = new Patient("Pat_01", "pat1@gmail.com", "1111111111", "M", "01-03-2020", 41);
		Patient patient2 = new Patient("Pat_02", "pat2@gmail.com", "2222222222", "M","01-03-2020", 31);
		
		Visit visit1 = new Visit("01-03-2020", "Skin Alergy", 79.5, 98.6, 123.5, "Cash");
		Visit visit2 = new Visit("01-03-2020", "Skin Rashes", 77.0, 98.6, 120.5, "UPI");
		
		visit1.setPatient(patient1);
		visit1.setDoctor(doctor);
		
		visit2.setPatient(patient2);
		visit2.setDoctor(doctor);
		
		patient2.setVisits(Arrays.asList(visit2));
		doctor.setVisits(Arrays.asList(visit1, visit2));

		
		Patient savedPatient1 = patientService.savePatient(patient1);
		Patient savedPatient2 = patientService.savePatient(patient2);
		
		
		Visit savedVisit1 = visitService.saveVisit(visit1);
		Visit savedVisit2 = visitService.saveVisit(visit2);
		}catch(InvalidDateFormatException e) {
			e.printStackTrace();
		}*/
		
		
		// Editing a Patient
//		Patient patient = new Patient(2, "Pat_01", "pat1@gmail.com", "2222222222", "M", "01-03-2024", 41);
//		
//		PatientService patientService = ctxt.getBean(PatientService.class);
//		
//		System.out.println("Before saving : "+patient);
//		Patient savedPatient;
//		try {
//			savedPatient = patientService.updatePatient(patient);
//			System.out.println("After updatinf : "+savedPatient);
//		} catch (InvalidPatientIdException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
	}

}