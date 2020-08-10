package com.example.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "ITEM")
@NamedQueries
(
    {
        @NamedQuery(name="findByItem_Id", query="from Inventory i where i.id=:iid"),
    
    }
)
public class Inventory implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @Column(name="ITEM_ID")
	private int id;
	
	@Column(name="ITEM_NAME")
	private String name;
	
	@Column(name="TOTAL_NUMBER")
	private String total_number;

	
	public Inventory() {
		super();
	}
	
	public Inventory(int id,String name, String total_number) {
		this.id = id;
		this.name = name;
		this.total_number = total_number;
	}


	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTotal_number() {
		return total_number;
	}
	public void setTotal_num(String total_number) {
		this.total_number = total_number;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id+":"+name+":"+total_number;
	}
		
}