import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.core.env.Environment;

@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
@ComponentScan("java")
public class DatabaseConfig {

    @Resource
    private Environment env;

    @Bean
    public DataSource dataSource () {
    return null;
    }
}