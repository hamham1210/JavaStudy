package com.web.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {

	
	@Bean
	public SecurityFilterChain filter(HttpSecurity http)throws Exception{
		//인증방식과 인가정책을 지정...
		log.info("filter================================>");
		
		http.csrf((auth)->auth.disable());//csrf을 방어하기 위한 토큰을 주고받는 부분 비활성화
		http.formLogin((auth)->auth.disable());
		/*
		 * 1. security에서 제공하는 폼을 비활성화
		 * 2. React를 앞으로 사용하므로 CSR방식으로 서버에서 로그인 폼을 안 만들기때문
		 * 3. formLogin을  disable하면 인증 시큐리티 아키텍쳐에서 사용안하는 부분이 있다.
		 * 		UsernamePasswordAuthenticationFilter를 무력화 하는 인증방식으로 바뀐다.
		 * */
		http.httpBasic((auth)->auth.disable());
		
		//경로별 인가 작업
		http.authorizeHttpRequests((auth)->auth
									.requestMatchers("/index","/members","/members/**","/boards").permitAll()
									.requestMatchers("/admin").hasRole("ADMIN")
									.anyRequest().authenticated()//인증을 거쳐서 들어와야한다.
				);
		return http.build();
	}
	
	
	@Bean //암호화 하기 위한 빈
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		log.info("bCryptPasswordEncoder================================>");
		return new BCryptPasswordEncoder();
	}
}
