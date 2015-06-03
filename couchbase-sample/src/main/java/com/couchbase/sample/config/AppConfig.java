package com.couchbase.sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.couchbase.sample.client.CouchbaseSampleClient;

/**
 * The Common configuration file.
 */
@Configuration
@EnableScheduling
@ComponentScan(basePackages = { "com.couchbase.sample" })
@PropertySource(value="classpath:app.properties")
public class AppConfig {

    /**
     * Properties place holder configurer.
     *
     * @return the property sources placeholder 
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertiesPlaceHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

	/**
	 * Couchbase sample client.
	 *
	 * @return the couchbase sample client
	 */
	@Bean(name = { "couchbaseSampleClient" })
	public CouchbaseSampleClient couchbaseSampleClient() {
		return new CouchbaseSampleClient();
	}
}
