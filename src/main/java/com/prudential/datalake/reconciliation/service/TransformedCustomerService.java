package com.prudential.datalake.reconciliation.service;

import java.util.List;

import com.prudential.datalake.reconciliation.exception.ConstraintsViolationException;
import com.prudential.datalake.reconciliation.exception.NoDocumentsFoundException;
import com.prudential.datalake.reconciliation.model.transformed.Customer;

public interface TransformedCustomerService {
	
	List <Customer> getAllTransformedCustomers();

	Customer save(Customer tCustomer) throws ConstraintsViolationException;

	Customer findCustomer(String customerId) throws NoDocumentsFoundException;
}
