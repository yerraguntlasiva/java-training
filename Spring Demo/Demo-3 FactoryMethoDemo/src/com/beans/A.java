package com.beans;
public class A implements Printable{  
	public A() {
		System.out.println("A con");
	}
    @Override  
    public void print() {  
        System.out.println("hello a");  
    }   
    
}
