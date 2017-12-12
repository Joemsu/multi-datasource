package io.github.joemsu.config;

import com.atomikos.icatch.jta.UserTransactionManager;
import com.atomikos.jdbc.AtomikosDataSourceBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;

/**
 * @author joemsu 2017-12-11 下午5:16
 */
@Configuration
public class DataSourceConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.jta.atomikos.datasource.customer")
    public DataSource customerDataSource() {
        return new AtomikosDataSourceBean();
    }


    @Bean
    @ConfigurationProperties(prefix = "spring.jta.atomikos.datasource.order")
    public DataSource orderDataSource() {
        return new AtomikosDataSourceBean();
    }


    @Bean(destroyMethod = "close", initMethod = "init")
    public UserTransactionManager userTransactionManager() {
        UserTransactionManager userTransactionManager = new UserTransactionManager();
        userTransactionManager.setForceShutdown(false);
        return userTransactionManager;
    }

    /**
     * jta transactionManager
     *
     * @return
     */
    @Bean(name = "jtaTransactionManager")
    @Primary
    public JtaTransactionManager transactionManager() {
        JtaTransactionManager jtaTransactionManager = new JtaTransactionManager();
        jtaTransactionManager.setTransactionManager(userTransactionManager());
        return jtaTransactionManager;
    }
}
