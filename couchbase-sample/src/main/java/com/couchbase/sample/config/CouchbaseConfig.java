package com.couchbase.sample.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration; 
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration; 
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories; 

import java.util.Collections;
import java.util.List;

/**
 * Configuration file for couchbase 
 */
@Configuration 
@EnableCouchbaseRepositories("com.couchbase.sample.repository")
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

	/** The couchbase host. */
	@Value("${couchbase.host}") 
	String couchbaseHost;
 
    /** The couchbase bucket. */
    @Value("${couchbase.bucket}") 
    String couchbaseBucket;
 
    /** The couchbase bucket password. */
    @Value("${couchbase.bucket.password}") 
    String couchbaseBucketPassword;
 
    /* (non-Javadoc)
     * @see org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration#bootstrapHosts()
     */
    @Override 
    protected List<String> bootstrapHosts() {
        return Collections.singletonList(couchbaseHost);
    } 
 
    /* (non-Javadoc)
     * @see org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration#getBucketName()
     */
    @Override 
    protected String getBucketName() {
        return couchbaseBucket;
    } 
 
    /* (non-Javadoc)
     * @see org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration#getBucketPassword()
     */
    @Override 
    protected String getBucketPassword() {
        return couchbaseBucketPassword;
    } 
}
