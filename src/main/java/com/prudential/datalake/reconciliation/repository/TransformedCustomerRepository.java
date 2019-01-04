package com.prudential.datalake.reconciliation.repository;

import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbasePagingAndSortingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.prudential.datalake.reconciliation.model.transformed.Customer;

@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "customer", viewName = "all")
public interface TransformedCustomerRepository extends CouchbasePagingAndSortingRepository<Customer, String> {
	
	Page<Customer> findAll(Pageable pageable);
	
}