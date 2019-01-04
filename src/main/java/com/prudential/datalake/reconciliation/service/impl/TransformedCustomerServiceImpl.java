package com.prudential.datalake.reconciliation.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.prudential.datalake.reconciliation.exception.ConstraintsViolationException;
import com.prudential.datalake.reconciliation.exception.NoDocumentsFoundException;
import com.prudential.datalake.reconciliation.model.transformed.Customer;
import com.prudential.datalake.reconciliation.repository.TransformedCustomerRepository;
import com.prudential.datalake.reconciliation.service.TransformedCustomerService;

@Service
public class TransformedCustomerServiceImpl implements TransformedCustomerService {

	@Autowired
	TransformedCustomerRepository tCustomerRepositoty;
	
	private static final Logger LOG = LoggerFactory.getLogger(TransformedCustomerServiceImpl.class);
	
	@Override
	public Customer findOne(String customerId) throws NoDocumentsFoundException {
		return findCustomerChecked(customerId);
	}
	
	@Override
	public List<Customer> findAll() {
		Iterator<Customer> iterator = tCustomerRepositoty.findAll().iterator();
		List<Customer> customers = new ArrayList<>();  
		iterator.forEachRemaining(customers::add);
		return customers;
	}

	@Override
	public Page<Customer> findAll(Pageable pageRequest) {
		return tCustomerRepositoty.findAll(pageRequest);
	}
	
	@Override
	public Customer save(Customer tCustomer) throws ConstraintsViolationException {
		Customer customer = null;
		try
	     {
			customer = tCustomerRepositoty.save(tCustomer);
	     }
		catch (DataIntegrityViolationException e)
	     {
	         LOG.error("ConstraintsViolationException while creating a transformed customer: {}", e);
	         throw new ConstraintsViolationException(e.getMessage());
	     }
		return customer;
	}

	private Customer findCustomerChecked(String customerId) throws NoDocumentsFoundException
    {
        return tCustomerRepositoty.findById(customerId)
            .orElseThrow(() -> new NoDocumentsFoundException("Could not find transformed customer with id: " + customerId));
    }
}
