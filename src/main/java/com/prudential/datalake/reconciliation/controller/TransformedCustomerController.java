package com.prudential.datalake.reconciliation.controller;

import java.util.List;

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

import com.prudential.datalake.reconciliation.exception.ConstraintsViolationException;
import com.prudential.datalake.reconciliation.exception.NoDocumentsFoundException;
import com.prudential.datalake.reconciliation.model.transformed.Customer;
import com.prudential.datalake.reconciliation.repository.CustomerRepository;
import com.prudential.datalake.reconciliation.service.TransformedCustomerService;

@RestController
@CrossOrigin("*")
@RequestMapping("/transformed-customers")
public class TransformedCustomerController {

	@Autowired
	TransformedCustomerService tCustomerService;
	
	@Autowired
	CustomerRepository customerRepository;
	
	/*@GetMapping
	public ResponseEntity<List<Customer>> getTransformedCustomers() throws NoDocumentsFoundException
	{
		ResponseEntity<List<Customer>> response;
		List<Customer> tCustomerList = tCustomerRepository.getAllTransformedCustomers();
		if(null != tCustomerList && !tCustomerList.isEmpty())
			response = new ResponseEntity<List<Customer>>(tCustomerList, HttpStatus.OK);
		else
//			response =  new ResponseEntity<>(HttpStatus.NOT_FOUND);
			throw new NoDocumentsFoundException("No Transformed Customer exists in the bucket");
		return response;
	}*/
	
	@GetMapping
	public ResponseEntity<Object> getTransformedCustomers() throws NoDocumentsFoundException
	{
		ResponseEntity<Object> response;
		List<Customer> list = customerRepository.findAll();
		if(null != list && !list.isEmpty())
			response =	new ResponseEntity<Object>(list, HttpStatus.OK);
		else
			throw new NoDocumentsFoundException("No Transformed Customer exists in the bucket");
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
