package com.web.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import lombok.extern.slf4j.Slf4j;

@EnableWebSecurity
@Configuration
@Slf4j
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		log.info("SecurityFilterChain=========>");
		http
        //.csrf(Customizer.withDefaults())
        .authorizeHttpRequests(auth -> auth
            .anyRequest().authenticated()
        )//어떤 요청에도 무조건 인증 받도록
        //.httpBasic(Customizer.withDefaults())
        //.formLogin(Customizer.withDefaults());//폼 로그인 방식으로 인증받겠다.
        .formLogin(form->form
        		//.loginPage("/loginPage")//커스터마이징은 했지만 페이지 이동은 안해서 Security가 제공하는 폼을 쓰겠다.
        		.loginProcessingUrl("/loginProc")
        		.usernameParameter("usrId")
        		.passwordParameter("pwd")
        		.defaultSuccessUrl("/",false)
        		//기본이 false,true는 항상 사용
        		.failureUrl("/failed")
        		
        		.successHandler((request,response,authentication)->{
        			response.sendRedirect("/home");
        		})
        		.failureHandler((request,response,authentication)->{
        			response.sendRedirect("/login");
        		})
        		.permitAll()
        		);
		log.info("SecurityFilterChain=========>");
        return http.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		log.info("UserDetailsService =========>");
		UserDetails user = User.withUsername("kosta")
								.password("{noop}7777")
								.roles("USER").build();
		log.info("UserDetailsService =========> user {}",user);
		
		return new InMemoryUserDetailsManager(user);
		
	}
	
	
}
