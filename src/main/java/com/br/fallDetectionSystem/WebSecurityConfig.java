package com.br.fallDetectionSystem;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Autowired
    private DataSource dataSource;
     
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
            .dataSource(dataSource)
            .usersByUsernameQuery("select username, password, enabled from users where username=?")
            .authoritiesByUsernameQuery("select username, role from users where username=?")
        ;
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
        authorizeRequests()
        .antMatchers("/", "/home").permitAll()
        .antMatchers("/login").permitAll()
        .antMatchers("/registration").permitAll()
        .anyRequest().authenticated().and().csrf().disable()
        //To use Spring Security default login page leave loginPage() empty
        .formLogin().loginPage("/login").and().formLogin().permitAll()
        .failureUrl("/login?error=true")
        .defaultSuccessUrl("/home-logged")
        .usernameParameter("username")
        .passwordParameter("password")
        .and().logout().permitAll()
        //.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        .logoutSuccessUrl("/login").and().exceptionHandling()
        .accessDeniedPage("/access-denied");   
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }
}