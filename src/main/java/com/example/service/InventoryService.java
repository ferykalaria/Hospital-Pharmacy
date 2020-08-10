package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.RecordNotFoundException;
import com.example.model.Inventory;
import com.example.repository.InventoryRepository;



@Service
public class InventoryService {
     
    @Autowired
    InventoryRepository repository;
     
	public List<Inventory> getAllItem()
    {
		List<Inventory> itemList = repository.findAll();
         
        if(itemList.size() > 0) {
            return itemList;
        } else {
			return new ArrayList<Inventory>();
        }
    }
     
	public Inventory getInventoryById(Integer id) throws RecordNotFoundException
    {
		Optional<Inventory> item = repository.findById(id);
         
        if(item.isPresent()) {
            return item.get();
        } else {
            throw new RecordNotFoundException("No item record exist for given id");
        }
    }
     
	public Inventory createOrUpdateInventory(Inventory i) throws RecordNotFoundException
    {
		Optional<Inventory> item = repository.findById(i.getId());
		System.out.println(i.getId());
		System.out.println(i.getName());
		System.out.println(i.getTotal_number());
        if(item.isPresent())
        {
			Inventory newEntity = item.get();
			newEntity.setId(i.getId());
			newEntity.setName(i.getName());
			newEntity.setTotal_num(i.getTotal_number());
			
 
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {

			i = repository.save(i);
             
			return i;
        }
    }
     
	public void deleteInventoryById(Integer id) throws RecordNotFoundException
    {
		Optional<Inventory> item = repository.findById(id);
         
        if(item.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No item record exist for given id");
        }
    }
}