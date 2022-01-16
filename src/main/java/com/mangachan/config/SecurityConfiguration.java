package com.mangachan.config;

import com.mangachan.dao.entity.User;
import com.mangachan.service.UserService;
import com.mangachan.service.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
        http
            .authorizeRequests()
                /*.antMatchers("/").permitAll()
                .anyRequest().authenticated()*/
				.anyRequest().permitAll()
                .and()
/*            .formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/info.html")
                .usernameParameter("login")
                .passwordParameter("password")
                .permitAll()
                .and()
            .logout()
				.logoutSuccessUrl("/")
				.deleteCookies("mangachan")
				.invalidateHttpSession(true)
                .and()*/
            .httpBasic()
                .and()
            .csrf().disable();
        // @formatter:on
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setSkipNullEnabled(true);
		return modelMapper;
	}

	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider(@Autowired UserService userService) {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		authenticationProvider.setUserDetailsService(userService);
		return authenticationProvider;
	}
}
