package com.example.cap.demo.API.controller;

public class Customers {
	
	  private String customerid;
	  private String fname;
	  private String lname;
	  private Long id;
	  
	  // [END book]
	  // [START keys]
	  public static final String CUSTOMER_ID = "customerid";
	  public static final String FIRSTNAME = "fname";
	  public static final String LASTNAME = "lname";
	  public static final String ID = "id";
	 	  // [END keys]

	  // [START constructor]
	  // We use a Builder pattern here to simplify and standardize construction of Book objects.
	  private Customers(Builder builder) {
	    this.customerid = builder.customerid;
	    this.fname = builder.fname;
	    this.lname = builder.lname;
	    this.id = builder.id;
	   	  }
	  // [END constructor]

	  // [START builder]
	  public static class Builder {
	    private String customerid;
	    private String fname;
	    private String lname;
	    private Long id;
	    
	    public Builder customerid(String customerid) {
	      this.customerid = customerid;
	      return this;
	    }
	    public Builder id(Long id) {
	        this.id = id;
	        return this;
	      }
	    public Builder fname(String fname) {
	      this.fname = fname;
	      return this;
	    }

	    public Builder lname(String lname) {
	      this.lname = lname;
	      return this;
	    }
	    public Customers build() {
	      return new Customers(this);
	    }
	  }

	  public String getCustomerID() {
	    return customerid;
	  }

	  public void setCustomerID(String customerid) {
	    this.customerid = customerid;
	  }

	  public String getFirstName() {
	    return fname;
	  }

	  public void setFirstNam(String fname) {
	    this.fname = fname;
	  }
	  public Long getId() {
		    return id;
		  }

	  public void setId(Long id) {
		    this.id = id;
		  }
	  public String getLastName() {
	    return lname;
	  }

	  public void setLastName(String lname) {
	    this.lname = lname;
	  }

	  
	  // [END builder]

	  @Override
	  public String toString() {
	    return
	        "CustomerID: " + customerid + ", FirstName: " + fname + ", LastName: " + lname;
	  }
	}
	// [END example]


