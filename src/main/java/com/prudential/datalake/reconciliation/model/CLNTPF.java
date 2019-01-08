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
public class CLNTPF implements Serializable{
	
	private static final long serialVersionUID = -6901682871493329587L;

	@Id
	@GeneratedValue(strategy = GenerationStrategy.UNIQUE)
	private String id;
	private String clntnum;
	private String surname;
	private String givname;
	private String middl02;
	private String cltdob;
	private String cltsex;
	private String marryd;
	private String salut;
	private String natlty;
	private String occpcode; // occupation.code
//	private String	occpcode; // occupation.desc
}
