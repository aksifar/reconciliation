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
public class Billing implements Serializable{
	
	private static final long serialVersionUID = 8702947734872900877L;
	
	private String accountNo;	
	private String paymentMode;
	private String billCycle;
	private String paymentFreq;	
	private String autoDebit;	
}
