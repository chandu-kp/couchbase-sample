package com.couchbase.sample.repository;

import net.spy.memcached.internal.OperationFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.stereotype.Repository;

/**
 * Repository class which connects to couchbase via couchbase template.
 */
@Repository 
public class DataManager {

	public static final Logger logger = LoggerFactory.getLogger(DataManager.class);

	/** The Constant COUNTER_INITIAL_VALUE. */
	public static final long COUNTER_INITIAL_VALUE = 1l;

    /** The couchbase template. */
    @Autowired 
    private CouchbaseTemplate couchbaseTemplate;

    /**
     * Gets the value.
     *
     * @param key the key
     * @return the value
     */
    public Object getValue(String key) {
    	return couchbaseTemplate.getCouchbaseClient().get(key);
    }
    
    /**
     * Sets the value.
     *
     * @param key the key
     * @param value the value
     */
    public void setValue(String key, Object value) {
    	couchbaseTemplate.getCouchbaseClient().set(key, value);
    }

    /**
     * Increments a given couter.
     *
     * @param key the key
     * @return the long
     */
    public long increment(String key) {
    	return incrementBy(key, 1l);
    }

    /**
     * Increments given counter by given value. If key not present, initializes the key with default value.
     * Increment is atomic operation.
     *
     * @param key the key
     * @param value the value
     * @return the long
     */
    public long incrementBy(String key, long value) {
    	return couchbaseTemplate.getCouchbaseClient().incr(key, value, COUNTER_INITIAL_VALUE);
    }

    /**
     * Deletes the key
     * @param key
     */
    public void deleteKey(String key) {
    	OperationFuture<Boolean> b = couchbaseTemplate.getCouchbaseClient().delete(key);
    	logger.info("Delete - Key : {} & isSuccess : {} ", key, b.isDone());
    }
    
}
