package com.umar.apps.auth.security;

import com.umar.apps.auth.RestAuthenticationEntryPoint;
import com.umar.apps.filter.CustomFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
@Order(99)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired private RestAuthenticationEntryPoint entryPoint;
    @Autowired private CustomFilter customFilter;

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        var encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser("user1")
                .password(encoder.encode("user1Pass"))
                .authorities("ROLE_USER")
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/private/**")
                .hasRole("USER")
                .antMatchers("/", "/home", "/public/**")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .authenticationEntryPoint(entryPoint);
        http.addFilterAfter(customFilter, BasicAuthenticationFilter.class);
    }
}
