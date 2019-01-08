package com.prudential.datalake.reconciliation.model.transformed;

import java.io.Serializable;

import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import com.couchbase.client.java.repository.annotation.Id;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.prudential.datalake.reconciliation.model.CHDRPF;
import com.prudential.datalake.reconciliation.model.REGPPF;
import com.prudential.datalake.reconciliation.model.UWQSPF;
import com.prudential.datalake.reconciliation.model.sub.Address;
import com.prudential.datalake.reconciliation.model.sub.Billing;
import com.prudential.datalake.reconciliation.model.sub.Contact;
import com.prudential.datalake.reconciliation.model.sub.CustomerLifeStyle;
import com.prudential.datalake.reconciliation.model.sub.Occupation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Document
@JsonInclude(Include.NON_NULL)
public class Customer implements Serializable{

	private static final long serialVersionUID = 3141513907585928011L;
	
	@Id
	@GeneratedValue(strategy = GenerationStrategy.UNIQUE)
	private String id;
//	private Billing billing;
//	private CustomerLifeStyle lifestyle;
//	private Address addressDetails;
	private String country;
	private String surName;
	private String sex;
//	private Occupation occupation;
	private String nationality;
	private String client;
//	private Contact contactDetails;
	private String salution;
	private String maritalStatus;
	//TODO:  gives error
//	private BankAccount[] bankAccounts;
	
	private String firstName;
	private String middleName;
	private String dob;
	private String spouse;
	private String children;
//	private CHDRPF[] policies;
//	private REGPPF[] claims;
	private String agent;
	private String payments;
//	private UWQSPF[] medicalHistory;
}
