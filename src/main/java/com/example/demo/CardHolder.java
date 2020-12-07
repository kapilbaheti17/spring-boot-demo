package com.example.demo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CardHolder {
	
	private @Id @GeneratedValue(strategy = GenerationType.AUTO) int id;
	private String empId;
	private String firstName;
	private String lastName;
	private int empType;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<AccessCard> accessCardList;
	
	//Default constructor
	public CardHolder() {
		
	}
	
	public List<AccessCard> getAccessCardList() {
		return accessCardList;
	}

	public void setAccessCardList(List<AccessCard> accessCardList) {
		this.accessCardList = accessCardList;
	}

	//Constructor for initializing the list
	public CardHolder(String empId, String firstName, String lastName, int empType, List<AccessCard> lst) {
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.empType = empType;
		this.accessCardList = lst;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getEmpType() {
		return empType;
	}

	public void setEmpType(int empType) {
		this.empType = empType;
	}
	
	

}
