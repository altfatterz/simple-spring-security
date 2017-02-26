package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Zoltan Altfatter
 */
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER").and()
                .withUser("attacker").password("evil").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off

		http
			.authorizeRequests()
				.anyRequest().authenticated()
				.and()
			.formLogin().and()
			.httpBasic().and()
            // until here this is the default set by the WebSecurityConfigurerAdapter#configure method

            // example turning off session fixation support, default is changeSessionId
            .sessionManagement().sessionFixation().none()

            .and()

            // by default spring security logout should be a POST request with sending CSRF tokens
            // by disabling the csrf we allow to logout using a GET request.
            .csrf().disable();

        // @formatter:on
    }
}
