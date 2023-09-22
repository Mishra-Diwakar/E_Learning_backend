package com.clickncash.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {
		"com.clickncash.repository" }, entityManagerFactoryRef = "primaryEntityManagerFactory", transactionManagerRef = "primaryTransactionManager")
public class AppDatabaseConfig {

	@Bean
	@Primary
	@ConfigurationProperties("spring.datasource.primary")
	public DataSourceProperties memberDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.primary")
	public DataSource memberDataSource() {
		return memberDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}

	@Primary
	@Bean(name = "primaryEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(
			org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder builder) {
		return builder.dataSource(memberDataSource()).packages(new String[] { "com.clickncash.entity" })
				.persistenceUnit("mysql").build();
	}

	@Primary
	@Bean
	public PlatformTransactionManager primaryTransactionManager(
			final @Qualifier("primaryEntityManagerFactory") LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory) {
		return new JpaTransactionManager(primaryEntityManagerFactory.getObject());
	}
}