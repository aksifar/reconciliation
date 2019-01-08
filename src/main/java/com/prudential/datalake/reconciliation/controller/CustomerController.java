package com.prudential.datalake.reconciliation.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prudential.datalake.reconciliation.DTO.CustomerDTO;
import com.prudential.datalake.reconciliation.constants.CustomerConstants;
import com.prudential.datalake.reconciliation.exception.NoDocumentsFoundException;
import com.prudential.datalake.reconciliation.model.transformed.Customer;
import com.prudential.datalake.reconciliation.repository.TransformedCustomerRepository;
import com.prudential.datalake.reconciliation.service.RawCustomerService;
import com.prudential.datalake.reconciliation.service.TransformedCustomerService;

@RestController
@CrossOrigin("*")
@RequestMapping("/customers")
public class CustomerController {

	@Autowired TransformedCustomerService tCustomerService;
	@Autowired RawCustomerService rawCustomerService;
	@Autowired TransformedCustomerRepository tr;
	
	@GetMapping("/{customerId}")
	public ResponseEntity<CustomerDTO> getCustomerDetailsFromAllBuckets(@PathVariable String customerId) throws NoDocumentsFoundException
	{
		CustomerDTO customerDTO = rawCustomerService.findAllById(customerId);
		customerDTO.setCustomer(tCustomerService.findOne("PRU::"+customerId));
		customerDTO.setId(customerId);
		return new ResponseEntity<CustomerDTO>(customerDTO,HttpStatus.OK);
	}
	
	/**Return Customers from Raw + Transformed bucket
	 * @param pageNumber
	 * @param pageSize
	 * @param sortDirection
	 * @param sortColumn
	 * @return
	 * @throws NoDocumentsFoundException
	 */
	@GetMapping
	public ResponseEntity<Page<CustomerDTO>> getAllCustomerByPage(
			@RequestParam(value = "page", defaultValue = "0", required = false) int pageNumber,
			@RequestParam(value = "size", defaultValue = "5", required = false) int pageSize,
			@RequestParam(value="sortDirection", defaultValue="desc",required=false) String sortDirection,
			@RequestParam(value="sortBy", defaultValue="id",required=false) String sortColumn) throws NoDocumentsFoundException
	{
		//TODO:  need to figure out the correct property instead of id
		Sort sort = new Sort(Direction.fromString(sortDirection), sortColumn);
		Pageable pageRequest = PageRequest.of(pageNumber, pageSize, sort);

		Page<Customer> customerPage = tCustomerService.findAll(pageRequest);
	
		if(null != customerPage && !customerPage.isEmpty())
		{
			Page<CustomerDTO> customerDTOPage = customerPage.map(this::makeCustomerDTO);
			return new ResponseEntity<Page<CustomerDTO>>(customerDTOPage, HttpStatus.OK);
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
	
	private CustomerDTO makeCustomerDTO(final Customer customer) {
		String id = customer.getId();
		String replaceAll = id.replaceAll(CustomerConstants.PREFIX_CUSTOMER_ID, "");
	    final CustomerDTO customerDTO = rawCustomerService.findAllById(replaceAll);
	    customerDTO.setCustomer(customer);
	    return customerDTO;
	}
}
