import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author joemsu 2017-12-11 下午4:50
 */
@SpringBootApplication
@ComponentScan("io.github.joemsu")
public class MultiDataSourceJtaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiDataSourceJtaApplication.class, args);
    }
}
