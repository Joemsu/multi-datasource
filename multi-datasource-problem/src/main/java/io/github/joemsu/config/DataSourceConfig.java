package io.github.joemsu.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author joemsu
 */
@Configuration
public class DataSourceConfig {

    /**
     *
     * @return 不指定@Primary在启动的时候 DataSourceInitializer 注入 DataSource会报错
     */
    @Primary
    @Bean(name = "customerDataSource")
    @ConfigurationProperties(prefix = "io.github.joemsu.customer.datasource")
    public DataSource customerDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "orderDataSource")
    @ConfigurationProperties(prefix = "io.github.joemsu.order.datasource")
    public DataSource orderDataSource() {
        return DataSourceBuilder.create().build();
    }

}
