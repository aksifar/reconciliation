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
public class CHDRPF implements Serializable{

	private static final long serialVersionUID = -2546177479680227428L;
	@Id
	@GeneratedValue(strategy = GenerationStrategy.UNIQUE)
	private String id;
	
	private String chdrpfx ;
	private String chdrcoy ;
	private String chdrnum ;
	private String recode ;
    private long tranno;
    private long ptrneff;
    private String transaction_date;
    private String transaction_time;
	private String termid;
    private long user;
    private String batcpfx;
    private String batccoy;
    private String batcbrn;
    private int batcactyr;
    private int batcactmn;
    private String batctrcde;
    private String batcbatch;
    private String prtflg ;
    private String validflag ;
    private String user_profile;
    private String job_name;
    private String datime;
    private long rrn;
}
