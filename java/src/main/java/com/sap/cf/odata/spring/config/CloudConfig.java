package com.sap.cf.odata.spring.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * @author fabiano.rosa
 *
 * https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html
 * http://www.baeldung.com/spring-eclipselink
 *
 */

@Configuration
@Profile("cloud")
@ComponentScan(basePackages = "com.sap.cf")
@EnableJpaRepositories(basePackages = "com.sap.cf.odata.spring.repository", entityManagerFactoryRef = "entityManagerFactory")
@EnableTransactionManagement
public class CloudConfig extends AbstractCloudConfig {
	private static final String HANA_SVC = "hanadb-hdi-container";
	private static final Logger logger = LoggerFactory.getLogger(CloudConfig.class);

	/**
	 * Create dataSource bean from SAP CF
	 * 
	 * @return dataSource dataSoruce created from HANA Service.
	 */
	@Bean
	public DataSource dataSource() {
		logger.info(">>>Enter dataSource!!!!!");

		CloudFactory cloudFactory = new CloudFactory();
		Cloud cloud = cloudFactory.getCloud();

		DataSource ds = cloud.getServiceConnector(HANA_SVC, DataSource.class, null);
		logger.info(">>>DataSource: " + ds);
		
		return ds;
	}

	/**
	 * Create Eclipselink EMF from the dataSource bean. JPAvendor and datasource
	 * will be set here. rest will be taken from persistence.xml
	 * 
	 * @return EntityManagerFactory
	 */
	@Bean(name = "entityManagerFactory")
	public EntityManagerFactory entityManagerFactory() {
		logger.info(">>>Enter entityManagerFactory!!!!!");

		LocalContainerEntityManagerFactoryBean springEMF = new LocalContainerEntityManagerFactoryBean();
		//springEMF.setJpaVendorAdapter(new EclipseLinkJpaVendorAdapter());
		
		DataSource ds = dataSource();
		logger.info(">>>DataSource: " + ds);
		springEMF.setDataSource(ds);
		
		springEMF.setPersistenceUnitName("pu-cf");
		springEMF.afterPropertiesSet();

		return springEMF.getObject();
	}
	
	@Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		logger.info(">>>Enter transactionManager!!!!!");
		
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        
        transactionManager.setEntityManagerFactory(emf);
        logger.info(">>>transactionManager: " + transactionManager);
        
        return transactionManager;
    }
}
