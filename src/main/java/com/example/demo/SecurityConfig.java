package com.example.demo;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure( final HttpSecurity http ) throws Exception
    {
        // This configuration does not work as no LogoutHandler's are configured
        http.csrf().disable()
            .authorizeRequests()
            .anyRequest()
            .permitAll();

        // This configuration works as the WebSecurityConfigurerAdapter defaults
        // configure csrf which includes a CsrfLogoutHandler
//        http.authorizeRequests()
//            .anyRequest()
//            .permitAll();

        // It is not unique to CsrfFilter as this works by adding an arbitrary LogoutHandler
//        http.csrf().disable()
//            .logout().addLogoutHandler( (req, resp, auth) -> {} ).and()
//            .authorizeRequests()
//            .anyRequest()
//            .permitAll();
    }
}
