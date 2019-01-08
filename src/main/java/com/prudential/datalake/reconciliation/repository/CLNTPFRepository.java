package com.prudential.datalake.reconciliation.repository;

import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbasePagingAndSortingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.prudential.datalake.reconciliation.model.CLNTPF;

@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "clntpf", viewName = "all")
public interface CLNTPFRepository extends CouchbasePagingAndSortingRepository<CLNTPF, String> {
	
	Page<CLNTPF> findAll(Pageable pageable);
	
}