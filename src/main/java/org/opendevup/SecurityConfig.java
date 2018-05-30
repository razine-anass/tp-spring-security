package org.opendevup;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)//active l'annotation @secured
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth,DataSource dataSource) throws Exception {
		/*
		 * 	auth.inMemoryAuthentication().withUser("admin").password("12").roles("ADMIN","PROF");
		auth.inMemoryAuthentication().withUser("prof1").password("12").roles("PROF");
		auth.inMemoryAuthentication().withUser("etud1").password("12").roles("ETUDIANT");
		auth.inMemoryAuthentication().withUser("sco1").password("12").roles("SCOLARITE");
		 */
		//requets sql que Spring Securite doit executer afin de recuperer les utilisateurs et les roles
	auth.jdbcAuthentication()
	.dataSource(dataSource)
	.usersByUsernameQuery("Select usename as principal,password as credentials,true from users where usename = ?")
	.authoritiesByUsernameQuery("Select user_usename as  principal,roles_role as role from users_roles where user_usename = ?")
	.rolePrefix("ROLE_");

	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
				 .anyRequest()
				 .authenticated()
				 .and()
			.formLogin()
				.loginPage("/login").permitAll()
				.defaultSuccessUrl("/index.html")
				.failureUrl("/error.html");
	}
	
	

	
}
