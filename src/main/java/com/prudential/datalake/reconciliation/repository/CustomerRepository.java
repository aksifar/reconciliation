package com.prudential.datalake.reconciliation.repository;

import java.util.List;

import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbasePagingAndSortingRepository;

import com.prudential.datalake.reconciliation.model.transformed.Customer;


@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "customer")
public interface CustomerRepository extends CouchbasePagingAndSortingRepository<Customer, String>{
	List<Customer> findAll();
}

