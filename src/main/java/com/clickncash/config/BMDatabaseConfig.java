package com.clickncash.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
/*@EnableJpaRepositories(basePackages = {
		"com.vandiest.bm.repository" }, entityManagerFactoryRef = "secondaryEntityManagerFactory", transactionManagerRef = "secondaryTransactionManager")*/
public class BMDatabaseConfig {

	/*@Bean
	@ConfigurationProperties("spring.datasource.secondary")
	public DataSourceProperties secondaryDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.secondary")
	public DataSource secondaryDataSource() {
		return secondaryDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}

	@Bean(name = "secondaryEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory(
			org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder builder) {
		return builder.dataSource(secondaryDataSource()).packages(new String[] { "com.vandiest.bm.entity" })
				.persistenceUnit("sqlserver").build();
	}

	@Bean
	public PlatformTransactionManager secondaryTransactionManager(
			final @Qualifier("secondaryEntityManagerFactory") LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory) {
		return new JpaTransactionManager(secondaryEntityManagerFactory.getObject());
	}*/
}