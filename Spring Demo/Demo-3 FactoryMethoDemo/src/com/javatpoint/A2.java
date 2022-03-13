package com.javatpoint;  
public class A2 {  
private static final A2 obj=new A2();  
public A2(){System.out.println("private constructor A2***");}  
public   A2 getA2(){  
    System.out.println("factory method ");  
    return obj;  
}  
public void msg(){  
    System.out.println("hello A2 method megs");  
}  
}  