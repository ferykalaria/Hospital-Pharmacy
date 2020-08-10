package com.example.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "PATIENT")
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id @Column(name="PATIENT_ID")
	private Integer patient_Id; 
	
	@Column(name="FIRSTNAME")
	private String firstname;
	
	@Column(name="LASTNAME")
	private String lastname;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PHONE")
	private String phone;

//	@OneToMany(orphanRemoval=true, mappedBy="p")
//	@JsonManagedReference
//	private List<Plasma> infoList;
	
	public Patient(Integer patient_Id, String firstname, String lastname, String email, String phone) {
		super();
		this.patient_Id = patient_Id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
	}
	public Patient() {
		super();
	}
	
	
	public Integer getPatient_Id() {
		return patient_Id;
	}
	public void setPatient_Id(Integer patient_Id) {
		this.patient_Id = patient_Id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
//	public List<Plasma> getInfoList() {
//		return infoList;
//	}
//	public void setInfoList(List<Plasma> infoList) {
//		this.infoList = infoList;
//	}	
	
	
}
