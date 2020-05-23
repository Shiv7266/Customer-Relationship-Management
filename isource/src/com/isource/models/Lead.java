package com.isource.models;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Lead
 *
 */

@NamedQuery(name="Lead.findById",query="SELECT f from Lead f where f.id=:id")
@Entity
public class Lead implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	public Lead() {
		super();
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	private Salutation salutation;
	
	private String firstName;
	
	private String lastName;
	
	private String emailId;
	
	private String mobileNumber;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Salutation getSalutation() {
		return salutation;
	}

	public void setSalutation(Salutation salutation) {
		this.salutation = salutation;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	
	
	
	
   
}
