package com.br.fallDetectionSystem.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
 
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
	
	  @Autowired private DataSource dataSource;
	 
	
	/*
	 * @Bean public DataSource dataSource() { EmbeddedDatabaseBuilder builder = new
	 * EmbeddedDatabaseBuilder(); return
	 * builder.setType(EmbeddedDatabaseType.HSQL).build(); }
	 * 
	 * @Bean public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	 * HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	 * vendorAdapter.setGenerateDdl(true); LocalContainerEntityManagerFactoryBean
	 * factory = new LocalContainerEntityManagerFactoryBean();
	 * factory.setJpaVendorAdapter(vendorAdapter);
	 * factory.setPackagesToScan("com.br.fallDetectionSystem");
	 * factory.setDataSource(dataSource()); return factory; }
	 * 
	 * @Bean public PlatformTransactionManager
	 * transactionManager(EntityManagerFactory entityManagerFactory) {
	 * JpaTransactionManager txManager = new JpaTransactionManager();
	 * txManager.setEntityManagerFactory(entityManagerFactory); return txManager; }
	 */
	  
     
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
            .dataSource(dataSource)
            .usersByUsernameQuery("select username, password, enabled from cuidador where username=?")
            .authoritiesByUsernameQuery("select username, role from cuidador where username=?")
        ;
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
        authorizeRequests()
        .antMatchers("/", "/home").permitAll()
        .antMatchers("/login").permitAll()
        .antMatchers("/registration").permitAll()
        .antMatchers("/new-event").permitAll()
        .anyRequest().authenticated().and().csrf().disable()
        //To use Spring Security default login page leave loginPage() empty
        .formLogin()
        	.loginPage("/login")
        	.loginProcessingUrl("/login")
        	.failureUrl("/error")
            .successHandler(myAuthenticationSuccessHandler())
        	//.defaultSuccessUrl("/home-logged", true)
        .and()
        .formLogin()
        	.permitAll()
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
    
    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
        return new UrlAuthenticationSuccessHandler();
    }
}