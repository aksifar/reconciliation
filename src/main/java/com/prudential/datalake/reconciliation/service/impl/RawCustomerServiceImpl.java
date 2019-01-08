package com.prudential.datalake.reconciliation.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prudential.datalake.reconciliation.DTO.CustomerDTO;
import com.prudential.datalake.reconciliation.model.CHDRPF;
import com.prudential.datalake.reconciliation.model.CLDPPF;
import com.prudential.datalake.reconciliation.model.CLNTPF;
import com.prudential.datalake.reconciliation.model.UWQSPF;
import com.prudential.datalake.reconciliation.repository.CHDRPFRepository;
import com.prudential.datalake.reconciliation.repository.CLDPPFRepository;
import com.prudential.datalake.reconciliation.repository.CLNTPFRepository;
import com.prudential.datalake.reconciliation.repository.UWQSPFRepository;
import com.prudential.datalake.reconciliation.service.RawCustomerService;

@Service
class RawCustomerServiceImpl implements RawCustomerService {
	@Autowired CLNTPFRepository clntpfRepository;
	@Autowired CLDPPFRepository cldppfRepository;
	@Autowired CHDRPFRepository chdrpfRepository;
	@Autowired UWQSPFRepository uwqspfRepository;
	

	@Override
	public CustomerDTO findAllById(String customerId) {
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setId(customerId);
		
		findCLNTPFById(customerId , customerDTO);
		findCLDPPFById(customerId, customerDTO);
		findCHDRPFById(customerId, customerDTO);
		findUWQSPFById(customerId, customerDTO);
		
		return customerDTO;
	}
	
	private void findUWQSPFById(String customerId, CustomerDTO customerDTO) {
		Optional<UWQSPF>  uwqspf = uwqspfRepository.findById("UWQSPF::" + customerId);
		if(uwqspf.isPresent())
		{
			customerDTO.setUwqspf(uwqspf.get());
		}
	}

	private void findCLDPPFById(String customerId, CustomerDTO customerDTO) {
		Optional<CLDPPF>  cldppf = cldppfRepository.findById("CLDPPF::" + customerId);
		if(cldppf.isPresent())
		{
			customerDTO.setCldppf(cldppf.get());
		}
	}

	private void findCLNTPFById(String customerId, CustomerDTO customerDTO){
		Optional<CLNTPF>  cltnpf = clntpfRepository.findById("CLNTPF::" + customerId);
		if(cltnpf.isPresent())
		{
			customerDTO.setClntpf(cltnpf.get());
		}
	}
	
	private void findCHDRPFById(String customerId, CustomerDTO customerDTO){
		Optional<CHDRPF>  chdrpf = chdrpfRepository.findById("CHDRPF::" + customerId);
		if(chdrpf.isPresent())
		{
			customerDTO.setChdrpf(chdrpf.get());
		}
	}
}
