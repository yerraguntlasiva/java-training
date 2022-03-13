package com.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class Emp {
	private int id;
	private String name;
	private Adress adress;
	
	public Emp() {
		
	}
	/*
	 * public Emp(Adress adress) { this.adress=adress;
	 * System.out.println("default emp : "); }
	 */
	
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
	
	
	  public Adress getAdress() { return adress; }
	  
	  public void setAdress(Adress adress) { this.adress = adress; }
	 

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", adress=" + adress + "]";
	}
		
	public void showAdress() {
		
		System.out.println("adress : "+this.adress.getCity());
	}
	
	

}
