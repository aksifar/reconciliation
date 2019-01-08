package com.prudential.datalake.reconciliation.model;

import java.io.Serializable;

import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import com.couchbase.client.java.repository.annotation.Id;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
@JsonInclude(Include.NON_NULL)
public class UWQSPF implements Serializable{

	private static final long serialVersionUID = 8705237129384710249L;
	
	@Id
	@GeneratedValue(strategy = GenerationStrategy.UNIQUE)
	private String id;

	private String chdrnum;
	private String lifcnum;
	private String life;
	private String uwqsdata;
	private int uwqsm01a;
	private int uwqsm02;
	private String uwqsm03a; 
	private String uwqsm04a;
	private String uwqsm05a;
	private String uwqsm06a;
	private String uwqsm07a;
	private String uwqsm08a;
	private String uwqsm09a;
	private String uwqsm10a;
	private String user_profile;
	private String job_name;
	private String datime;
	private String uwqsm11a; 
	private int rrn;
}
