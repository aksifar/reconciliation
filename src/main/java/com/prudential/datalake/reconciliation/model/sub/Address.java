package com.prudential.datalake.reconciliation.model.sub;

import java.io.Serializable;

import org.springframework.data.couchbase.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
public class Address implements Serializable{
	
	private static final long serialVersionUID = -2670150954371769274L;

	private String line1;
	private String line2;	
	private String line3;	
	private String line4;	
	private String line5;	
	private String city;
	private String state;	
	private String district;	
	private String zipcode;	
	private String country;
	private String landmark;	

}
