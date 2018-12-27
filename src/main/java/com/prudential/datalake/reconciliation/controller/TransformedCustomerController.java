package com.prudential.datalake.reconciliation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prudential.datalake.reconciliation.exception.DocumentNotFoundException;
import com.prudential.datalake.reconciliation.model.transformed.Customer;
import com.prudential.datalake.reconciliation.repository.TransformedCustomerRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/transformed")
public class TransformedCustomerController {

	@Autowired
	TransformedCustomerRepository tCustomerRepository;
	
	@GetMapping
	public ResponseEntity<Object> getTransformedCustomers() throws DocumentNotFoundException
	{
		ResponseEntity<Object> response;
		Iterable<Customer> tCustomer = tCustomerRepository.findAll();
		if(null != tCustomer)
			response = new ResponseEntity<>(tCustomer, HttpStatus.OK);
		else
//			response =  new ResponseEntity<>(HttpStatus.NOT_FOUND);
			throw new DocumentNotFoundException("No Transformed Customer exists in the bucket");
		return response;
	}
	
	@PostMapping
	public ResponseEntity<Object> createPerson(@Valid @RequestBody Customer transformedCustomer)
	{
		ResponseEntity<Object> response;
		Customer tCustomer = tCustomerRepository.save(transformedCustomer);
		response = new ResponseEntity<>(tCustomer, HttpStatus.OK);
		return response;
	}
}
