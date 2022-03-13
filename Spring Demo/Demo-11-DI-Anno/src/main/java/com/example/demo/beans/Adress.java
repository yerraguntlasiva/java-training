package com.example.demo.beans;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class Adress {
	private int hNo=20;
	private String city="Bidar";
	
	public Adress() {
		System.out.println("Adress defaul cons");
	}
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
		return "Adress [hNo=" + hNo + ", city=" + city + "]";
	}
	public void show() {
		System.out.println("address is showing");
	}
	
}
