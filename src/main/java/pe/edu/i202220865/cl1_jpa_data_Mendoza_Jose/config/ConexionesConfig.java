package pe.edu.i202220865.cl1_jpa_data_Mendoza_Jose.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConexionesConfig {

    @Value("${DB_WORLD_URL}")
    private String bdWorldUrl;
    @Value("${DB_ WORLD_USER}")
    private String bdWorldUser;
    @Value("${DB_ WORLD_PASS}")
    private String bdWorldPass;
    @Value("${DB_ WORLD_DRIVER}")
    private String bdWorldDriver;

    @Bean
    public HikariDataSource hikariDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(bdWorldUrl);
        config.setUsername(bdWorldUser);
        config.setPassword(bdWorldPass);
        config.setDriverClassName(bdWorldDriver);

        // configuracion de HikariCP
        config.setMaximumPoolSize(30);
        config.setMinimumIdle(4);
        config.setIdleTimeout(240000);
        config.setConnectionTimeout(45000);

        return new HikariDataSource(config);
    }

}