package com.prudential.datalake.reconciliation.service;

import com.prudential.datalake.reconciliation.DTO.CustomerDTO;

public interface RawCustomerService {

	CustomerDTO findAllById(String customerId);
	
}
