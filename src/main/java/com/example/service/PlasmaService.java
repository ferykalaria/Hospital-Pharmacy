package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.RecordNotFoundException;
import com.example.model.Patient;
import com.example.model.Plasma;
import com.example.repository.PatientRepository;
import com.example.repository.PlasmaRepository;

@Service
public class PlasmaService {
     
    @Autowired
    PlasmaRepository repository;
    
    @Autowired
    PatientRepository prepository;
    
     
	public List<Plasma> getAllInfo()
    {
		List<Plasma> infoList = repository.findAll();
         
        if(infoList.size() > 0) {
            return infoList;
        } else {
			return new ArrayList<Plasma>();
        }
    }
	
     
	public Plasma getPlasmaById(Integer id) throws RecordNotFoundException
    {
		Optional<Plasma> info = repository.findById(id);
         
        if(info.isPresent()) {
            return info.get();
        } else {
            throw new RecordNotFoundException("No information exist for given id");
        }
    }
	
	
	public Plasma createOrUpdatePlasma(Plasma p) throws RecordNotFoundException
    {
		Optional<Plasma> info = repository.findById(p.getId());
		System.out.println(p.getId());
		System.out.println(p.getPlasma_type());
		System.out.println(p.getDate());
		System.out.println(p.getAgree());
		System.out.println(p.getPatient_Id());
        if(info.isPresent())
        {
        	Plasma newEntity = info.get();
			newEntity.setId(p.getId());
			newEntity.setPlasma_type(p.getPlasma_type());
			newEntity.setDate(p.getDate());
			newEntity.setAgree(p.getAgree());
			
 
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {

			p = repository.save(p);
             
			return p;
        }
    }


	public void deletePlasmaById(Integer id) throws RecordNotFoundException
    {
		Optional<Plasma> info = repository.findById(id);
         
        if(info.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No information exist for given id");
        }
    }
}
