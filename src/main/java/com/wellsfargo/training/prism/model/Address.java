package com.wellsfargo.training.prism.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@NoArgsConstructor //for default constructor
@Getter
@Setter
@Entity
@Table(name="address")
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long addressid;
	
	private @NonNull String line1;
	
	private String line2;
	
	private String landmark;
	
	private @NonNull String city;
	
	private @NonNull String state;
	
	private @NonNull String pincode;
	
	@OneToOne
	@JoinColumn(name="account-number")
	private Customer customer;
	
	

}
