package com.prudential.datalake.reconciliation.model;

import java.io.Serializable;

import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import com.couchbase.client.java.repository.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User implements Serializable{
	
	private static final long serialVersionUID = -3750372723811676226L;
	
	@Id
	@GeneratedValue(strategy = GenerationStrategy.UNIQUE)
	String id;
	String userName;
}
