package com.sap.cf.odata.spring.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizers;
import org.springframework.context.annotation.Configuration;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.jta.JtaTransactionManager;

/**
 * 
 * @author fabiano.a.rosa
 * http://www.baeldung.com/spring-eclipselink
 * 
 */
@Configuration
public class JpaConfiguration extends JpaBaseConfiguration {
	private static final Logger logger = LoggerFactory.getLogger(JpaConfiguration.class);
	
    protected JpaConfiguration(DataSource dataSource, JpaProperties properties, ObjectProvider<JtaTransactionManager> jtaTransactionManager, ObjectProvider<TransactionManagerCustomizers> transactionManagerCustomizers) {
        super(dataSource, properties, jtaTransactionManager, transactionManagerCustomizers);
        logger.debug(">>>Enter JpaConfiguration dataSource: " + dataSource);
        logger.debug(">>>Enter JpaConfiguration properties: " + properties);
        logger.debug(">>>Enter JpaConfiguration jtaTransactionManager: " + jtaTransactionManager);
    }

    @Override
    protected AbstractJpaVendorAdapter createJpaVendorAdapter() {
    	logger.debug(">>>Enter createJpaVendorAdapter!!!!!");
        return new EclipseLinkJpaVendorAdapter();
    }

    @Override
    protected Map<String, Object> getVendorProperties() {
        HashMap<String, Object> map = new HashMap<>();
        map.put(PersistenceUnitProperties.WEAVING, detectWeavingMode());
        //map.put(PersistenceUnitProperties.DDL_GENERATION, "drop-and-create-tables");
        
        logger.debug(">>>Enter createJpaVendorAdapter: " + map);
        
        return map;
    }

    private String detectWeavingMode() {
    	logger.info(">>>Enter detectWeavingMode!!!!!");
    	
        return InstrumentationLoadTimeWeaver.isInstrumentationAvailable() ? "true" : "static";
    }
}
