package com.virtualpairprogrammers.employeemanagement.backingbeans;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="user")
public class UserBean {
  private String name;
  private String niceDate;

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public String getNiceDate() {
    return this.niceDate;
  }

  public String greetUser() {
    //TODO: business processign
    SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy"); 
    this.niceDate = sdf.format(new Date());

    //TODO: forward to the next page
    return "welcome";
  }

	

}
