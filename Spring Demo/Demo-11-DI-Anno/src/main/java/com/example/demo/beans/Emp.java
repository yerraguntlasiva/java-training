package com.example.demo.beans;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Emp {
	private int id;
	private String name;
	
	@Autowired
	private Adress adress;
	
	public Emp() {
		
		System.out.println("default emp "+adress);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Adress getAdress() {
		return adress;
	}

	
	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", adress=" + adress + "]";
	}
	
	public void showEmp() {
		System.out.println("showEmp is called ");
		adress.show();
	}

	
	

}
