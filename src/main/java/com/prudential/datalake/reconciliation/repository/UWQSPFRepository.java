package com.prudential.datalake.reconciliation.repository;

import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbasePagingAndSortingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.prudential.datalake.reconciliation.model.UWQSPF;

@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "clntpf", viewName = "all")
public interface UWQSPFRepository extends CouchbasePagingAndSortingRepository<UWQSPF, String> {
	
	Page<UWQSPF> findAll(Pageable pageable);
	
}