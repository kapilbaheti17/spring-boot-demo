package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AccessCard {
	
	public @Id @GeneratedValue int id;
	private int cardNumber;
	private int cardType;
	private int issueLevel;
	private int cardStatus;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private CardHolder cardHolder;
	
	//Default constructor
	public AccessCard() {
		
	}
	
	//Constructor for the class
	public AccessCard(int carNum, int carType, int issLevel, int carStatus) {
		this.cardNumber = carNum;
		this.cardType = carType;
		this.issueLevel = issLevel;
		this.cardStatus = carStatus;
	}
	
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public int getCardType() {
		return cardType;
	}
	public void setCardType(int cardType) {
		this.cardType = cardType;
	}
	public int getIssueLevel() {
		return issueLevel;
	}
	public void setIssueLevel(int issueLevel) {
		this.issueLevel = issueLevel;
	}
	public int getCardStatus() {
		return cardStatus;
	}
	public void setCardStatus(int cardStatus) {
		this.cardStatus = cardStatus;
	}
}
