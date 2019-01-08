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
public class CLDPPF implements Serializable{
	
	private static final long serialVersionUID = -2546177479680227428L;

	@Id
	@GeneratedValue(strategy = GenerationStrategy.UNIQUE)
	private String id;
	private String clntcoy;
	private String clntnum;
    private String noofdp;
    private String dpclnm01;
    private String dpclnm02;
    private String dpclnm03;
    private String dpclnm04;
    private String dpclnm05;
    private String dpclnm06;
    private String dpclnm07;
    private String dpclnm08;
    private String dpclnm09;
    private String dpclrel01;
    private String dpclrel02;
    private String dpclrel03;
    private String dpclrel04;
    private String dpclrel05;
    private String dpclrel06;
    private String dpclrel07;
    private String dpclrel08;
    private String dpclrel09;
    private long dpdob01;
    private long dpdob02;
    private long dpdob03;
    private long dpdob04;
    private long dpdob05; 
    private long dpdob06; 
    private long dpdob07; 
    private long dpdob08; 
    private long dpdob09; 
    private long noofgrc;
    private String user_profile;
    private String job_name;
    private String datime;
    private long rrn;
	
}
