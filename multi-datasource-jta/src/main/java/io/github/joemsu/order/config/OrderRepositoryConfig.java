package io.github.joemsu.order.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
        entityManagerFactoryRef = "orderEntityManagerFactory",
        transactionManagerRef = "jtaTransactionManager",
        basePackages = "io.github.joemsu.order.dao")
public class OrderRepositoryConfig {

    @Autowired(required = false)
    private PersistenceUnitManager persistenceUnitManager;

    @Bean
    @ConfigurationProperties("io.github.joemsu.jpa")
    public JpaProperties orderJpaProperties() {
        return new JpaProperties();
    }

    @Bean
    public EntityManagerFactoryBuilder orderEntityManagerFactoryBuilder(
            @Qualifier("orderJpaProperties") JpaProperties orderJpaProperties) {
        AbstractJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        return new EntityManagerFactoryBuilder(adapter,
                orderJpaProperties.getProperties(), this.persistenceUnitManager);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean orderEntityManagerFactory(
            @Qualifier("orderEntityManagerFactoryBuilder") EntityManagerFactoryBuilder builder,
            @Qualifier("orderDataSource") DataSource orderDataSource) {
        return builder
                .dataSource(orderDataSource)
                .packages("io.github.joemsu.order.dao")
                .persistenceUnit("orders")
                .build();
    }


}
