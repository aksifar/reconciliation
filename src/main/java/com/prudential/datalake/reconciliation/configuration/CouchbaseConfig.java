package com.prudential.datalake.reconciliation.configuration;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;
import org.springframework.data.couchbase.repository.config.RepositoryOperationsMapping;
import org.springframework.data.couchbase.repository.support.IndexManager;

import com.couchbase.client.java.Bucket;
import com.prudential.datalake.reconciliation.model.transformed.Customer;

@Configuration
@EnableCouchbaseRepositories(basePackages={"com.prudential.datalake.reconciliation.repository"})
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

	@Value("${spring.couchbase.host}")
	private String host; 
	
	@Value("${spring.couchbase.transformedBucket.name}")
	private String transformedBucketName; 
	
	@Value("${spring.couchbase.transformedBucket.password}")
	private String transformedBucketPassword;
	
	@Value("${spring.couchbase.rawBucket.name}")
	private String rawBucketName; 
	
	@Value("${spring.couchbase.rawBucket.password}")
	private String rawBucketPassword;
	
	@Override
	protected List<String> getBootstrapHosts() {
		//TODO: implementation to handle comma separated hosts
		return Arrays.asList(host);
	}

	@Override
	protected String getBucketName() {
		return rawBucketName;
	}

	@Override
	protected String getBucketPassword() {
		return rawBucketPassword;
	}

	@Bean
	public Bucket transformedBucket() throws Exception {
		return couchbaseCluster().openBucket(transformedBucketName, transformedBucketPassword);
	}

	@Bean
	public CouchbaseTemplate transformedTemplate() throws Exception {
		CouchbaseTemplate template = new CouchbaseTemplate(couchbaseClusterInfo(), // reuse the default bean
				transformedBucket(), // the bucket is non-default
				mappingCouchbaseConverter(), translationService() // default beans here as well
		);
		template.setDefaultConsistency(getDefaultConsistency());
		return template;
	}

	@Override
	public void configureRepositoryOperationsMapping(RepositoryOperationsMapping baseMapping)
	{
		try
		{
			baseMapping // this is already using couchbaseTemplate as default
			.mapEntity(Customer.class, transformedTemplate()); // every repository dealing with User will be backed by userTemplate()
		}
		catch (Exception e) 
		{   //TODO:  log this
			e.printStackTrace();
		} 
	}
	
	@Override
	public IndexManager indexManager() {
	return new IndexManager(true, false, false);
	}
}
