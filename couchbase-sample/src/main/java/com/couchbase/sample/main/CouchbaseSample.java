package com.couchbase.sample.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.couchbase.sample.client.CouchbaseSampleClient;
import com.couchbase.sample.config.AppConfig;
import com.couchbase.sample.config.CouchbaseConfig;

/**
 * Main class 
 */
public class CouchbaseSample {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(
				new Class[] { AppConfig.class, CouchbaseConfig.class });
		
		@SuppressWarnings("unused")
		CouchbaseSampleClient couchbaseSampleClient = (CouchbaseSampleClient)context.getBean("couchbaseSampleClient");
	}
}
