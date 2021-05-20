package com.mangachan.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/index.html").permitAll()
                .antMatchers("/employees").authenticated()
                .antMatchers("/info").hasAnyRole("ADMIN")
                .antMatchers("/info").hasAuthority("INFO")
//                .antMatchers("/info").hasAnyAuthority("INFO", "ROLE_ADMIN")
                .antMatchers("/self").hasAnyRole("USER")
                .and()
                .formLogin()
                .and()
                .httpBasic()
                .and()
                .logout().logoutSuccessUrl("/");
    }
}
