package com.codegnan.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.codegnan.exception.InvalidDateFormatException;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
@Entity
public class Patient extends Person {
	Date regDate;
	int age;
	@OneToMany(mappedBy="patient",cascade=CascadeType.ALL)
	@JsonIgnore
	List<Visit> visits;
	
	public Patient() {
		super();
		
	}
	public Patient(int id, String name, String email, String mobile, String gender,String strRegDate,int age)throws InvalidDateFormatException {
		super(id, name, email, mobile, gender);
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			this.regDate=simpleDateFormat.parse(strRegDate);
		} catch (ParseException e) {
			throw new InvalidDateFormatException(e);
			
			
			
		}
		this.age=age;
	
	}
	public Patient(String name, String email, String mobile, String gender,String strRegDate,int age)throws InvalidDateFormatException {
		super(name, email, mobile, gender);
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy");
		try {
			this.regDate=simpleDateFormat.parse(strRegDate);
		} catch (ParseException e) {
			throw new InvalidDateFormatException(e);
		}
		this.age=age;
	}
	public String getRegDate() {
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy");
		String strRegDate=simpleDateFormat.format(regDate);
		
		return strRegDate;
	}
	//Format date:dd-mm-yyyy
	//ex:15-08-2024
	public void setRegDate(String strRegDate) throws InvalidDateFormatException {
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			this.regDate=simpleDateFormat.parse(strRegDate);
		} catch (ParseException e) {
			throw new InvalidDateFormatException(e);
		}
		
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<Visit> getVisits() {
		return visits;
	}
	public void setVisits(List<Visit> visits) {
		this.visits = visits;
	}
	@Override
	public String toString() {
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy");
		String strRegDate=simpleDateFormat.format(regDate);
		return "Patient ["+super.toString()+"regDate=" + regDate + ", age=" + age + "]";
	}
	
	

}
