package com.prudential.datalake.reconciliation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	//TODO: sort direction and sortBy is not working
	@GetMapping
	public ResponseEntity<Page<Customer>> getTransformedCustomerByPage(
			@RequestParam(value = "page", defaultValue = "1", required = false) int pageNumber,
			@RequestParam(value = "size", defaultValue = "5", required = false) int pageSize,
			@RequestParam(value="sortDirection", defaultValue="desc",required=false) String sortDirection,
			@RequestParam(value="sortBy", defaultValue="id",required=false) String sortColumn) throws NoDocumentsFoundException
	{
		//TODO:  need to figure out the correct property intead of id
		Sort sort=new Sort(Direction.fromString(sortDirection), "id");
		Pageable pageRequest = new PageRequest(pageNumber, pageSize, sort);
		
		Page<Customer> page = tCustomerService.findAll(pageRequest);
		if(null != page && !page.isEmpty())
		{
			return new ResponseEntity<Page<Customer>>( page, HttpStatus.OK);
		}
		else
			throw new NoDocumentsFoundException("No Transformed Customer exists in the bucket");
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<Object> getTransformedCustomerById(@PathVariable String customerId) throws NoDocumentsFoundException
	{
		ResponseEntity<Object> response;
		Customer customer = tCustomerService.findOne(customerId);
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
