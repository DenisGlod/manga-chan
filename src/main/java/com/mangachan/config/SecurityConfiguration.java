package com.mangachan.config;

import com.mangachan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/index.html", "/login.html").permitAll()
                .antMatchers("/info.html").authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login.html")
                    .loginProcessingUrl("/login")
                    .usernameParameter("login")
                    .passwordParameter("password")
                    .defaultSuccessUrl("/info.html")
                .and()
                    .logout()
                    .deleteCookies("mangachan")
                    .invalidateHttpSession(true)
                    .logoutSuccessUrl("/")
                .and()
                    .httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(@Autowired UserService userService) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(userService);
        return authenticationProvider;
    }
}
