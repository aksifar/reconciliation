package com.prudential.datalake.reconciliation.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prudential.datalake.reconciliation.exception.ConstraintsViolationException;
import com.prudential.datalake.reconciliation.exception.NoDocumentsFoundException;
import com.prudential.datalake.reconciliation.model.transformed.Customer;
import com.prudential.datalake.reconciliation.service.TransformedCustomerService;

@RestController
@CrossOrigin("*")
@RequestMapping("/transformed-customers")
public class TransformedCustomerController {

	@Autowired
	TransformedCustomerService tCustomerService;
	
	@GetMapping
	public ResponseEntity<List<Customer>> getTransformedCustomers() throws NoDocumentsFoundException
	{
		ResponseEntity<List<Customer>> response;
		List<Customer> tCustomerList = tCustomerService.getAllTransformedCustomers();
		if(null != tCustomerList && !tCustomerList.isEmpty())
			response = new ResponseEntity<List<Customer>>(tCustomerList, HttpStatus.OK);
		else
			throw new NoDocumentsFoundException("No Transformed Customer exists in the bucket");
		return response;
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<Object> getTransformedCustomerById(@PathVariable String customerId) throws NoDocumentsFoundException
	{
		ResponseEntity<Object> response;
		Customer customer = tCustomerService.findCustomer(customerId);
		if(null != customer )
			response =	new ResponseEntity<Object>( customer, HttpStatus.OK);
		else
			throw new NoDocumentsFoundException("No Transformed Customer with id: " + customerId + " exists in the bucket");
		return response;
	}
	
	@PostMapping
	public ResponseEntity<Object> createTransformedCustomer(@Valid @RequestBody Customer transformedCustomer) throws ConstraintsViolationException
	{
		ResponseEntity<Object> response;
		Customer tCustomer = tCustomerService.save(transformedCustomer);
		response = new ResponseEntity<>(tCustomer, HttpStatus.OK);
		return response;
	}
}
