package com.couchbase.sample.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.couchbase.sample.repository.DataManager;

/**
 * This is a sample class to shows how to set values into couchabase and get values 
 * from couchbase using a repository class which has couchbase template.
 */
@Component
public class CouchbaseSampleClient {

	/** The Constant logger. */
	public static final Logger logger = LoggerFactory.getLogger(CouchbaseSampleClient.class);

	/** The Constant KEY_PREFIX. */
	public static final String KEY_PREFIX = "key_";
	
	/** The data manager. */
	@Autowired
	private DataManager dataManager;

	/**
	 * Sets the data to couchbase.
	 *
	 * @param key the key
	 * @param value the value
	 */
	public void setDataToCouchbase(String key, String value) {
		//set the value into couchbase
		dataManager.setValue(key, value);
		logger.info("Set => Key : {}; Value : {}", key, value);
	}

	/**
	 * Gets the data from couchbase.
	 *
	 * @param key the key
	 * @return the data from couchbase
	 */
	public void getDataFromCouchbase(String key) {
		String value = (String)dataManager.getValue(key);
		logger.info("Get => Key : {}; Value : {}", key, value);
	}

	/**
	 * Delete data from couchbase.
	 *
	 * @param key the key
	 */
	public void deleteDataFromCouchbase(String key) {
		//delete the key from couchbase
		dataManager.deleteKey(key);
	}
}
