package io.github.joemsu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author joemsu 2017-12-11 下午3:19
 */
@SpringBootApplication
@ComponentScan("io.github.joemsu")
public class MultiDatasourceProblemsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiDatasourceProblemsApplication.class, args);
    }
}
