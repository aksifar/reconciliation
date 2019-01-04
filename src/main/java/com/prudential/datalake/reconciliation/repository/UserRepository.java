package com.prudential.datalake.reconciliation.repository;

import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.repository.CrudRepository;

import com.prudential.datalake.reconciliation.model.User;

@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "user")
public interface UserRepository extends CrudRepository<User, String>{

}
