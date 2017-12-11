package io.github.joemsu.customer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

/**
 * @author joemsu 2017-12-11 下午3:29
 */
@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "customerEntityManagerFactory",
        transactionManagerRef = "jtaTransactionManager",
        basePackages = "io.github.joemsu.customer.dao")
public class CustomerRepositoryConfig {


    @Autowired(required = false)
    private PersistenceUnitManager persistenceUnitManager;

    @Bean
    @Primary
    @ConfigurationProperties("io.github.joemsu.jpa")
    public JpaProperties customerJpaProperties() {
        return new JpaProperties();
    }

    @Bean
    public EntityManagerFactoryBuilder customerEntityManagerFactoryBuilder(
            @Qualifier("customerJpaProperties") JpaProperties customerJpaProperties) {
        AbstractJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        return new EntityManagerFactoryBuilder(adapter,
                customerJpaProperties.getProperties(), this.persistenceUnitManager);
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean customerEntityManagerFactory(
            @Qualifier("customerEntityManagerFactoryBuilder") EntityManagerFactoryBuilder builder,
            @Qualifier("customerDataSource") DataSource customerDataSource) {
        return builder
                .dataSource(customerDataSource)
                .packages("io.github.joemsu.customer.dao")
                .persistenceUnit("customer")
                .build();
    }

}
