package com.prudential.datalake.reconciliation.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.prudential.datalake.reconciliation.exception.ConstraintsViolationException;
import com.prudential.datalake.reconciliation.model.transformed.Customer;
import com.prudential.datalake.reconciliation.repository.TransformedCustomerRepository;
import com.prudential.datalake.reconciliation.service.TransformedCustomerService;

@Service
public class TransformedCustomerServiceImpl implements TransformedCustomerService {

	@Autowired
	TransformedCustomerRepository tCustomerRepositoty;
	
	private static final Logger LOG = LoggerFactory.getLogger(TransformedCustomerServiceImpl.class);
	
	@Override
	public List<Customer> getAllTransformedCustomers() {
		return tCustomerRepositoty.findAll();
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

}
