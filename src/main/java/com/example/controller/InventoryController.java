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
import com.example.model.Inventory;
import com.example.service.InventoryService;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/item")
public class InventoryController
{
    @Autowired
    InventoryService service;
 
	@GetMapping(produces = "application/json")
	@PreAuthorize("hasRole('MODERATOR')")
	public ResponseEntity<List<Inventory>> getAllItem() {
		List<Inventory> list = service.getAllItem();
 
		return new ResponseEntity<List<Inventory>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
	@GetMapping(path = "/get/{id}", produces = "application/json")
	@PreAuthorize("hasRole('MODERATOR')")
	public ResponseEntity<Inventory> getInventoryById(
			@PathVariable("id") Integer id)
                                                    throws RecordNotFoundException {
		Inventory entity = service.getInventoryById(id);

		return new ResponseEntity<Inventory>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
	@PostMapping
	@PreAuthorize("hasRole('MODERATOR')")
	public ResponseEntity<Inventory> createOrUpdateInventory(
			@RequestBody Inventory item)
                                                    throws RecordNotFoundException {
		System.out.println(item);
		Inventory updated = service.createOrUpdateInventory(item);
		return new ResponseEntity<Inventory>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
	@DeleteMapping(path = "/{id}")
	@PreAuthorize("hasRole('MODERATOR')")
	public HttpStatus deleteInventoryById(@PathVariable("id") Integer id)
                                                    throws RecordNotFoundException {
        service.deleteInventoryById(id);
        return HttpStatus.FORBIDDEN;
    }
 
}
