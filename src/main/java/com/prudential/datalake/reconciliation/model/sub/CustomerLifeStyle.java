package com.prudential.datalake.reconciliation.model.sub;

import java.io.Serializable;

import org.springframework.data.couchbase.core.mapping.Document;

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
public class CustomerLifeStyle implements Serializable{
	private static final long serialVersionUID = 9161165638857982772L;

	private int weight;
	private int height;
	private String questionAnswers;
	private int ageNextBday;
	private String isSmoker;
	//TODO:  Medical Illness is a class as well
	private String medicalHistory ;
}
