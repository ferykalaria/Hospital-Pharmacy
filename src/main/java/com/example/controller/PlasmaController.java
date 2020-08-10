package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.RecordNotFoundException;
import com.example.model.Patient;
import com.example.model.Plasma;
import com.example.service.PlasmaService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/plasma")
public class PlasmaController
{
    @Autowired
    PlasmaService service;
 
	@GetMapping(produces = "application/json")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Plasma>> getAllInfo() {
		List<Plasma> list = service.getAllInfo();
 
		return new ResponseEntity<List<Plasma>>(list, new HttpHeaders(), HttpStatus.OK);
    }
	
	
 
	@GetMapping(path = "/get/{id}", produces = "application/json")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Plasma> getPlasmaById(
			@PathVariable("id") Integer id)
                                                    throws RecordNotFoundException {
		Plasma entity = service.getPlasmaById(id);

		return new ResponseEntity<Plasma>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Plasma> createOrUpdatePlasma(
			@RequestBody Plasma info)
                                                    throws RecordNotFoundException {
		System.out.println(info);
		Plasma updated = service.createOrUpdatePlasma(info);
		return new ResponseEntity<Plasma>(updated, new HttpHeaders(), HttpStatus.OK);
    }
	
 
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public HttpStatus deletePlasmaById(@PathVariable("id") Integer id)
                                                    throws RecordNotFoundException {
        service.deletePlasmaById(id);
        return HttpStatus.FORBIDDEN;
    }
 
}

