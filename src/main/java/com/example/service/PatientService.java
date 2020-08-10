package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.RecordNotFoundException;

import com.example.model.Patient;
import com.example.repository.PatientRepository;

@Service
public class PatientService {
     
    @Autowired
    PatientRepository repository;
     
	public List<Patient> getAllInformation()
    {
		List<Patient> informationList = repository.findAll();
         
        if(informationList.size() > 0) {
            return informationList;
        } else {
			return new ArrayList<Patient>();
        }
    }
     
	public Patient getPatientByPatient_Id(Integer Patient_Id) throws RecordNotFoundException
    {
		Optional<Patient> information = repository.findById(Patient_Id);
         
        if(information.isPresent()) {
            return information.get();
        } else {
            throw new RecordNotFoundException("No item record exist for given id");
        }
    }
     
	public Patient createOrUpdatePatient(Patient p) throws RecordNotFoundException
    {
		Optional<Patient> information = repository.findById(p.getPatient_Id());
		System.out.println(p.getPatient_Id());
		System.out.println(p.getFirstname());
		System.out.println(p.getLastname());
		System.out.println(p.getEmail());
		System.out.println(p.getPhone());
        if(information.isPresent())
        {
        	Patient newEntity = information.get();
			newEntity.setPatient_Id(p.getPatient_Id());
			newEntity.setFirstname(p.getFirstname());
			newEntity.setLastname(p.getLastname());
			newEntity.setEmail(p.getEmail());
			newEntity.setPhone(p.getPhone());
			
 
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {

			p = repository.save(p);
             
			return p;
        }
    }
     
	public void deletePatientById(Integer Patient_Id) throws RecordNotFoundException
    {
		Optional<Patient> information = repository.findById(Patient_Id);
         
        if(information.isPresent())
        {
            repository.deleteById(Patient_Id);
        } else {
            throw new RecordNotFoundException("No item record exist for given id");
        }
    }
}