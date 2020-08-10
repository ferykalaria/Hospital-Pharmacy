package com.example.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "PLASMA")
@NamedQueries
(
    {
        @NamedQuery(name="findById", query="from Plasma p where p.id=:pid"),
    
    }
)
public class Plasma implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @Column(name="PLASMA_ID")
	private int id;
	
	@Column(name="PLASMA_TYPE")
	private String plasma_type;
	
	@Column(name="DATE")
	private String date;
	
	@Column(name="AGREE")
	private String agree;
	
	@Column(name="PATIENT_ID")
	private int patient_Id;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "PATIENT_ID", nullable = false, insertable = false, updatable = false)
	@JsonBackReference
	private Patient p;

	
	public Plasma() {
		super();
	}
	
	public Plasma(int id,String plasma_type, String date, String agree, int patient_id) {
		this.id = id;
		this.plasma_type = plasma_type;
		this.date = date;
		this.agree = agree;
		this.patient_Id = patient_id;
	}


	public Patient getP() {
		return p;
	}

	public void setP(Patient p) {
		this.p = p;
	}

	public int getPatient_Id() {
		return patient_Id;
	}

	public void setPatient_id(int patient_Id) {
		this.patient_Id = patient_Id;
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlasma_type() {
		return plasma_type;
	}

	public void setPlasma_type(String plasma_type) {
		this.plasma_type = plasma_type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAgree() {
		return agree;
	}

	public void setAgree(String agree) {
		this.agree = agree;
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id+":"+plasma_type+":"+date+":"+agree+":"+patient_Id+":"+p.getFirstname()+p.getLastname()+p.getEmail()+p.getPhone();
	}
		
}