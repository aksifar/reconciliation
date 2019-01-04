package com.prudential.datalake.reconciliation.model.transformed;

import java.io.Serializable;

import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import com.couchbase.client.java.repository.annotation.Id;
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
public class Customer implements Serializable{

	private static final long serialVersionUID = 3141513907585928011L;
	
	@Id
	@GeneratedValue(strategy = GenerationStrategy.UNIQUE)
	private String id;
	private String name;
}
