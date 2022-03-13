package com.example.demo.beans;

import javax.inject.Named;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component("adress2")
//@Primary
public class CurrentAdress {
	private int hNo=24;
	private String city="CurrentCity";
	
	
	public int gethNo() {
		return hNo;
	}
	public void sethNo(int hNo) {
		this.hNo = hNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "CurrentAdress [hNo=" + hNo + ", city=" + city + "]";
	}
	
	//@Override
	public void showAdress() {
		System.out.println(this);
		
	}
	
	
	
}
