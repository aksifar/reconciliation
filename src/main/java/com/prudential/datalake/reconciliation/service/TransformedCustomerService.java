package com.prudential.datalake.reconciliation.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.prudential.datalake.reconciliation.exception.ConstraintsViolationException;
import com.prudential.datalake.reconciliation.exception.NoDocumentsFoundException;
import com.prudential.datalake.reconciliation.model.transformed.Customer;

public interface TransformedCustomerService {
	
	List <Customer> findAll();

	Customer save(Customer tCustomer) throws ConstraintsViolationException;

	Customer findOne(String customerId) throws NoDocumentsFoundException;

	Page<Customer> findAll(Pageable pageRequest);
}
