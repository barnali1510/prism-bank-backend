package com.wellsfargo.training.prism.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor //for default constructor
@Getter
@Setter
@Entity
@Table(name="customers")
public class Customer {
	
	@Id
	@SequenceGenerator(name="account_no_seq", initialValue=151000000, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="account_no_seq")
	@Column(name="acount_number")
	private Long accountNo;
	
	@Column(name="salutation")
	private String salutation;
	
	@Column(name="first_name")
	private String fname;
	
	@Column(name="middle_name")
	private String mname;
	
	@Column(name="last_name")
	private String lname;
	
	@Column(name="father_name")
	private String fatherName;
	
	@Column(name="aadhar_number", unique=true)
	private String aadharNumber;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dob;

	@Column(unique=true)
	private String email;
	
	@Column(name="phone", unique=true)
	private String phoneNo;
	
	@OneToOne(mappedBy="customer", cascade=CascadeType.ALL)
	private Address address;
	

}
