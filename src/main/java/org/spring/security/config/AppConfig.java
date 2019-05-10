package org.spring.security.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.spring.security")
@PropertySource("classpath:database.properties")
public class AppConfig {
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/jsp/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }

    @Autowired
    private Environment environment;
    @Bean
    public DataSource dataSource(){
        ComboPooledDataSource comboPooledDataSource= new ComboPooledDataSource();
        try{
           comboPooledDataSource.setDriverClass(environment.getProperty("jdbc.driver"));
           comboPooledDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
           comboPooledDataSource.setUser(environment.getProperty("jdbc.username"));
           comboPooledDataSource.setPassword(environment.getProperty("jdbc.password"));
           comboPooledDataSource.setInitialPoolSize(Integer.parseInt(environment.getProperty("connection.pool.intialPoolSize")));
           comboPooledDataSource.setMinPoolSize(Integer.parseInt(environment.getProperty("connection.pool.minPoolSize")));
           comboPooledDataSource.setMaxPoolSize(Integer.parseInt(environment.getProperty("connection.pool.maxPoolSize")));
           comboPooledDataSource.setMaxIdleTime(Integer.parseInt(environment.getProperty("connection.pool.maxIdleTime")));

        }catch (Exception e){
            e.printStackTrace();
        }
        return comboPooledDataSource;
    }
}


