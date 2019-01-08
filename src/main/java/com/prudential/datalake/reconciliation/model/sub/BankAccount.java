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
public class BankAccount implements Serializable{

	private static final long serialVersionUID = 8829428922425993911L;
	
	private String bankName;
	private String bankCode;
	private String branchCode;	
	private String accountNo;	
	private String accountName;	
}
