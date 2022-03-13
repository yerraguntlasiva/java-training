package com.org;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class StudentTag extends TagSupport{

	String name="Sharukhkhan";
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	@Override
	public int doEndTag() throws JspException {
		System.out.println("doEndTag");
		JspWriter out=pageContext.getOut();//returns the instance of JspWriter  
		try {
			out.print("<h2>Welcome to Cusomt tag do EndTag()<h2><br>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.doEndTag();
	}

	@Override
	public int doStartTag() throws JspException {
		System.out.println("doStartTag");
		JspWriter out=pageContext.getOut();//returns the instance of JspWriter  
	    try{  
	     out.print("<h1>Welcome to Cusomt tag do Start()<h1><br><br>");//printing date and time using JspWriter  
	    }catch(Exception e){System.out.println(e);}  
	    return SKIP_BODY;//will not evaluate the body content of the tag  
	 
	}

	@Override
	public String toString() {
		return "StudentTag [name=" + name + "]";
	}
	
	

}
