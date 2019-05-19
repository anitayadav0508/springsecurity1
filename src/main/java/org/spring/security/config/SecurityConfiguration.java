package org.spring.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;

import static org.hibernate.criterion.Restrictions.and;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//        We are using in-memory username and password
     /*   User.UserBuilder us=User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication().withUser(us.username("anita").password("anita").roles("MANAGER"));*/

     auth.jdbcAuthentication().dataSource(dataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //it provides authorizations

      /*  http.authorizeRequests()
                .antMatchers("/employee").hasRole("EMPLOYEE")
                .antMatchers("/director").hasRole("MANAGER")
                .antMatchers("/").hasRole("EMPLOYEE")
                .antMatchers("/").hasRole("MANAGER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll();*/
        http.authorizeRequests()
                .antMatchers("/register").hasRole("EMPLOYEE")
                .antMatchers("/login").hasRole("MANAGER")
                .antMatchers("/register").hasRole("EMPLOYEE")
                .antMatchers("/register").hasRole("MANAGER")
                .antMatchers("/login").hasRole("EMPLOYEE")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/loginValid")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }
}
