package ru.webcalculate.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(value = "ru.webcalculate")
@EnableJpaRepositories(value = "ru.webcalculate.repositories")
@EnableTransactionManagement
public class JapConfiduration {
    @Autowired
    private DataSource dataSource;


    @Bean

    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        LocalContainerEntityManagerFactoryBean emf =

                new LocalContainerEntityManagerFactoryBean();



        emf.setDataSource(dataSource);

        emf.setPackagesToScan("ru.webcalculate.models");



        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();

        adapter.setDatabase(Database.POSTGRESQL);



        emf.setJpaVendorAdapter(adapter);

        emf.setJpaProperties(jpaProperties());



        return emf;

    }



    @Bean

    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {

        JpaTransactionManager transactionManager = new JpaTransactionManager();

        transactionManager.setEntityManagerFactory(entityManagerFactory);

        return transactionManager;

    }



    public Properties jpaProperties() {

        Properties properties = new Properties();

        properties.setProperty("hibernate.dialect",

                "org.hibernate.dialect.PostgreSQL95Dialect");

        properties.setProperty("hibernate.show_sql",

                "true");

        properties.setProperty("hibernate.hbm2ddl.auto", "update");

        return properties;

    }


}
